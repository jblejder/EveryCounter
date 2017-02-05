package com.project.blejder.everycounter.domain.userCases;


import com.project.blejder.everycounter.domain.models.GroupModel;

import java.util.List;

import io.reactivex.Observable;

public class LoadGroups extends UseCase<Void, List<GroupModel>> {

    @Override
    protected Observable<List<GroupModel>> buildUseCase(Void arg) {
        return null;
    }
}
