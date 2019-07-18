package com.dome.mvvm.page2


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.dome.mvvm.R
import com.dome.mvvm.databinding.FragmentPage2Binding
import com.example.promptnow.testkotlin.DataModel
import kotlinx.android.synthetic.main.fragment_page2.*

// TODO: Rename parameter arguments, choose names that match
/**
 * A simple [Fragment] subclass.
 *
 */
class Page2Fragment : Fragment() {
    private lateinit var binding: FragmentPage2Binding
    private lateinit var viewModel: Page2ViewModel
    private var adapter: RecycleViewPage2Adapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_page2, container, false)


        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(Page2ViewModel::class.java)

        observeViewModel(viewModel)
        initSwipeRefresh()

    }

    private fun observeViewModel(viewModel:Page2ViewModel) {
        // Update the list when the data changes
        viewModel.dataModel.observe(viewLifecycleOwner,
            Observer<DataModel> {
                if (it != null) {
                    initRecyclerView(it)
                } else {
                    swipe_container?.isRefreshing = false
                    tvFails?.visibility = View.VISIBLE
                    progress?.visibility = View.GONE
                }
            })
    }

    private fun initSwipeRefresh() {
        swipe_container.setOnRefreshListener {
            observeViewModel(viewModel)
        }
    }


    private fun initRecyclerView(data: DataModel) {
        swipe_container?.isRefreshing = false
        tvFails?.visibility = View.GONE
        progress?.visibility = View.GONE

        val layoutManager = LinearLayoutManager(context)

        recycleView?.layoutManager = layoutManager
        recycleView?.hasFixedSize()
        adapter = RecycleViewPage2Adapter()
        recycleView?.adapter = adapter

        adapter!!.setData(data)
        binding.viewModel = viewModel
    }
}
