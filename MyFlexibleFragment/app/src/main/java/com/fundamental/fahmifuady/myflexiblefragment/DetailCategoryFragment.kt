package com.fundamental.fahmifuady.myflexiblefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_detail_category.*


class DetailCategoryFragment : Fragment(), View.OnClickListener {

    lateinit var tvcategoryname: TextView
    lateinit var tvcategorydescription: TextView
    lateinit var btnprofile: Button
    lateinit var btnshowdialog: Button

    var description: String? = null
    companion object{
        var Extra_name = "extra_name"
        var Extra_description = "extra_description"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvcategoryname = view.findViewById(R.id.tvCategoryName)
        tvcategorydescription = view.findViewById(R.id.tvCategoryDescription)

        btnprofile = view.findViewById(R.id.btn_profile)
        btnprofile.setOnClickListener(this)

        btnshowdialog = view.findViewById(R.id.btn_show_dialog)
        btnshowdialog.setOnClickListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (savedInstanceState != null) {
            val descFormBundle = savedInstanceState.getString(Extra_description)
            description = descFormBundle
        }

        if (arguments != null) {
            val categoryname = arguments?.getString(Extra_name)
            tvCategoryName.text = categoryname
            tvCategoryDescription.text = description
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {

        }
    }


}