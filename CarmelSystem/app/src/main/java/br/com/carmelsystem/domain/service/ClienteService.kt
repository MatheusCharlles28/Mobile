package br.com.carmelsystem.domain.service

import br.com.carmelsystem.data.model.Cliente
import br.com.carmelsystem.data.repository.ClienteRepository

class ClienteService(private val repository: ClienteRepository) {

    fun validar(nome: String, cpf: String, dataNasc: String): Map<String, String> {
        val erros = mutableMapOf<String, String>()
        if (nome.isBlank()) erros["nome"] = "Informe o nome"
        if (cpf.isBlank()) erros["cpf"] = "Informe o CPF"
        else if (cpf.replace(".", "").replace("-", "").length != 11) erros["cpf"] = "CPF inválido"
        if (dataNasc.isBlank()) erros["dataNasc"] = "Informe a data de nascimento"
        return erros
    }

    suspend fun salvar(cliente: Cliente): Result<Unit> = runCatching { repository.insert(cliente) }
    suspend fun atualizar(cliente: Cliente): Result<Unit> = runCatching { repository.update(cliente) }
    suspend fun deletar(cliente: Cliente): Result<Unit> = runCatching { repository.delete(cliente) }
}
