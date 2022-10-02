package pl.pollub.harnasik.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import pl.pollub.harnasik.app.data.remote.Offer.OfferDao
import pl.pollub.harnasik.app.data.remote.Offer.OfferDaoImpl
import pl.pollub.harnasik.app.data.repository.OfferRepositoryImpl
import pl.pollub.harnasik.app.domain.repository.OfferRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

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