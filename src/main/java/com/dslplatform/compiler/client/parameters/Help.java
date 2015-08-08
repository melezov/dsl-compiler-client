package com.dslplatform.compiler.client.parameters;

import com.dslplatform.compiler.client.*;

import java.util.List;

public class Help implements CompileParameter {

	private final List<CompileParameter> parameters;

	public Help(List<CompileParameter> parameters) {
		this.parameters = parameters;
	}

	@Override
	public String getAlias() { return "help"; }
	@Override
	public String getUsage() { return "command"; }

	private CompileParameter from(final String value) {
		for (final CompileParameter cp : parameters) {
			if (cp.getAlias().equalsIgnoreCase(value)) {
				return cp;
			}
		}
		return null;
	}

	@Override
	public boolean check(final Context context) throws ExitException {
		if (context.contains(this)) {
			final String value = context.get(this);
			final CompileParameter input = from(value);
			if (input == null) {
				context.error("Unknown command: " + value);
				throw new ExitException();
			}
			final String help = input.getDetailedDescription();
			if (help == null) {
				context.error("Sorry, no detailed info about:" + value);
			} else {
				final int len;
				if (input.getShortDescription() != null) {
					len = value.length() + 2 + input.getShortDescription().length();
					context.show(value + ": " + input.getShortDescription());
				} else {
					len = value.length();
					context.show(value);
				}
				final StringBuilder sb = new StringBuilder(len);
				for (int i = 0; i < len; i++) {
					sb.append("=");
				}
				context.show(sb.toString());
				context.show();
				context.show(input.getDetailedDescription());
			}
			throw new ExitException();
		}
		return true;
	}

	@Override
	public void run(final Context context) {}

	@Override
	public String getShortDescription() {
		return "Show detailed description of a command";
	}

	@Override
	public String getDetailedDescription() {
		return "Recursion detected...";
	}
}
