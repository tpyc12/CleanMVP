package com.myhome.android.clean.model.repository

import com.myhome.android.clean.model.data.DataModel
import com.myhome.android.clean.model.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}