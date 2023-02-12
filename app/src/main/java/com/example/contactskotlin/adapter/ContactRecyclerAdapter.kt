package com.example.contactskotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contactskotlin.R
import com.example.contactskotlin.listener.Listener
import com.example.contactskotlin.model.Contact

class ContactRecyclerAdapter(
    contacts: ArrayList<Contact>,
    listener: Listener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var contacts: ArrayList<Contact>
    var listener: Listener

    init {
        this.contacts = contacts
        this.listener = listener
    }

    class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var item: LinearLayout
        var itemName: TextView
        var itemPhone: TextView

        init {
            item = view.findViewById(R.id.item)
            itemName = view.findViewById(R.id.item_name)
            itemPhone = view.findViewById(R.id.item_phone)
        }
    }

    private fun init(holder: ContactViewHolder, contact: Contact) {
        holder.itemName.text = contact.name
        holder.itemPhone.text = contact.phone
        holder.item.setOnClickListener { v: View? ->
            sendData(
                contact
            )
        }
    }

    private fun sendData(contact: Contact) {
        listener.onSend(contact)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ContactViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ContactViewHolder) init(
            holder,
            contacts[position]
        )
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}