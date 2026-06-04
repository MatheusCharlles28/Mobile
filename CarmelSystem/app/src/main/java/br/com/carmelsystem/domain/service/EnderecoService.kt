package br.com.carmelsystem.domain.service

import br.com.carmelsystem.data.model.Endereco
import br.com.carmelsystem.data.repository.EnderecoRepository

class EnderecoService(private val repository: EnderecoRepository) {

    fun validar(logradouro: String, numero: String, bairro: String, cidade: String, uf: String): Map<String, String> {
        val erros = mutableMapOf<String, String>()
        if (logradouro.isBlank()) erros["logradouro"] = "Informe o logradouro"
        if (numero.isBlank()) erros["numero"] = "Informe o número"
        if (bairro.isBlank()) erros["bairro"] = "Informe o bairro"
        if (cidade.isBlank()) erros["cidade"] = "Informe a cidade"
        if (uf.isBlank()) erros["uf"] = "Informe o UF"
        else if (uf.length != 2) erros["uf"] = "UF deve ter 2 letras"
        return erros
    }

    suspend fun salvar(endereco: Endereco): Result<Unit> = runCatching { repository.insert(endereco) }
    suspend fun atualizar(endereco: Endereco): Result<Unit> = runCatching { repository.update(endereco) }
    suspend fun deletar(endereco: Endereco): Result<Unit> = runCatching { repository.delete(endereco) }
}
