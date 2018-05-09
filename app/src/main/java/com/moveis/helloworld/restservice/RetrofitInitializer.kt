package com.moveis.helloworld.restservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder() // Cria uma instância de um Builder do Retrofit
            .baseUrl("http://mapforum.in4.com.br") // Define a URL base
            .addConverterFactory(GsonConverterFactory.create()) // Configurando o conversor de objetos
            .build() // Construindo o objeto do Retrofit

    fun modelsService() = retrofit.create(IForumRestService::class.java)
}