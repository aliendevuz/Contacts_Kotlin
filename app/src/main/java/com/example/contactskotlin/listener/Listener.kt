package com.example.contactskotlin.listener

import com.example.contactskotlin.model.Contact

interface Listener {
    fun onSend(contact: Contact)
}
