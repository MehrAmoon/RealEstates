package com.amoon.aviv.realestate.data.mappers

interface Mapper<F,T> {
    fun map(data:F):T
}