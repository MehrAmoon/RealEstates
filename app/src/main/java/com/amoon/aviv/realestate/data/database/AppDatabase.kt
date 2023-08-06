package com.amoon.aviv.realestate.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RealEstatesEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun realEstatesDao(): RealEstatesDao
}