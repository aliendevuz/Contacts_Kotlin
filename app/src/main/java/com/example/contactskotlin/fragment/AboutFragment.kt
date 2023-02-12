package com.example.contactskotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.contactskotlin.R
import com.example.contactskotlin.model.Contact

class AboutFragment : Fragment() {

    lateinit var image: ImageView
    lateinit var name: TextView
    lateinit var phone: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_about, container, false)
        init(view)
        return view
    }

    private fun init(view: View) {
        image = view.findViewById(R.id.about_image)
        name = view.findViewById(R.id.about_name)
        phone = view.findViewById(R.id.about_phone)
    }

    fun setData(contact: Contact) {
        image.setImageResource(contact.image)
        name.text = contact.name
        phone.text = contact.phone
    }
}
