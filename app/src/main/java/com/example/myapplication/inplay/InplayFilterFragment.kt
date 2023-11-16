package com.example.myapplication.inplay

import Resource
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.InPlayListAdapter
import com.example.myapplication.databinding.FragmentInplayFilterBinding
import com.example.myapplication.helper.DateHelper
import com.example.myapplication.model.FilterInInplay
import com.example.myapplication.viewmodel.InPlayFilterViewModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

private const val FILTER_TYPE = "filterType"


class InplayFilterFragment : Fragment() {
    private val TAG = "InPlayFilterFragment"
    private var _binding : FragmentInplayFilterBinding?=null
    private val binding get() = _binding!!
    private val viewModel: InPlayFilterViewModel by activityViewModels()
    private var _adapter:InPlayListAdapter? = null
    private val adapter get() = _adapter!!



    private var filterType: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            filterType = it.getString(FILTER_TYPE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInplayFilterBinding.inflate(layoutInflater)
         bindViews()
         bindObserver()
         return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(filterType: String) =
            InplayFilterFragment().apply {
                arguments = Bundle().apply {
                    putString(FILTER_TYPE, filterType)
                }
            }
    }
    private fun bindViews(){
       _adapter = InPlayListAdapter()
        binding.rvList.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        binding.rvList.adapter = adapter
    }
    private fun bindObserver(){
        lifecycleScope.launch {
            viewModel.getListOfEvents().collectLatest {
                when(it){
                    is Resource.Success->{
                        binding.progressBar.isVisible=false
                        when(FilterInInplay.valueOf(filterType.toString())){
                            FilterInInplay.INPLAY->{
                                it.data?.filter {
                                    DateHelper.isOpenDateGreaterThanCurrentDateTime(it.openDate ).not()
                                }.apply {
                                    adapter.submitList(this)
                                }
                            }
                            FilterInInplay.TODAY->{
                                it.data?.filter {
                                    DateHelper.isOpenDateGreaterThanCurrentDateTime(it.openDate )
                                }.apply {
                                    adapter.submitList(this)
                                }

                            }
                            FilterInInplay.TOMORROW->{
                                it.data?.filter {
                                    DateHelper.isOpenDateTomorrow(it.openDate)
                                }
                                adapter.submitList(it.data)
                            }
                            FilterInInplay.RESULT->{

                            }
                        }

                    }
                    is Resource.Error->{
                        binding.progressBar.isVisible=false
                        Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show()
                    }
                    is Resource.Loading->{
                        binding.progressBar.isVisible=true
                    }
                    else->{

                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
        _adapter=null
    }
}