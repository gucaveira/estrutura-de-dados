package listaLigada

data class Celula(
    val conteudo: Any,
    var proxima: Celula? = null
)