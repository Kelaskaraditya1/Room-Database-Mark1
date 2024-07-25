package com.starkindustries.roomdatabasemark1.Room
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.starkindustries.roomdatabasemark1.Keys.Keys
import com.starkindustries.roomdatabasemark1.Model.User
@Database(entities = [User::class], version = 1)
abstract class DatabaseHandler: RoomDatabase() {
    abstract fun userDao():UsersDao
    companion object{
        @Volatile
        private var INSTANCE:DatabaseHandler?=null
        fun getDatabase(context:Context):DatabaseHandler
        {
            if(INSTANCE==null)
            {
                synchronized(this)
                {
                    INSTANCE=Room.databaseBuilder(context.applicationContext,DatabaseHandler::class.java,Keys.DATABASE_NAME).build()
                }
            }
            return INSTANCE!!
        }
    }
}