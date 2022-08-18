package com.example.conselho.di

import com.example.conselho.data.api.ApiService
import com.example.conselho.data.datasource.AdviceRemoteDataSource
import com.example.conselho.data.datasource.AdviceRemoteDataSourceImpl
import com.example.conselho.data.mapper.AdviceMapper
import com.example.conselho.data.repository.AdviceRepositoryImpl
import com.example.conselho.domain.repository.AdviceRepository
import com.example.conselho.domain.usecase.GetAdviceUseCase
import com.example.conselho.presentation.AdviceViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.adviceslip.com/"

val networkModule = module {
    single<Gson> { GsonBuilder().create() }
    single {
        OkHttpClient.Builder()
            .build()
    }
    single<GsonConverterFactory> { GsonConverterFactory.create(get()) }
    single<RxJava2CallAdapterFactory> {
        RxJava2CallAdapterFactory.create()
    }
    single<Retrofit.Builder> {
        Retrofit.Builder()
            .client(get())
            .addConverterFactory(get<GsonConverterFactory>())
            .addCallAdapterFactory(get<RxJava2CallAdapterFactory>())
    }
    single<Retrofit> {
        get<Retrofit.Builder>()
            .baseUrl(BASE_URL)
            .build()
    }

    single<ApiService> {
        get<Retrofit>().create(ApiService::class.java)
    }
}

val dataModule = module {
    factory<AdviceRemoteDataSource> { AdviceRemoteDataSourceImpl(get()) }
    factory<AdviceRepository> { AdviceRepositoryImpl(get(), AdviceMapper()) }
}

val domainModule = module {
    factory { GetAdviceUseCase(get()) }
}

val presentationModule = module {
    viewModel {
        AdviceViewModel(
            getAdviceUseCase = get()
        )
    }
}
