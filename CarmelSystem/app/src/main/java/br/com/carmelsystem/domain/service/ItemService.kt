package br.com.carmelsystem.domain.service

import br.com.carmelsystem.data.model.Item
import br.com.carmelsystem.data.repository.ItemRepository

class ItemService(private val repository: ItemRepository) {

    fun validar(descricao: String, valorUnit: String, unidade: String): Map<String, String> {
        val erros = mutableMapOf<String, String>()
        if (descricao.isBlank()) erros["descricao"] = "Informe a descrição"
        val vl = valorUnit.replace(",", ".").toDoubleOrNull()
        when {
            valorUnit.isBlank() -> erros["valorUnit"] = "Informe o valor"
            vl == null -> erros["valorUnit"] = "Valor inválido"
            vl <= 0 -> erros["valorUnit"] = "Valor deve ser maior que zero"
        }
        if (unidade.isBlank()) erros["unidade"] = "Informe a unidade"
        return erros
    }

    suspend fun salvar(item: Item): Result<Unit> = runCatching { repository.insert(item) }
    suspend fun atualizar(item: Item): Result<Unit> = runCatching { repository.update(item) }
    suspend fun deletar(item: Item): Result<Unit> = runCatching { repository.delete(item) }
}
