package com.dslplatform.compiler.client.api.params;

public class PackageName implements Param {
    public final String packageName;

    public PackageName(
            final String packageName) {
        this.packageName = packageName;
    }

    // -------------------------------------------------------------------------

    @Override
    public boolean allowMultiple() {
        return false;
    }

    // format: OFF
    @Override
    public void addToPayload(
            final XMLOut xO) {
        if (packageName != null && !packageName.isEmpty()) {
            xO.node("package-name", packageName);
        }
    }
}
