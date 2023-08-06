package com.amoon.aviv.realestate.data.repositores

import com.amoon.aviv.realestate.data.database.AppDatabase
import com.amoon.aviv.realestate.data.mappers.RealEstatesEntityToRealEstatesModelMapper
import com.amoon.aviv.realestate.data.mappers.RealEstatesModelToRealEstatesEntityMapper
import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import com.amoon.aviv.realestate.domain.repositores.DatabaseRepository
import com.amoon.aviv.realestate.presentation.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DatabaseRepositoryImpl@Inject constructor(
    private val database: AppDatabase,
    private val realEstatesEntityToRealEstatesModelMapper: RealEstatesEntityToRealEstatesModelMapper,
    private val realEstatesModelToRealEstatesEntityMapper: RealEstatesModelToRealEstatesEntityMapper,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) :
    DatabaseRepository {

    override fun getAll(): List<RealEstatesModel> {
        val result = database.realEstatesDao().getAll()
        return result.map { list ->
             realEstatesEntityToRealEstatesModelMapper.map(list) }
    }

    override suspend fun insert(realEstatesModel: List<RealEstatesModel>) = withContext(dispatcher) {
        val model =
            realEstatesModel.map {
                realEstatesModelToRealEstatesEntityMapper.map(data = it)
            }

        return@withContext database.realEstatesDao().insertAll(model)
    }

}