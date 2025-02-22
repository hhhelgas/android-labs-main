package com.example.alexklim_23

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = view.findViewById<TextView>(R.id.textViewDetail)
        val text = view.findViewById<TextView>(R.id.textViewDetailText)
        val button = view.findViewById<Button>(R.id.button)

        val itemName = arguments?.getString("item_name")
        val itemDescription = arguments?.getString("item_description")
        val itemText = arguments?.getString("item_text")

        textView.text = "$itemName\n\n$itemDescription"
        text.text = itemText
        button.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}
