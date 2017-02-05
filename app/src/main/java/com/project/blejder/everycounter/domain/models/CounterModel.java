package com.project.blejder.everycounter.domain.models;

import java.util.UUID;

public class CounterModel {

    private UUID uuid;
    private UUID groupUuid;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getGroupUuid() {
        return groupUuid;
    }

    public void setGroupUuid(UUID groupUuid) {
        this.groupUuid = groupUuid;
    }
}
