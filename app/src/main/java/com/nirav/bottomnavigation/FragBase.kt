package com.example.bottomnavigationdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class FragBase<actBinding : ViewBinding> : Fragment() {

    lateinit var binding: actBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = setViewBinding()
        bindObjects()
        bindListener()
        bindMethod()
        return binding.root
    }

    abstract fun setViewBinding(): actBinding
    abstract fun bindObjects()
    abstract fun bindListener()
    abstract fun bindMethod()
}