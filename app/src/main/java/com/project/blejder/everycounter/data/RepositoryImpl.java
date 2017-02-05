package com.project.blejder.everycounter.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.google.gson.Gson;
import com.project.blejder.everycounter.data.exceptions.NotFoundException;
import com.project.blejder.everycounter.data.models.CountersList;
import com.project.blejder.everycounter.data.models.GroupsList;
import com.project.blejder.everycounter.domain.models.CounterModel;
import com.project.blejder.everycounter.domain.models.GroupModel;
import com.project.blejder.everycounter.domain.models.UserSettings;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

public class RepositoryImpl implements Repository {

    private final SharedPreferences sharedPreferences;

    @Inject
    public RepositoryImpl(Context c) {
        sharedPreferences = c.getSharedPreferences(Consts.SharedPrefName, Context.MODE_PRIVATE);
    }

    @Override
    public void saveCounter(CounterModel counterModel) {
        String dataRaw = sharedPreferences.getString(Consts.Counters, null);
        Gson   gson    = new Gson();

        CountersList counters = gson.fromJson(dataRaw, CountersList.class);
        if (counters == null) {
            counters = new CountersList();
        }

        for (int i = 0; i < counters.size(); i++) {
            CounterModel model = counters.get(i);
            if (model.getUuid().equals(counterModel.getUuid())) {
                counters.remove(i);
                break;
            }
        }
        counters.add(counterModel);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        String json = gson.toJson(counters);
        editor.putString(Consts.Counters, json);
        editor.apply();
    }

    @Override
    public List<CounterModel> getCountersFromGroup(UUID groupId) {
        String dataRaw = sharedPreferences.getString(Consts.Counters, null);
        Gson   gson    = new Gson();

        CountersList counters = gson.fromJson(dataRaw, CountersList.class);
        if (counters == null) {
            return new CountersList();
        }

        return Stream.of(counters).filter(value -> value.getUuid().equals(groupId))
                .collect(Collectors.toList());
    }

    @Override
    public CounterModel getCounterWithUuid(UUID uuid) throws NotFoundException {
        String dataRaw = sharedPreferences.getString(Consts.Counters, null);
        Gson   gson    = new Gson();

        CountersList counters = gson.fromJson(dataRaw, CountersList.class);
        if (counters == null) {
            throw new NotFoundException(Consts.Errors.EmptyDatabase);
        }

        for (CounterModel counter : counters) {
            if (counter.getUuid().equals(uuid)) {
                return counter;
            }
        }
        throw new NotFoundException(Consts.Errors.NoSuchAItem);
    }

    @Override
    public List<GroupModel> getGroups() {
        return null;
    }

    @Override
    public void saveUserSettings(UserSettings userSettings) {
        String dataRaw = new Gson().toJson(userSettings);

        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(Consts.UserData, dataRaw);
        edit.apply();
    }

    @Override
    public void saveGroup(GroupModel group) {
        String dataRaw = sharedPreferences.getString(Consts.Groups, null);
        Gson   gson    = new Gson();

        GroupsList groups = gson.fromJson(dataRaw, GroupsList.class);
        if (groups == null) {
            groups = new GroupsList();
        }

        for (int i = 0; i < groups.size(); i++) {
            GroupModel model = groups.get(i);
            if (model.getUuid().equals(group.getUuid())) {
                groups.remove(i);
                break;
            }
        }
        groups.add(group);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        String json = gson.toJson(groups);
        editor.putString(Consts.Groups, json);
        editor.apply();
    }

    @Override
    public UserSettings getUserSettings() {
        String dataRaw = sharedPreferences.getString(Consts.UserData, null);
        Gson   gson    = new Gson();

        UserSettings userSettings = gson.fromJson(dataRaw, UserSettings.class);
        if (userSettings == null) {
            return new UserSettings();
        }
        return userSettings;
    }
}
