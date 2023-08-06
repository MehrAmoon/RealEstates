package com.amoon.aviv.realestate.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RealEstatesDao {

    @Query("SELECT * FROM RealEstatesEntity")
    fun getAll(): List<RealEstatesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(realEstatesEntity: List<RealEstatesEntity>)
}