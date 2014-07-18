package com.dslplatform.compiler.client.parameters;

import com.dslplatform.compiler.client.CompileParameter;
import com.dslplatform.compiler.client.Context;
import com.dslplatform.compiler.client.InputParameter;

import java.io.File;

public enum SqlPath implements CompileParameter {
	INSTANCE;

	@Override
	public boolean check(final Context context) {
		if (context.contains(InputParameter.SQL)) {
			final String value = context.get(InputParameter.SQL);
			if (value != null && value.length() > 0) {
				final File sqlPath = new File(value);
				if (!sqlPath.exists()) {
					context.error("SQL path provided (" + sqlPath.getAbsolutePath() + ") but doesn't exists.");
					context.error("Specify existing path or remove parameter to use temporary folder.");
					return false;
				}

			}
		}
		return true;
	}

	@Override
	public void run(final Context context) {
	}

	@Override
	public String getShortDescription() {
		return "Where to save SQL migration";
	}

	@Override
	public String getDetailedDescription() {
		return "SQL migration script which contains DDL changes..\n" +
				"When deploying changes to the production, previously created SQL script should be applied.\n" +
				"SQL path can be specified so created/applied SQL scripts can be stored and used later.";
	}
}