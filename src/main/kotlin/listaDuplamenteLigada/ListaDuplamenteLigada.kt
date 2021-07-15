package listaDuplamenteLigada

class ListaDuplamenteLigada {

    private var inicio: Celula? = null
    private var fim: Celula? = null
    var quantidade: Int = 0
        private set

    private fun inserirNaListaVazia(conteudo: Any) {
        val celula = Celula(conteudo)
        inicio = celula
        fim = celula
        quantidade++
    }

    fun inserirNoInicio(conteudo: Any) {
        if (quantidade == 0) {
            inserirNaListaVazia(conteudo)
            return
        }

        val celula = Celula(conteudo)
        celula.proxima = inicio
        inicio?.anterior = celula
        inicio = celula
        quantidade++
    }

    fun inserirNoFim(conteudo: Any) {
        if (quantidade == 0) {
            inserirNaListaVazia(conteudo)
            return
        }
        val celula = Celula(conteudo)
        celula.anterior = fim
        fim?.proxima = celula
        fim = celula
        quantidade++
    }

    fun inserir(posicao: Int, conteudo: Any) {
        if (posicao == 0) {
            inserirNoInicio(conteudo)
            return
        }
        if (posicao == quantidade) {
            inserirNoFim(conteudo)
            return
        }

        val esquerda = getCelula(posicao - 1)
        val direita = esquerda?.proxima
        val celula = Celula(conteudo)

        celula.proxima = direita
        celula.anterior = esquerda

        esquerda?.proxima = celula
        direita?.anterior = celula
        quantidade++
    }

    private fun getCelula(posicao: Int): Celula? {
        validarPosicao(posicao)
        var atual = inicio
        val metade = quantidade.div(2)

        if (posicao < metade) {
            for (i in 0 until posicao) {
                atual = atual?.proxima
            }

        } else {
            atual = fim
            for (i in quantidade downTo posicao + 2) {
                atual = atual?.anterior
            }
        }
        return atual
    }

    fun validarPosicao(posicao: Int): Boolean {
        return if (posicao in 0 until quantidade) {
            true
        } else {
            throw IndexOutOfBoundsException("Posição inválida. Essa posição não existe na lista ${posicao + 1}")
        }
    }

    private fun removerUltimo(): Any? {
        val remover = inicio
        inicio = null
        fim = null
        quantidade--
        return remover?.conteudo
    }

    fun removerDoInicio(): Any? {
        if (quantidade == 1) {
            return removerUltimo()
        }
        val removido = inicio
        inicio = inicio?.proxima
        inicio?.anterior = null
        removido?.proxima = null
        quantidade--
        return removido?.conteudo
    }

    fun removerNoFim(): Any? {
        if (quantidade == 1) {
            return removerUltimo()
        }
        val removido = fim
        fim = removido?.anterior
        fim?.proxima = null
        removido?.anterior = null
        quantidade--
        return removido
    }

    fun remover(posicao: Int): Any? {
        if (posicao == 0) {
            return removerDoInicio()
        }
        if (posicao == quantidade - 1) {
            return removerNoFim()
        }

        val removido = getCelula(posicao)
        val esquerda = removido?.anterior
        val direita = removido?.proxima

        removido?.proxima = null
        removido?.anterior = null

        esquerda?.proxima = direita
        direita?.anterior = esquerda
        quantidade--
        return removido
    }


    fun imprime() {
        var atual = inicio

        for (i in 0..quantidade) {
            atual?.let {
                println(it.conteudo)
            }
            atual = atual?.proxima
        }
    }
}