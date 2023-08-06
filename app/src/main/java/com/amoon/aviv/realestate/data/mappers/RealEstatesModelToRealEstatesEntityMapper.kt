package com.amoon.aviv.realestate.data.mappers

import com.amoon.aviv.realestate.data.database.RealEstatesEntity
import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import javax.inject.Inject

class RealEstatesModelToRealEstatesEntityMapper @Inject constructor() : Mapper<RealEstatesModel , RealEstatesEntity> {
    override fun map(data: RealEstatesModel): RealEstatesEntity {
        return RealEstatesEntity(
            id= data.id,
            bedrooms= data.bedrooms,
            city= data.city,
            area= data.area,
            url= data.url,
            price= data.price,
            professional= data.professional,
            propertyType= data.propertyType,
            offerType= data.offerType,
            rooms= data.rooms,
        )
    }
}