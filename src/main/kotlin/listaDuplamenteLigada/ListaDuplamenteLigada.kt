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
        if (validaQuantidadeIgualZero(conteudo)) return
        val celula = Celula(conteudo)
        celula.proxima = inicio
        inicio?.anterior = celula
        inicio = celula
        quantidade++
    }

    fun inserirNoFim(conteudo: Any) {
        if (validaQuantidadeIgualZero(conteudo)) return
        val celula = Celula(conteudo)
        celula.anterior = fim
        fim?.proxima = celula
        fim = celula
        quantidade++
    }

    private fun validaQuantidadeIgualZero(conteudo: Any): Boolean {
        return if (quantidade == 0) {
            inserirNaListaVazia(conteudo)
            true
        } else {
            false
        }
    }

    fun inserir(posicao: Int, conteudo: Any) {
        if (validaQuantidadeIgualZero(conteudo)) {
            return
        }
        if (posicao == quantidade) {
            inserirNoFim(conteudo)
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
            for (i in 0..posicao) {
                atual = atual?.proxima
            }
        } else {
            atual = fim
            for (i in quantidade downTo posicao) {
                atual = atual?.anterior
            }
        }
        return atual
    }

    fun validarPosicao(posicao: Int): Boolean {
        return if (posicao in 0 until quantidade) {
            true
        } else {
            throw IndexOutOfBoundsException("Posição inválida. Essa posição não existe na lista $posicao")
        }
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