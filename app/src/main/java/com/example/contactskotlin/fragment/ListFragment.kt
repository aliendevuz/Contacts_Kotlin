package com.example.contactskotlin.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactskotlin.R
import com.example.contactskotlin.adapter.ContactRecyclerAdapter
import com.example.contactskotlin.listener.Listener
import com.example.contactskotlin.model.Contact

class ListFragment : Fragment() {

    lateinit var list: RecyclerView
    lateinit var contacts: ArrayList<Contact>
    lateinit var listener: Listener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_list, container, false)
        init(view)
        return view
    }

    private fun init(view: View) {
        contacts = ArrayList()
        list = view.findViewById(R.id.account_list)
        list.layoutManager = GridLayoutManager(context, 1)
        load()
        val adapter = ContactRecyclerAdapter(contacts, listener)
        list.adapter = adapter
    }

    private fun load() {
        contacts.add(Contact(R.drawable.image1, "Agent 007", "+998 (99) 007 07 07"))
        contacts.add(Contact(R.drawable.image2, "Alan", "+998 (95) 474 71 17"))
        contacts.add(Contact(R.drawable.image3, "Walker", "+998 (95) 474 17 71"))
        contacts.add(Contact(R.drawable.image4, "Alien", "+998 (95) 065 08 20"))
        contacts.add(Contact(R.drawable.image5, "ASUS", "+998 (95) 551 03 64"))
        contacts.add(Contact(R.drawable.image6, "Bill", "+998 (78) 224 84 27"))
        contacts.add(Contact(R.drawable.image7, "iPhone", "+998 (93) 093 18 22"))
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Listener) {
            listener = context
        } else {
            throw RuntimeException("$context must implements Listener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null!!
    }
}
