package com.example.lemonjuice.core.di

import com.example.lemonjuice.glass.data.GlassRepository
import com.example.lemonjuice.core.data.IntCache
import com.example.lemonjuice.juice.data.JuiceRepository
import com.example.lemonjuice.lemon.data.LemonRepository
import com.example.lemonjuice.main.data.MainRepository
import com.example.lemonjuice.tree.data.TreeRepository
import com.example.lemonjuice.glass.presentation.GlassViewModel
import com.example.lemonjuice.juice.presentation.JuiceViewModel
import com.example.lemonjuice.lemon.presentation.LemonViewModel
import com.example.lemonjuice.main.presentation.MainViewModel
import com.example.lemonjuice.main.presentation.MyViewModel
import com.example.lemonjuice.tree.presentation.TreeViewModel

interface ManageViewModels : ClearViewModel, ProvideViewModel

interface ClearViewModel {

    fun clear(clazz: Class<out MyViewModel>)
}

interface ProvideViewModel {

    fun <T : MyViewModel> viewModel(clazz: Class<T>): T

    class Factory(
        private val make: ProvideViewModel
    ) : ManageViewModels {

        private val mutableMap = mutableMapOf<Class<out MyViewModel>, MyViewModel?>()

        override fun clear(clazz: Class<out MyViewModel>) {
            mutableMap[clazz] = null
        }

        override fun <T : MyViewModel> viewModel(clazz: Class<T>): T {
            return if (mutableMap[clazz] == null) {
                val viewModel = make.viewModel(clazz)
                mutableMap[clazz] = viewModel
                viewModel
            } else
                mutableMap[clazz] as T
        }
    }

    class Make(private val core: Core) : ProvideViewModel {
        override fun <T : MyViewModel> viewModel(clazz: Class<T>): T = with(core) {
            return when (clazz) {
                MainViewModel::class.java -> MainViewModel(
                    MainRepository.Base(lastScreen)
                )

                TreeViewModel::class.java -> TreeViewModel(
                    TreeRepository.Base(lastScreen)
                )

                LemonViewModel::class.java -> LemonViewModel(
                    LemonRepository.Base(
                        lastScreen,
                        IntCache.Base("counter", permanentStorage, 0)
                    )
                )

                JuiceViewModel::class.java -> JuiceViewModel(
                    JuiceRepository.Base(lastScreen)
                )

                GlassViewModel::class.java -> GlassViewModel(
                    GlassRepository.Base(lastScreen)
                )

                else -> throw IllegalStateException("unknown viewModel $clazz")
            } as T
        }
    }
}