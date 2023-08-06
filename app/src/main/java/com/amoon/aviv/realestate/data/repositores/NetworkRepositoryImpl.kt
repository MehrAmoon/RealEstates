package com.amoon.aviv.realestate.data.repositores

import com.amoon.aviv.realestate.data.network.RealEstateServices
import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import com.amoon.aviv.realestate.domain.repositores.DatabaseRepository
import com.amoon.aviv.realestate.domain.repositores.NetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val realEstateServices: RealEstateServices,
    private val databaseRepository: DatabaseRepository,
) : NetworkRepository {
    override fun getRealEstatesList(): Flow<List<RealEstatesModel>> {
        return flow {

            databaseRepository.getAll().let {
                emit(it)
            }

            val items = realEstateServices.listing().items
            val realEstate = items.map { listingDetails ->
                RealEstatesModel(
                    id = listingDetails.id,
                    bedrooms = listingDetails.bedrooms ?: 0,
                    city = listingDetails.city ?: "",
                    area = listingDetails.area ?: 0,
                    url = listingDetails.url ?: "",
                    price = listingDetails.price ?: 0,
                    professional = listingDetails.professional ?: "",
                    propertyType = listingDetails.propertyType ?: "",
                    offerType = listingDetails.offerType ?: 0,
                    rooms = listingDetails.rooms ?: 0,
                )
            }

            databaseRepository.insert(realEstate)
            emit(realEstate)

        }.catch { e ->

        }.flowOn(Dispatchers.IO)
    }
}