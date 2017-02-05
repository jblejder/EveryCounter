package com.project.blejder.everycounter.domain.models;

import java.util.UUID;

public class UserSettings {
    private UUID userMainCounterUUid;

    public UUID getUserMainCounterUUid() {
        return userMainCounterUUid;
    }

    public void setUserMainCounterUUid(UUID userMainCounterUUid) {
        this.userMainCounterUUid = userMainCounterUUid;
    }
}
