package pilha

fun main() {

    val fases = Pilha()

    val fase1 = Fase("Floresta", 300, -100)
    val fase2 = Fase("Castelo", 100, -4)
    val fase3 = Fase("Caverna", 400, -50)
    val fase4 = Fase("Guerra", 3000, -400)

    fases.empilhar(fase1)
    fases.empilhar(fase2)
    val falhou = fases.desempilhar()
    println("Falou na fase $falhou")
    println("Voltou para Fase ${fases.topo()}")

}

data class Fase(val cenario: String, val pontuacao: Int, val punicao: Int)
