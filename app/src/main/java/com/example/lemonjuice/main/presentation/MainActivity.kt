package com.example.lemonjuice.main.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lemonjuice.R
import com.example.lemonjuice.databinding.ActivityMainBinding
import com.example.lemonjuice.core.di.ManageViewModels
import com.example.lemonjuice.core.presentation.Screen
import com.example.lemonjuice.glass.presentation.GlassNavigation
import com.example.lemonjuice.glass.presentation.GlassScreen
import com.example.lemonjuice.juice.presentation.JuiceNavigation
import com.example.lemonjuice.juice.presentation.JuiceScreen
import com.example.lemonjuice.lemon.presentation.LemonNavigation
import com.example.lemonjuice.lemon.presentation.LemonScreen
import com.example.lemonjuice.tree.presentation.TreeNavigation
import com.example.lemonjuice.tree.presentation.TreeScreen

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

