package com.project.blejder.everycounter.domain.userCases;

import com.project.blejder.everycounter.data.RepositoryImpl;
import com.project.blejder.everycounter.data.exceptions.NotFoundException;
import com.project.blejder.everycounter.domain.factories.CounterFactory;
import com.project.blejder.everycounter.domain.factories.GroupFactory;
import com.project.blejder.everycounter.domain.models.CounterModel;
import com.project.blejder.everycounter.domain.models.GroupModel;
import com.project.blejder.everycounter.domain.models.UserSettings;

import java.util.UUID;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class LoadMainCounter extends UseCase<Void, CounterModel> {

    private final RepositoryImpl repository;

    @Inject
    public LoadMainCounter(RepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    protected Observable<CounterModel> buildUseCase(Void aVoid) {
        return Observable.create(new ObservableOnSubscribe<CounterModel>() {
            @Override
            public void subscribe(ObservableEmitter<CounterModel> emitter) throws Exception {
                UserSettings userSettings        = repository.getUserSettings();
                UUID         userMainCounterUUid = userSettings.getUserMainCounterUUid();

                CounterModel counter;
                if (userMainCounterUUid == null) {
                    CounterWithGroup counterWithGroup = createNewCounterWithGroup();
                    emitter.onNext(counterWithGroup.counterModel);
                    saveData(counterWithGroup, userSettings);
                } else {
                    try {
                        counter = repository.getCounterWithUuid(userMainCounterUUid);
                        emitter.onNext(counter);
                    } catch (NotFoundException e) {
                        CounterWithGroup counterWithGroup = createNewCounterWithGroup();
                        emitter.onNext(counterWithGroup.counterModel);
                        saveData(counterWithGroup, userSettings);
                    }
                }
                emitter.onComplete();
            }
        });
    }

    private void saveData(CounterWithGroup counterWithGroup, UserSettings userSettings) {
        userSettings.setUserMainCounterUUid(counterWithGroup.counterModel.getUuid());
        repository.saveCounter(counterWithGroup.counterModel);
        repository.saveGroup(counterWithGroup.groupModel);
        repository.saveUserSettings(userSettings);
    }

    private CounterWithGroup createNewCounterWithGroup() {
        CounterModel counter = CounterFactory.createCounter();
        GroupModel   group   = GroupFactory.createGroup();
        counter.setGroupUuid(group.getUuid());
        return new CounterWithGroup(counter, group);
    }

    private static class CounterWithGroup {
        CounterModel counterModel;
        GroupModel   groupModel;

        CounterWithGroup(CounterModel counterModel, GroupModel groupModel) {
            this.counterModel = counterModel;
            this.groupModel = groupModel;
        }
    }
}
