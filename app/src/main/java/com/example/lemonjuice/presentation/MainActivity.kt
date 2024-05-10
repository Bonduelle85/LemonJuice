package com.example.lemonjuice.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lemonjuice.R
import com.example.lemonjuice.databinding.ActivityMainBinding
import com.example.lemonjuice.presentation.core.Screen
import com.example.lemonjuice.presentation.glass.GlassNavigation
import com.example.lemonjuice.presentation.glass.GlassScreen
import com.example.lemonjuice.presentation.juice.JuiceNavigation
import com.example.lemonjuice.presentation.juice.JuiceScreen
import com.example.lemonjuice.presentation.lemon.LemonNavigation
import com.example.lemonjuice.presentation.lemon.LemonScreen
import com.example.lemonjuice.presentation.tree.TreeNavigation
import com.example.lemonjuice.presentation.tree.TreeScreen

class MainActivity : AppCompatActivity(), Navigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null)
            navigate(TreeScreen)
    }

    override fun navigate(screen: Screen) {
        screen.show(R.id.container, supportFragmentManager)
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

