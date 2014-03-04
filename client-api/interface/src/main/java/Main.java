import com.dslplatform.client.Bootstrap;
import com.dslplatform.compiler.client.api.model.Json;
import com.dslplatform.compiler.client.api.model.Client.Project;
import com.dslplatform.patterns.ServiceLocator;

public class Main {
    public static void main(final String[] args) throws Exception {
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "trace");

        final ServiceLocator serviceLocator =
                Bootstrap.init(System.getProperty("user.home") + "/.config/dsl-compiler-client/dsl-project.ini");

        final Json json = new Json(serviceLocator);
        System.out.println(json.deserialize(json.serialize(new Project()), Project.class));

//        DslPlatformProxy dpp = new DslPlatformProxy("marko@element.hr", "platformtesting");
//        testCreateTestProjectByName(dpp);
    }

//    public static void testAll(final DslPlatformProxy dpp) throws Exception {
//        final String testProjectName = makeName();
//        dpp.doCreate(testProjectName);
//        final ProjectDetails pd = dpp.getProjectByName(testProjectName);
//
//        dpp.doClean(pd.getProjectName());
//        dpp.doCloneProject(pd.getProjectName());
//        dpp.doCreateExternalProject("noname", "noname", "noname", new DatabaseConnection());
//        dpp.doDeleteProject(pd.getProjectName());
//    }
//
//    public static void testCreateTestProjectByName(final DslPlatformProxy dpp) throws Exception {
//        final String testProjectName = makeName();
//        dpp.doCreate(testProjectName);
//        final ProjectDetails pd = dpp.getProjectByName(testProjectName);
//
//        System.out.println("Name: " +  pd.getProjectName());
//        System.out.println("Id: " + pd.getID());
//        System.out.println("Created at: " + pd.getCreatedAt());
//        dpp.shutdown();
//    }
//
//    private static String makeName() {
//        return "BlackHawkDown - " + new java.util.Random().nextInt(1000);
//    }
}

