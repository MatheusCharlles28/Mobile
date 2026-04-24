package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var etLarguraA: TextInputEditText
    private lateinit var etLarguraB: TextInputEditText
    private lateinit var etAlturaA: TextInputEditText
    private lateinit var etAlturaB: TextInputEditText
    private lateinit var tvPerimetro: TextView
    private lateinit var tvArea: TextView
    private lateinit var btnCalcularAreaPerimetro: Button

    private lateinit var etTempoGasto: TextInputEditText
    private lateinit var etMediaVelocidade: TextInputEditText
    private lateinit var etMediaCombustivel: TextInputEditText
    private lateinit var tvCombustivelUtilizado: TextView
    private lateinit var btnCalcularCombustivel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        setupListeners()
    }

    private fun bindViews() {
        etLarguraA = findViewById(R.id.etLarguraA)
        etLarguraB = findViewById(R.id.etLarguraB)
        etAlturaA = findViewById(R.id.etAlturaA)
        etAlturaB = findViewById(R.id.etAlturaB)
        tvPerimetro = findViewById(R.id.tvPerimetro)
        tvArea = findViewById(R.id.tvArea)
        btnCalcularAreaPerimetro = findViewById(R.id.btnCalcularAreaPerimetro)

        etTempoGasto = findViewById(R.id.etTempoGasto)
        etMediaVelocidade = findViewById(R.id.etMediaVelocidade)
        etMediaCombustivel = findViewById(R.id.etMediaCombustivel)
        tvCombustivelUtilizado = findViewById(R.id.tvCombustivelUtilizado)
        btnCalcularCombustivel = findViewById(R.id.btnCalcularCombustivel)
    }

    private fun setupListeners() {
        btnCalcularAreaPerimetro.setOnClickListener { onCalcularForma() }
        btnCalcularCombustivel.setOnClickListener { onCalcularCombustivel() }
    }

    private fun onCalcularForma() {
        val larguraA = etLarguraA.text.toString()
        val larguraB = etLarguraB.text.toString()
        val alturaA = etAlturaA.text.toString()
        val alturaB = etAlturaB.text.toString()

        val erro = FormaValidator.validarForma(larguraA, alturaA)
        if (erro != null) {
            toast(erro)
            return
        }

        val lA = larguraA.toDouble()
        val lB = larguraB.toDoubleOrNull()
        val aB = alturaB.toDoubleOrNull()

        val (area, perimetro) = if (lB != null && aB != null) {
            FormaCalculator.calcularRetangulo(lB, aB)
        } else {
            FormaCalculator.calcularQuadrado(lA)
        }

        tvArea.text = String.format("%.2f", area)
        tvPerimetro.text = String.format("%.2f", perimetro)
    }

    private fun onCalcularCombustivel() {
        val tempo = etTempoGasto.text.toString()
        val velocidade = etMediaVelocidade.text.toString()
        val media = etMediaCombustivel.text.toString()

        val erro = FormaValidator.validarCombustivel(tempo, velocidade, media)
        if (erro != null) {
            toast(erro)
            return
        }

        val resultado = CombustivelCalculator.calcular(
            tempo.toDouble(),
            velocidade.toDouble(),
            media.toDouble()
        )

        tvCombustivelUtilizado.text = String.format("%.2f", resultado)
    }

    private fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
