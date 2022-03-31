package com.udacity.shoestore.ui.shoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {

    private val sharedViewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail,
            container, false
        )
        binding.shoe = Shoe("", 0.0, "", "")
        binding.shoeListViewModel = sharedViewModel

        return binding.root

    }
}