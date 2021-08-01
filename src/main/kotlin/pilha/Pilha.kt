package pilha

import listaLigada.ListaLigada

class Pilha {

    private val pilha = ListaLigada()

    fun empilhar(conteudo: Any) {
        pilha.inserirNoInicio(conteudo)
    }

    fun desempilhar() = pilha.removerNoInicio()

    fun topo() = pilha.inicio
    fun vazia(): Boolean {
        return pilha.quantidade == 0
    }
}