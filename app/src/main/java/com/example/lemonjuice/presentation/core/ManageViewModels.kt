package com.example.lemonjuice.presentation.core

import com.example.lemonjuice.Core
import com.example.lemonjuice.data.GlassRepository
import com.example.lemonjuice.data.IntCache
import com.example.lemonjuice.data.JuiceRepository
import com.example.lemonjuice.data.LemonRepository
import com.example.lemonjuice.data.MainRepository
import com.example.lemonjuice.data.TreeRepository
import com.example.lemonjuice.presentation.glass.GlassViewModel
import com.example.lemonjuice.presentation.juice.JuiceViewModel
import com.example.lemonjuice.presentation.lemon.LemonViewModel
import com.example.lemonjuice.presentation.main.MainViewModel
import com.example.lemonjuice.presentation.main.MyViewModel
import com.example.lemonjuice.presentation.tree.TreeViewModel

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