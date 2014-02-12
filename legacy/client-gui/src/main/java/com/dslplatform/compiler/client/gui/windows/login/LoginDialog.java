package com.dslplatform.compiler.client.gui.windows.login;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.dslplatform.compiler.client.api.ApiCall;
import com.dslplatform.compiler.client.gui.icon.Icon;
import com.dslplatform.compiler.client.gui.icon.IconUpdater;
import com.dslplatform.compiler.client.gui.windows.login.LoginResponse.Status;
import com.dslplatform.compiler.client.io.Logger;

public class LoginDialog extends JFrame implements ActionListener,
        MouseListener, WindowListener, KeyEventDispatcher {

    private LoginResponse response = new LoginResponse(Status.CANCELED,
            "Login process interupted");
    private LoginRequest request = null;
    private boolean isProcessFinished = false;

    private static final int WIDTH = 350;
    private static final int HEIGHT = 270;

    private final JLabel labelLoginImage;
    private final JLabel labelUsername;
    private final JTextField textUsername;
    private final JLabel labelPassword;
    private final JPasswordField textPassword;
    private final JCheckBox checkRemember;
    private final JLabel labelProgressMessage;
    private final JButton buttonLogin;

    public static LoginDialogResult show(
            final Logger logger,
            final ApiCall apiCall,
            final String defaultUsername,
            final String defaultPassword,
            final boolean remember) {

        final LoginDialog ld = new LoginDialog(logger, apiCall,
                defaultUsername, defaultPassword, remember);

        try {
            return new LoginDialogResult(ld.getRequest(), ld.getResponse());
        } catch (final InterruptedException e) {
            return new LoginDialogResult(null, new LoginResponse(Status.ERROR,
                    e.getMessage()));
        }
    }

    private final Logger logger;
    private final ApiCall apiCall;

    private LoginDialog(
            final Logger logger,
            final ApiCall apiCall,
            final String defaultUsername,
            final String defaultPassword,
            final boolean remember) {
        super("DSL Platform - GUI Client");

        this.logger = logger;
        this.apiCall = apiCall;

        new IconUpdater(this);
        addWindowListener(this);

        final KeyboardFocusManager manager = KeyboardFocusManager
                .getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(this);

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        getContentPane().setLayout(null);
        setResizable(false);

        final GraphicsDevice gd = GraphicsEnvironment
                .getLocalGraphicsEnvironment().getDefaultScreenDevice();

        final int screenWidth = gd.getDisplayMode().getWidth();
        final int screenHeight = gd.getDisplayMode().getHeight();

        // format: OFF

        setBounds(
                screenWidth - WIDTH >>> 1,
                screenHeight - HEIGHT >>> 1,
                WIDTH,
                HEIGHT);

        labelLoginImage = new JLabel(Icon.LOGIN.icon);
        labelLoginImage.setBounds(
                WIDTH - Icon.LOGIN.width >>> 1,
                20,
                Icon.LOGIN.width,
                Icon.LOGIN.height);
        getContentPane().add(labelLoginImage);

        labelUsername = new JLabel("E-mail");
        labelUsername.setHorizontalAlignment(SwingConstants.RIGHT);
        labelUsername.setBounds(0, 112, (WIDTH >>> 2) - 5, 20);
        labelUsername.addMouseListener(this);
        getContentPane().add(labelUsername);

        textUsername = new JTextField();
        textUsername.setBounds(
                WIDTH >>> 2,
                112,
                (WIDTH * 3 >>> 2) - (WIDTH >>> 3),
                20);
        if (defaultUsername != null) {
            textUsername.setText(defaultUsername);
        }
        getContentPane().add(textUsername);

        labelPassword = new JLabel("Password");
        labelPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        labelPassword.setBounds(0, 136, (WIDTH >>> 2) - 5, 20);
        labelPassword.addMouseListener(this);
        getContentPane().add(labelPassword);

        textPassword = new JPasswordField();
        textPassword.setBounds(
                WIDTH >>> 2,
                136,
                (WIDTH * 3 >>> 2) - (WIDTH >>> 3),
                20);
        if (defaultPassword != null) {
            textPassword.setText(defaultPassword);
        }
        getContentPane().add(textPassword);

        checkRemember = new JCheckBox("Remember?");
        checkRemember.setBounds(0, 190, WIDTH * 5 >>> 4, 30);
        checkRemember.setHorizontalAlignment(SwingConstants.CENTER);
        checkRemember.setSelected(remember);
        checkRemember.setVisible(false);
        getContentPane().add(checkRemember);

        labelProgressMessage = new JLabel();
        labelProgressMessage.setHorizontalAlignment(SwingConstants.CENTER);
        labelProgressMessage.setBounds(0, 160, WIDTH, 20);
        getContentPane().add(labelProgressMessage);

        buttonLogin = new JButton("Log in");
        buttonLogin.addActionListener(this);
        buttonLogin.setBounds(WIDTH * 5 >>> 4, 190, WIDTH * 3 >>> 3, 30);
        getContentPane().add(buttonLogin);
        getRootPane().setDefaultButton(buttonLogin);

        setRequest(new LoginRequest(defaultUsername, defaultPassword, remember));
        setVisible(true);

        (textUsername.getText().isEmpty()
                ? textUsername
                : textPassword.getPassword().length == 0
                        ? textPassword
                        : buttonLogin).requestFocusInWindow();
    }

    private static final long serialVersionUID = 0L;

    private void displayMessage(final Status status, final String message) {
        final Color color =
                status == Status.PENDING ? Color.blue :
                status == Status.EMPTY   ? Color.red :
                status == Status.INVALID ? Color.red :
                status == Status.ERROR   ? Color.red :
                status == Status.SUCCESS ? Color.green.darker()
                                         : Color.black;

        labelProgressMessage.setForeground(color);
        labelProgressMessage.setText(message);
    }

    private void EnableInteraction(
            final boolean enable) {
        textUsername.setEnabled(enable);
        textPassword.setEnabled(enable);
        buttonLogin.setEnabled(enable);
    }

    public void DoLoginProcess(
            final LoginRequest request) {
        setRequest(request);

        EnableInteraction(false);
        getContentPane().setCursor(
                Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        final LoginWorker loginProcess =
                new LoginWorker(logger, apiCall, request.username,
                        request.password);

        loginProcess.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(
                    final PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("Auth")) {
                    final LoginResponse response =
                            (LoginResponse) evt.getNewValue();
                    displayMessage(response.status, response.message);
                    setResponse(response);
                } else if (loginProcess.isDone()) {
                    EnableInteraction(true);
                    getContentPane().setCursor(
                            Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }
            }
        });

        loginProcess.execute();
    }

    public synchronized LoginResponse getResponse() throws InterruptedException {
        while (!isProcessFinished) {
            wait();
        }
        return response;
    }

    public synchronized LoginRequest getRequest() throws InterruptedException {
        while (!isProcessFinished) {
            wait();
        }
        return request;
    }

    private void setRequest(
            final LoginRequest request) {
        this.request = request;
    }

    private void setResponse(
            final LoginResponse response) {
        this.response = response;
        if (response.ok) {
            finish();
        }
    }

    @Override
    public void actionPerformed(
            final ActionEvent e) {
        if (e.getSource() == buttonLogin) {
            final String username = textUsername.getText();
            final String password = new String(textPassword.getPassword());

            if (username.isEmpty()) {
                displayMessage(Status.EMPTY, "E-mail cannot be empty!");
                return;
            }

            if (password.isEmpty()) {
                displayMessage(Status.EMPTY, "Password cannot be empty!");
                return;
            }

            DoLoginProcess(new LoginRequest(username, password,
                    checkRemember.isSelected()));
        }
    }

    public synchronized void finish() {
        setVisible(false);
        isProcessFinished = true;
        notify();
        dispose();
    }

    @Override
    public void mouseClicked(
            final MouseEvent e) {}

    @Override
    public void mousePressed(
            final MouseEvent e) {
        if (e.getSource() == labelUsername) {
            textUsername.selectAll();
            textUsername.requestFocus();
        } else if (e.getSource() == labelPassword) {
            textPassword.selectAll();
            textPassword.requestFocus();
        }
    }

    @Override
    public void mouseReleased(
            final MouseEvent e) {}

    @Override
    public void mouseEntered(
            final MouseEvent e) {}

    @Override
    public void mouseExited(
            final MouseEvent e) {}

    @Override
    public void windowOpened(
            final WindowEvent e) {}

    @Override
    public void windowClosing(
            final WindowEvent e) {
        if (!isProcessFinished) {
            logger.warn("Process not finished, closing of the dialog was initiated by the user!");
            response =
                    new LoginResponse(Status.CANCELED,
                            "Login process canceled by user!");
        }
        finish();
    }

    @Override
    public void windowClosed(
            final WindowEvent e) {
        logger.debug("Login window closed.");
    }

    @Override
    public void windowIconified(
            final WindowEvent e) {}

    @Override
    public void windowDeiconified(
            final WindowEvent e) {}

    @Override
    public void windowActivated(
            final WindowEvent e) {}

    @Override
    public void windowDeactivated(
            final WindowEvent e) {
        if (checkRemember != null) {
            checkRemember.setVisible(false);
        }
    }

    @Override
    public boolean dispatchKeyEvent(
            final KeyEvent e) {
        switch (e.getID()) {
            case KeyEvent.KEY_PRESSED:
                // if (e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
                // Temporarily disabled, TODO disable remember me if unchecked
                // if (e.isControlDown()) checkRemember.setVisible(true);
                return false;

            case KeyEvent.KEY_RELEASED:
                // checkRemember.setVisible(false);
                return false;

            default:
                return false;
        }
    }
}
