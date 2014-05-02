package com.dslplatform.compiler.client.api.diff;

public enum ChangeAction {
    SKIPPED("skipping"),
    NO_CHANGE("up to date"),
    CREATED("creating"),
    CREATED_DIR("creating directory"),
    MODIFIED("modifying"),
    MOVED("moving"),
    MOVED_DIR("moving directory"),
    COPIED("copying"),
    COPIED_DIR("copying directory"),
    DELETED("deleting"),
    DELETED_DIR("deleting directory");

    private String description;

    private ChangeAction(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
