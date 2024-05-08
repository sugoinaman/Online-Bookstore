package org.example.onlinebookstore.others;

public enum Role {
    USER {
        @Override
        boolean isAdmin() {
            return false;
        }
    },
    ADMIN {
        @Override
        boolean isAdmin() {
            return true;
        }
    };

    abstract boolean isAdmin();
}
