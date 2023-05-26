package compose.material.theme

data class DenunciaState(
    val denuncias: List<Denuncia> = emptyList(),
    val denunciaTitulo: String = "",
    val denunciaDescripcion: String = "",
    val denunciaFecha: String = "",
    val denunciaId: String? = null
)
