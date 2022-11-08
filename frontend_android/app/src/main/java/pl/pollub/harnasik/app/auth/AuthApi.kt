package pl.pollub.harnasik.app.auth

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST


interface AuthApi {

    @POST("register")
    suspend fun signUp(
        @Body request: AuthRequest
    )

    @POST("login")
    suspend fun signIn(
        @Body request: AuthRequest
    ): TokenResponse

    @GET("authenticate")
    suspend fun authenticate(
        @Header("Authorization") jwt: String
    )

    @
}