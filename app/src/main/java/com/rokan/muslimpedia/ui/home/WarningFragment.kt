package com.rokan.muslimpedia.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rokan.muslimpedia.adapter.NewsAdapter
import com.rokan.muslimpedia.data.model.NewsViewModel
import com.rokan.muslimpedia.data.repository.NewsRepository
import com.rokan.muslimpedia.databinding.FragmentWarningBinding
import com.rokan.muslimpedia.utils.NewsViewModelFactory


class WarningFragment : Fragment() {

    private lateinit var binding: FragmentWarningBinding
    private val commonViewModel: NewsViewModel by viewModels {
        NewsViewModelFactory(NewsRepository())
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWarningBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mAdapter = NewsAdapter()
        commonViewModel.getPoliticNews()
        commonViewModel.PoliticNews.observe(viewLifecycleOwner){
                dataNews -> mAdapter.setData(dataNews.articles)
            binding.rvWarningformuslimNews.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }



        commonViewModel.isLoading.observe(viewLifecycleOwner){
            isLoading(it)
        }
    }

    private fun isLoading(isLoading: Boolean) {
        if (isLoading){
            binding.loadingView.root.visibility = View.VISIBLE

        }else{
            binding.loadingView.root.visibility = View.GONE
        }
    }


}