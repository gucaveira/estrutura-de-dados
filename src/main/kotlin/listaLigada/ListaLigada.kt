package listaLigada

class ListaLigada(
    var quantidade: Int = 0
) {

    var inicio: Celula? = null
        private set

    fun imprime() {
        var celulaAtual = inicio

        for (i in 0..quantidade) {
            celulaAtual?.let {
                println(it.conteudo)
            }
            celulaAtual = celulaAtual?.proxima
        }
    }

    fun inserirNoInicio(conteudo: Any) {
        val celula = Celula(conteudo)
        celula.proxima = inicio
        inicio = celula
        quantidade++
    }

    fun inserir(posicao: Int, conteudo: Any) {
        if (posicao == 0) {
            inserirNoInicio(conteudo)
            return
        }

        val celulaAnterior = getCelula(posicao - 1)
        val celula = Celula(conteudo)
        celula.proxima = celulaAnterior?.proxima
        celulaAnterior?.proxima = celula
        quantidade++

    }

    private fun getCelula(posicao: Int): Celula? {
        validarPosicao(posicao)
        var celulaAtual = inicio

        for (i in 0..posicao) {
            celulaAtual = celulaAtual?.proxima
        }

        return celulaAtual
    }

    private fun validarPosicao(posicao: Int): Boolean {
        if (posicao in 0 until quantidade) {
            return true
        } else {
            throw IndexOutOfBoundsException("Posição invalida: $posicao")
        }
    }

    fun removerNoInicio(): Any? {
        val removido = inicio
        inicio = removido?.proxima
        quantidade--
        return removido?.conteudo
    }

    fun remover(posicao: Int): Any? {
        if (posicao == 0) {
            removerNoInicio()
        }
        val celulaAnterio = getCelula(posicao - 1)
        val removido = celulaAnterio?.proxima
        celulaAnterio?.proxima = removido?.proxima
        removido?.proxima = null
        quantidade--
        return removido?.conteudo

    }
}