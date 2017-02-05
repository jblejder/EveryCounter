package com.project.blejder.everycounter.domain.models;

import com.google.common.base.Optional;

import java.util.UUID;

public class GroupModel {

    private UUID   uuid;
    private String name;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Optional<String> getName() {
        return Optional.fromNullable(name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
