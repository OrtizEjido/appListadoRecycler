package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configAdapter()
        configRecyclerView()
    }

    fun configAdapter(){
        itemAdapter =ItemAdapter(mutableListOf(Persona("Isra",
            "https://scontent.ftij3-2.fna.fbcdn.net/v/t1.0-9/79433219_10215602920092530_3190569975421075456_o.jpg?_nc_cat=106&_nc_sid=09cbfe&_nc_ohc=PrkzO6PUnPcAX_0oibU&_nc_ht=scontent.ftij3-2.fna&oh=14c15cc56596e27edbad7a8e944c6aa2&oe=5F507065"),
                                                Persona("Nieto",
                                                    "https://scontent.ftij3-2.fna.fbcdn.net/v/t1.0-9/75496031_2354578764857391_959384913834934272_o.jpg?_nc_cat=105&_nc_sid=09cbfe&_nc_ohc=yQHwsltieV8AX8gaoMz&_nc_ht=scontent.ftij3-2.fna&oh=28f232f280cedfb26d08572706fd0fd2&oe=5F531176"))
        )
    }

    fun configRecyclerView() {
        itemAdapter.add(Persona("Ortiz",
            "https://scontent.ftij3-2.fna.fbcdn.net/v/t1.0-9/84319854_3602515649823664_4873148921439846400_o.jpg?_nc_cat=108&_nc_sid=09cbfe&_nc_ohc=LK6Zm7X72wAAX_YNC0v&_nc_ht=scontent.ftij3-2.fna&oh=6abfed68ac0d2a9421c54f5c531a394d&oe=5F4F0328"))
        rvPersona.layoutManager = LinearLayoutManager(this)
        rvPersona.adapter = itemAdapter
    }

}