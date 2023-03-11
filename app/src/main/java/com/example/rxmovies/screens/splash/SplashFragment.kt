package com.example.rxmovies.screens.splash

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.rxmovies.R
import com.example.rxmovies.databinding.FragmentSplashBinding
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashFragment : Fragment() {
    private var mBinding: FragmentSplashBinding? = null
    private val binding get() = mBinding!!

    private fun init() {
        val progress = progressAnimation()
            .subscribeOn(AndroidSchedulers.mainThread())
            .delay(1000, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                binding.root.findNavController().navigate(R.id.action_splashFragment_to_mainFragment)
            }, {

            })
    }

    private fun progressAnimation(): Completable {
        return Completable.create {subscriber ->
            binding.splashProgress.max = 20
            val value = 20
            ObjectAnimator.ofInt(binding.splashProgress, "progress", value).setDuration(1000).start()
            subscriber.onComplete()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}