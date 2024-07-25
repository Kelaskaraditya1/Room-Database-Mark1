package com.starkindustries.roomdatabasemark1.Converter
import androidx.room.TypeConverter
import java.util.Date
class TypeConverter {
    @TypeConverter
    fun dateToLong(value: Date):Long
    {
        return value as Long
    }
    @TypeConverter
    fun longToDate(value:Long):Date
    {
        return value as Date
    }
}