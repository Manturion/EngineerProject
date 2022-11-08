package pl.pollub.harnasik.app.auth

data class TokenResponse(
    val jwt: String,
    val username: String
)
