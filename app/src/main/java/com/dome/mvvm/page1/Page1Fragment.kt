package com.dome.mvvm.page1


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dome.mvvm.R
import com.dome.mvvm.databinding.ListSampleFragmentBinding
import kotlinx.android.synthetic.main.fragment_page1.*


/**
 * A simple [Fragment] subclass.
 *
 */
class Page1Fragment : Fragment() {

    private lateinit var binding: ListSampleFragmentBinding
    private lateinit var viewModel: Page1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.list_sample_fragment, container, false)

        binding.lifecycleOwner = this

        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(Page1ViewModel::class.java)
        viewModel.getItems()
        val layoutManager = LinearLayoutManager(context)

        recycleView.layoutManager = layoutManager
        recycleView.hasFixedSize()
        recycleView.adapter = RecycleViewPage1Adapter()
        recycleView.addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))

        binding.viewModel = viewModel

    }
}