package com.partyMaker.partyMaker.service;

public enum OperationProgressDescription {
    OK("Done"),
    USER_ISSUE("User not found"),
    PARTY_ISSUE("Party not found"),
    LIMIT_ISSUE("Not enough place");

    private String description;

    OperationProgressDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
