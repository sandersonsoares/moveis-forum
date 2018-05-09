package com.moveis.helloworld.restservice

import retrofit2.Call
import retrofit2.http.*

interface IForumRestService {

    /*
   Categorias
    */
    @GET("/categoria/")
    fun getCategorias(): Call<List<Categoria>>

    @POST("/categoria/")
    fun insertCategoria(@Body categoria: Categoria): Call<Categoria>

    @PUT("/categoria/{id}/")
    fun updateCategoria(@Path("id") id: Int, @Body categoria: Categoria): Call<Categoria>

    @DELETE("/categoria/{id}/")
    fun removeCategoria(@Path("id") id: Int): Call<Any>

    @GET("/categoria/{id}/topicos")
    fun getTopicosCategoria(@Path("id") id: Int): Call<List<Topico>>

    /*
    Topicos
     */
    @GET("/topico/")
    fun getTopicos(): Call<List<Topico>>

    @POST("/topico/")
    fun insertTopico(@Body topico: Topico): Call<Topico>

    @PUT("/topico/{id}/")
    fun updateTopico(@Path("id") id: Int, @Body topico: Topico): Call<Topico>

    @DELETE("/topico/{id}/")
    fun removeTopico(@Path("id") id: Int): Call<Any>

    @GET("/topico/{id}/comentarios")
    fun getComentariosTopico(@Path("id") id: Int): Call<List<Comentario>>

    /*
    Comentarios
     */
    @GET("/comentario/")
    fun getComentarios(): Call<List<Comentario>>

    @POST("/comentario/")
    fun insertComentario(@Body comentario: Comentario): Call<Comentario>

    @PUT("/comentario/{id}/")
    fun updateComentario(@Path("id") id: Int, @Body comentario: Comentario): Call<Comentario>

    @DELETE("/comentario/{id}/")
    fun removeComentario(@Path("id") id: Int): Call<Any>

}