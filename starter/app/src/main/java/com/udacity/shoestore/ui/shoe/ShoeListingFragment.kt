package com.udacity.shoestore.ui.shoe

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import coil.load
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.databinding.ItemShoeBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListingFragment : Fragment() {

    private val sharedViewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_listing,
            container,
            false
        )
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        sharedViewModel.shoe.onEach {
            for (shoe in it) {
                DataBindingUtil.inflate<ItemShoeBinding>(
                    layoutInflater, R.layout.item_shoe, binding.fragmentList, true
                )
                    .apply {
                        this.shoe = shoe
                        this.image.load("https://www.pngplay.com/wp-content/uploads/6/Flat-Shoes-Icon-PNG-Clipart-Background.png")
                    }
            }
        }.launchIn(lifecycleScope)

        binding.addButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_shoeListingFragment_to_shoeDetailFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
        return super.onOptionsItemSelected(item)
    }
}