package com.example.contactskotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.contactskotlin.R
import com.example.contactskotlin.fragment.AboutFragment
import com.example.contactskotlin.fragment.ListFragment
import com.example.contactskotlin.listener.Listener
import com.example.contactskotlin.model.Contact

class ContactActivity : AppCompatActivity(), Listener {

    private lateinit var aboutFragment: AboutFragment
    private lateinit var listFragment: ListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        init()
    }

    fun init() {
        aboutFragment = AboutFragment()
        listFragment = ListFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.contact_about, aboutFragment)
            .replace(R.id.contact_list, listFragment)
            .commit()
    }

    override fun onSend(contact: Contact) {
        aboutFragment.setData(contact)
    }
}
