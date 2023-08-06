package com.amoon.aviv.realestate.domain.usecases

import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import com.amoon.aviv.realestate.domain.repositores.NetworkRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

open class RealEstatesListingUseCase @Inject constructor(
    private val networkRepository: NetworkRepository
) {

    open fun listRealEstates(): Flow<List<RealEstatesModel>> {
        return networkRepository.getRealEstatesList()
    }
}