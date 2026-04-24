package com.example.calculadora

object CombustivelCalculator {

    fun calcular(tempo: Double, velocidade: Double, mediaPorKm: Double): Double {
        val distancia = tempo * velocidade
        return distancia / mediaPorKm
    }
}
