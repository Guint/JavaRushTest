package org.gvp.boookmanager.support.search;

public enum SearchField {
    TITLE("title"), AUTHOR("author");

    private final String value;

    SearchField(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
