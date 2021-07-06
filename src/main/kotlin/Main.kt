import listaLigada.ListaLigada

fun main() {

    val lista = ListaLigada()

    lista.inserirNoInicio("Paulo")
    lista.inserirNoInicio("Lucas")
    lista.inserir(2, "Eduardo")
    lista.inserir(0, "Camila")
    lista.inserir(1, "Maria")

    println(lista.quantidade)
    lista.imprime()

    println("---------------------------------")
    //println(listaLigada.removerNoInicio())
    println(lista.remover(2))
    println(lista.quantidade)
    println("---------------------------------")

    println(lista.imprime())
}