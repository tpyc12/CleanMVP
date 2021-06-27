package com.myhome.android.clean.model.repository

import com.myhome.android.clean.model.data.DataModel
import com.myhome.android.clean.model.datasource.DataSource
import io.reactivex.Observable

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    private val cache = mutableMapOf<String, List<DataModel>>()

    override fun getData(word: String): Observable<List<DataModel>> {
        if (cache.containsKey(word)) return Observable.just(cache[word])
        return dataSource.getData(word)
            .doOnNext { cache[word] = it }
    }
}