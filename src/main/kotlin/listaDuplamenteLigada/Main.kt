package listaDuplamenteLigada

fun main() {

    val loja1 = Loja("Minimercardo", "Rua das Flores, 01")
    val loja2 = Loja("Hortifruti", "Av das Borboletas, 02")
    val loja3 = Loja("Padaria Pão Quente", "Praça da Árvore, 03")
    val loja4 = Loja("Supermercado", "Rua do Pomar, 04")
    val loja5 = Loja("Mercado", "Rua das Flores, 05")
    val loja6 = Loja("Quitanda", "Rua da Fazenda, 06")
    val loja7 = Loja("Minimercardo das Frutas", "Av do Bosque, 07")
    val loja8 = Loja("Supermercado das Frutas", "Rua do Pomar, 08")
    val loja9 = Loja("Hortifruti da terra", "Rua das Laranjeira, 09")
    val loja10 = Loja("Mercado do Campo", "Rua da Fazenda, 10")


    val lista = ListaDuplamenteLigada()

    lista.inserirNoInicio(loja2)
    lista.inserirNoInicio(loja1)
    lista.inserirNoFim(loja3)
    lista.inserir(2, loja4)
    situacao(lista)

}

private fun situacao(lista: ListaDuplamenteLigada) {
    println("Quantidade ${lista.quantidade}")
    println(lista.imprime())
}

data class Loja(val mercado: String, val rua: String)
