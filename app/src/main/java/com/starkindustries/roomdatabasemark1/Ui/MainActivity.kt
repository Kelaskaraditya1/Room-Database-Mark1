package com.starkindustries.roomdatabasemark1.Ui
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.room.Room
import com.starkindustries.roomdatabasemark1.Keys.Keys
import com.starkindustries.roomdatabasemark1.Model.User
import com.starkindustries.roomdatabasemark1.R
import com.starkindustries.roomdatabasemark1.Room.DatabaseHandler
import com.starkindustries.roomdatabasemark1.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.util.Date

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var database:DatabaseHandler
    lateinit var userList:List<User>
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        database= DatabaseHandler.getDatabase(applicationContext)
        GlobalScope.launch {
            database.userDao().insertUser(User("Mayur","2021FHCO055","mayur1","mayur1@gmail.com","Mayur@1234"))
        }
        binding.userButton.setOnClickListener()
        {
            database.userDao().getUsersList().observe(this, Observer {
                Log.d("ValueListner",""+it.toString())
            })
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}