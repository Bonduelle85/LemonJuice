package com.example.lemonjuice.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lemonjuice.R
import com.example.lemonjuice.databinding.ActivityMainBinding
import com.example.lemonjuice.presentation.core.ManageViewModels
import com.example.lemonjuice.presentation.core.Screen
import com.example.lemonjuice.presentation.glass.GlassNavigation
import com.example.lemonjuice.presentation.glass.GlassScreen
import com.example.lemonjuice.presentation.juice.JuiceNavigation
import com.example.lemonjuice.presentation.juice.JuiceScreen
import com.example.lemonjuice.presentation.lemon.LemonNavigation
import com.example.lemonjuice.presentation.lemon.LemonScreen
import com.example.lemonjuice.presentation.lemon.LemonViewModel
import com.example.lemonjuice.presentation.tree.TreeNavigation
import com.example.lemonjuice.presentation.tree.TreeScreen

class MainActivity : AppCompatActivity(), Navigation, ManageViewModels {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = viewModel(MainViewModel::class.java)

        val lastScreen = viewModel.init(savedInstanceState == null)
        navigate(lastScreen)
    }

    override fun navigate(screen: Screen) {
        screen.show(R.id.container, supportFragmentManager)
    }

    override fun clear(clazz: Class<out MyViewModel>) {
        (application as ManageViewModels).clear(clazz)
    }

    override fun <T : MyViewModel> viewModel(clazz: Class<T>): T {
        return (application as ManageViewModels).viewModel(clazz)
    }
}



interface Navigation : TreeNavigation, JuiceNavigation, LemonNavigation, GlassNavigation {
    fun navigate(screen: Screen)

    override fun navigateToLemon() {
        navigate(LemonScreen)
    }

    override fun navigateToGlass() {
        navigate(GlassScreen)
    }

    override fun navigateToJuice() {
        navigate(JuiceScreen)
    }

    override fun navigateToTree() {
        navigate(TreeScreen)
    }
}

