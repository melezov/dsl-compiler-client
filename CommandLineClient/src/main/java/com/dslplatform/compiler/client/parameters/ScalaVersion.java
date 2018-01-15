package com.dslplatform.compiler.client.parameters;

import com.dslplatform.compiler.client.CompileParameter;
import com.dslplatform.compiler.client.Context;
import com.dslplatform.compiler.client.Either;
import com.dslplatform.compiler.client.Utils;

import java.io.File;

public enum ScalaVersion implements CompileParameter {
	INSTANCE;

	@Override
	public String getAlias() { return "scala-version"; }
	@Override
	public String getUsage() { return "2.11"; }

	@Override
	public boolean check(final Context context) {
		if (context.contains(INSTANCE)) {
			final String path = context.get(INSTANCE);
			final File scalac = new File(path);
			if (!Utils.testCommand(context, scalac.getAbsolutePath(), "Usage: scalac")) {
				context.error("scalac parameter is set, but Scala compiler not found/doesn't work. Please check specified scalac parameter.");
				context.error("Trying to use: " + scalac.getAbsolutePath());
				return false;
			}
		}
		return true;
	}

	@Override
	public void run(final Context context) {
	}

	@Override
	public String getShortDescription() {
		return "Specify Scala version to target";
	}

	@Override
	public String getDetailedDescription() {
		return "By default, code uses Scala version 2.11";
	}
}
