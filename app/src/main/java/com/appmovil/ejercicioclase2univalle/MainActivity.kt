package com.appmovil.ejercicioclase2univalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.appmovil.ejercicioclase2univalle.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.btnCalcular.setOnClickListener {
            binding.tvResultado.text = validarCategoría()        }

    }

    private fun validarCategoría() : String {
        val imc = calcularIMC()
        return when {
            imc < 18.5 -> "Bajo peso"
            imc in 18.5..24.9 -> "Peso normal"
            imc in 25.0..29.9 -> "Sobrepeso"
            else -> "Obesidad"
        }
    }

    private fun calcularIMC(): Double{
        val estatura= binding.etEstatura.text.toString().toDouble()
        val peso = binding.etPeso.text.toString().toDouble()
        val imc = peso / (estatura.pow(2))
        return imc
    }
}