package com.battilana.appsolicitudbattilana.data.di

import android.content.Context
import com.battilana.appsolicitudbattilana.data.api.UsuarioApi
import com.battilana.appsolicitudbattilana.data.datasource.SessionManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun getRetrofit(): Retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.18.13:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun getUsuariosApi(retrofit: Retrofit): UsuarioApi = retrofit.create(UsuarioApi::class.java)

    @Provides
    @Singleton
    fun provideSessionManager(@ApplicationContext context: Context): SessionManager{
        return SessionManager(context)
    }
}