package com.project.blejder.everycounter.domain.factories;

import com.project.blejder.everycounter.domain.models.GroupModel;

import java.util.UUID;

public class GroupFactory {
    public static GroupModel createGroup() {
        GroupModel groupModel = new GroupModel();
        groupModel.setUuid(UUID.randomUUID());
        return groupModel;
    }
}
