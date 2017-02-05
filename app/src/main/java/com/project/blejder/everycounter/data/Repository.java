package com.project.blejder.everycounter.data;


import com.project.blejder.everycounter.data.exceptions.NotFoundException;
import com.project.blejder.everycounter.domain.models.CounterModel;
import com.project.blejder.everycounter.domain.models.GroupModel;
import com.project.blejder.everycounter.domain.models.UserSettings;

import java.util.List;
import java.util.UUID;

public interface Repository {

    void saveCounter(CounterModel counterModel);

    List<CounterModel> getCountersFromGroup(UUID uuid);

    CounterModel getCounterWithUuid(UUID uuid) throws NotFoundException;

    List<GroupModel> getGroups();

    UserSettings getUserSettings();

    void saveUserSettings(UserSettings userSettings);

    void saveGroup(GroupModel group);
}
