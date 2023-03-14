package com.example.rxmovies.screens.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rxmovies.databinding.FragmentMainBinding
import com.example.rxmovies.domain.model.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainFragment : Fragment() {
    private var mBinding: FragmentMainBinding? = null
    private val binding get() = mBinding!!
    private val adapter by lazy { MainAdapter() }
    private val viewModel: MainViewModel by viewModels()
    private val compositeDisposable = CompositeDisposable()

    private fun init() {
        binding.apply {
            rvMain.adapter = adapter
            rvMain.layoutManager = GridLayoutManager(requireContext(), 2)
        }

        if (viewModel.moviesList.value == null) {
            getTop250()
        }

        viewModel.moviesList.observe(viewLifecycleOwner) {movies->
            adapter.setItems(movies.items)
        }
    }
    private fun getTop250() {
        val disposable = viewModel.getTop250()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({movies->
                viewModel.moviesList.value = movies
                Log.d("!@#", "API REQUEST")
            }, { th ->
                Log.e("!@#", th.message.toString())
            })
        //compositeDisposable.add(disposable)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
        compositeDisposable.dispose()
    }

}