package pl.pollub.harnasik.app.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import pl.pollub.harnasik.app.auth.AuthApi
import pl.pollub.harnasik.app.auth.AuthRepository
import pl.pollub.harnasik.app.auth.AuthRepositoryImpl
import pl.pollub.harnasik.app.data.remote.Offer.OfferDao
import pl.pollub.harnasik.app.data.remote.Offer.OfferDaoImpl
import pl.pollub.harnasik.app.data.repository.OfferRepositoryImpl
import pl.pollub.harnasik.app.domain.repository.OfferRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideAuthApi(): AuthApi {
        return Retrofit.Builder()
            .baseUrl("http://192.168.0.17:8080/api/user/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideSharedPref(app: Application): SharedPreferences {
        return app.getSharedPreferences("prefs", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(api: AuthApi, prefs: SharedPreferences): AuthRepository {
        return AuthRepositoryImpl(api, prefs)
    }


    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient = HttpClient(Android) {
        install(Logging) {
            level = LogLevel.ALL
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    @Provides
    @Singleton
    fun provideOfferApi(client: HttpClient): OfferDao = OfferDaoImpl(client)

    @Provides
    fun provideOfferRepository(api: OfferDao): OfferRepository = OfferRepositoryImpl(api)

}