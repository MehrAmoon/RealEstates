package com.amoon.aviv.realestate.data.mappers

import com.amoon.aviv.realestate.data.database.RealEstatesEntity
import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import javax.inject.Inject


class RealEstatesEntityToRealEstatesModelMapper @Inject constructor() : Mapper<RealEstatesEntity, RealEstatesModel> {
    override fun map(data: RealEstatesEntity): RealEstatesModel {
       return RealEstatesModel(
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