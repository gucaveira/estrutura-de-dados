package listaDuplamenteLigada

data class Celula(
    val conteudo: Any,
    var anterior: Celula? = null,
    var proxima: Celula? = null
)