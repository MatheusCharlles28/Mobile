package com.example.calculadora

object FormaValidator {

    fun validarForma(larguraA: String, alturaA: String): String? {
        if (larguraA.isBlank() || alturaA.isBlank()) {
            return "Preencha pelo menos Largura A e Altura A"
        }
        if (larguraA.toDoubleOrNull() == null || alturaA.toDoubleOrNull() == null) {
            return "Digite valores numéricos válidos"
        }
        return null
    }

    fun validarCombustivel(tempo: String, velocidade: String, media: String): String? {
        if (tempo.isBlank() || velocidade.isBlank() || media.isBlank()) {
            return "Preencha todos os campos de combustível"
        }
        if (tempo.toDoubleOrNull() == null || velocidade.toDoubleOrNull() == null || media.toDoubleOrNull() == null) {
            return "Digite valores numéricos válidos"
        }
        if (media.toDouble() == 0.0) {
            return "Média de combustível não pode ser zero"
        }
        return null
    }
}
