package compose.material.theme

data class HomeState(
    val users: List<User> = emptyList(),
    val userName: String = "",
    val userNumber: String = "",
    val userEmail: String = "",
    val userPassword: String = "",
    val userId: String? = null
)