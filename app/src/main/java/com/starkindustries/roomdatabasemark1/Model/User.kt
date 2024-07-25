package com.starkindustries.roomdatabasemark1.Model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.starkindustries.roomdatabasemark1.Keys.Keys
import java.util.Date
@Entity(tableName = Keys.TABLE_NAME)
data class User(
    @ColumnInfo(name=Keys.NAME)
    var name:String,
    @PrimaryKey
    @ColumnInfo(name=Keys.SID)
    var sid:String,
    @ColumnInfo(name = Keys.USERNAME)
     var username:String,
    @ColumnInfo(name = Keys.EMAIL)
     var email:String,
    @ColumnInfo(name = Keys.PASSOWRD)
     var password:String
)
