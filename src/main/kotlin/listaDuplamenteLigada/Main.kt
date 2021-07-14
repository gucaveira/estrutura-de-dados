package listaDuplamenteLigada

fun main() {

    val loja00 = Loja("Minimercardo", "Rua das Flores, 00")
    val loja01 = Loja("Hortifruti", "Av das Borboletas, 01")
    val loja02 = Loja("Padaria Pão Quente", "Praça da Árvore, 02")
    val loja03 = Loja("Supermercado", "Rua do Pomar, 03")
    val loja04 = Loja("Mercado", "Rua das Flores, 04")
    val loja05 = Loja("Quitanda", "Rua da Fazenda, 05")
    val loja06 = Loja("Minimercardo das Frutas", "Av do Bosque, 06")
    val loja07 = Loja("Supermercado das Frutas", "Rua do Pomar, 07")
    val loja08 = Loja("Hortifruti da terra", "Rua das Laranjeira, 08")
    val loja09 = Loja("Mercado do Campo", "Rua da Fazenda, 09")


    val lista = ListaDuplamenteLigada()

    lista.inserir(0, loja00)
    lista.inserir(1, loja01)
    lista.inserir(2, loja02)
    lista.inserir(3, loja03)
    lista.inserir(4, loja04)
    lista.inserir(5, loja05)
    lista.inserir(6, loja06)
    lista.inserir(7, loja07)
    lista.inserir(8, loja08)
    lista.inserir(9, loja09)

    situacao(lista)
    mostarItemRemovido(lista.removerDoInicio())

}

private fun mostarItemRemovido(item: Any?) {
    println("---------------------------------------")
    println(item)
    println("---------------------------------------")
}

private fun situacao(lista: ListaDuplamenteLigada) {
    println(lista.imprime())
    println("________________________________")
    println("Quantidade ${lista.quantidade}")
    println("________________________________")
}

data class Loja(val mercado: String, val rua: String)
