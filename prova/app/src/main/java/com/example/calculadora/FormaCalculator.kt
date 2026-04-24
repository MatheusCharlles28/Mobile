package com.example.calculadora

object FormaCalculator {

    fun calcularQuadrado(lado: Double): Pair<Double, Double> {
        val area = lado * lado
        val perimetro = 4 * lado
        return Pair(area, perimetro)
    }

    fun calcularRetangulo(base: Double, altura: Double): Pair<Double, Double> {
        val area = base * altura
        val perimetro = 2 * (base + altura)
        return Pair(area, perimetro)
    }
}
