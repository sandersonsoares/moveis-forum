package com.moveis.helloworld.restservice

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ForumWebClient {

    val TAG = "WEBCLIENT"

    /*
    * Função que chama o GET, listando todas as Categorias
     */
    fun getCategorias(iCallbackResponse: ICallbackResponse<List<Categoria>>? = null) {
        // Inicializa o serviço
        val service = RetrofitInitializer().modelsService()

        // Faz a chamada de API
        val call = service.getCategorias()
        // Registra o callback da chamada de API
        call.enqueue(object : Callback<List<Categoria>?> {
            // Se deu certo
            override fun onResponse(call: Call<List<Categoria>?>?, response: Response<List<Categoria>?>?) {

                // Testa se está ok e retorna a chamada de callback
                if (iCallbackResponse != null) {
                    response?.body()?.let {
                        val categorias: List<Categoria> = it
                        iCallbackResponse.success(categorias)
                    }
                }

                Log.i(TAG, "[INFO] getCategorias sucessfull.")
            }

            override fun onFailure(call: Call<List<Categoria>?>?, t: Throwable?) {
                Log.e(TAG, "[ERROR] getCategorias error.")
            }
        })
    }

    fun insertCategoria(categoria: Categoria, iCallbackResponse: ICallbackResponse<Categoria>? = null) {
        val service = RetrofitInitializer().modelsService()

        val call = service.insertCategoria(categoria)
        call.enqueue(object : Callback<Categoria?> {
            override fun onResponse(call: Call<Categoria?>?, response: Response<Categoria?>?) {
                if (iCallbackResponse != null) {
                    response?.body()?.let {
                        val categoria: Categoria = it
                        iCallbackResponse.success(categoria)
                    }
                }
                Log.i(TAG, "[INFO] insertCategoria sucessfull.")
            }

            override fun onFailure(call: Call<Categoria?>?, t: Throwable?) {
                Log.e(TAG, "[ERROR] insertCategoria error.")
            }
        })
    }

    fun updateCategoria(id: Int, categoria: Categoria, iCallbackResponse: ICallbackResponse<Categoria>? = null) {
        val service = RetrofitInitializer().modelsService()

        val call = service.updateCategoria(id, categoria)
        call.enqueue(object : Callback<Categoria?> {
            override fun onResponse(call: Call<Categoria?>?, response: Response<Categoria?>?) {

                if (iCallbackResponse != null) {
                    response?.body()?.let {
                        val categoria: Categoria = it
                        iCallbackResponse.success(categoria)
                    }
                }
                Log.i(TAG, "[INFO] updateCategoria sucessfull.")
            }

            override fun onFailure(call: Call<Categoria?>?, t: Throwable?) {
                Log.e(TAG, "[ERROR] updateCategoria error.")
            }
        })
    }

    /**
     * Listar Topico por Categoria
     */
    fun listarTopicoCategoria(id: Int, iCallbackResponse: ICallbackResponse<List<Topico>>? = null) {
        val service = RetrofitInitializer().modelsService()

        val call = service.getTopicosCategoria(id)
        call.enqueue(object : Callback<List<Topico>?> {
            override fun onResponse(call: Call<List<Topico>?>?, response: Response<List<Topico>?>?) {

                if (iCallbackResponse != null) {
                    response?.body()?.let {
                        val topicos: List<Topico> = it
                        iCallbackResponse.success(topicos)
                    }
                }

                Log.i(TAG, "[INFO] listarComentarios sucessfull.")
            }

            override fun onFailure(call: Call<List<Topico>?>?, t: Throwable?) {
                Log.i(TAG, "[ERROR] listarComentarios error.")
            }
        })
    }

    /*
    Tópicos
     */
    /**
     * Listar Tópicos
     */
    fun getTopicos(iCallbackResponse: ICallbackResponse<List<Topico>>? = null) {
        // Inicializa o serviço
        val service = RetrofitInitializer().modelsService()

        // Faz a chamada de API
        val call = service.getTopicos()
        // Registra o callback da chamada de API
        call.enqueue(object : Callback<List<Topico>?> {
            // Se deu certo
            override fun onResponse(call: Call<List<Topico>?>?, response: Response<List<Topico>?>?) {

                // Testa se está ok e retorna a chamada de callback
                if (iCallbackResponse != null) {
                    response?.body()?.let {
                        val topicos: List<Topico> = it
                        iCallbackResponse.success(topicos)
                    }
                }

                Log.i(TAG, "[INFO] getTopicos sucessfull.")
            }

            override fun onFailure(call: Call<List<Topico>?>?, t: Throwable?) {
                Log.i(TAG, "[ERROR] getTopicos error.")
            }
        })
    }

    /**
     * Atualizar Tópicos
     */
    fun updateTopico(id: Int, topico: Topico, iCallbackResponse: ICallbackResponse<Topico>? = null) {
        val service = RetrofitInitializer().modelsService()

        val call = service.updateTopico(id, topico)
        call.enqueue(object : Callback<Topico?> {
            override fun onResponse(call: Call<Topico?>?, response: Response<Topico?>?) {

                if (iCallbackResponse != null) {
                    response?.body()?.let {
                        val topico: Topico = it
                        iCallbackResponse.success(topico)
                    }
                }
                Log.i(TAG, "[INFO] updateTopico sucessfull.")
            }

            override fun onFailure(call: Call<Topico?>?, t: Throwable?) {
                Log.i(TAG, "[ERROR] updateTopico error.")
            }
        })
    }

    /**
     * Inserir Tópicos
     */
    fun insertTopico(topico: Topico, iCallbackResponse: ICallbackResponse<Topico>? = null) {
        val service = RetrofitInitializer().modelsService()

        val call = service.insertTopico(topico)
        call.enqueue(object : Callback<Topico?> {
            override fun onResponse(call: Call<Topico?>?, response: Response<Topico?>?) {
                if (iCallbackResponse != null) {
                    response?.body()?.let {
                        val topico: Topico = it
                        iCallbackResponse.success(topico)
                    }
                }
                Log.i(TAG, "[INFO] insertTopico sucessfull.")
            }

            override fun onFailure(call: Call<Topico?>?, t: Throwable?) {
                Log.i(TAG, "[ERROR] insertTopico error.")
            }
        })
    }

    /**
     * Remover Tópicos
     */
    fun removeTopico(id: Int, iCallbackResponse: ICallbackResponse<Any>? = null) {
        val service = RetrofitInitializer().modelsService()

        val call = service.removeTopico(id)
        call.enqueue(object : Callback<Any?> {
            override fun onResponse(call: Call<Any?>?, response: Response<Any?>?) {
                if (response != null && response.isSuccessful) {
                    Log.i(TAG, "[INFO] removeTopico sucessfull.")
                } else {
                    Log.i(TAG, "[INFO] removeTopico error.")
                }
            }

            override fun onFailure(call: Call<Any?>?, t: Throwable?) {
                Log.i(TAG, "[ERROR] removeTopico error.")
            }
        })
    }

    /*
    Comentários
     */
    /**
     * Listar Comentários
     */
    fun getComentarios(iCallbackResponse: ICallbackResponse<List<Comentario>>? = null) {
        // Inicializa o serviço
        val service = RetrofitInitializer().modelsService()

        // Faz a chamada de API
        val call = service.getComentarios()
        // Registra o callback da chamada de API
        call.enqueue(object : Callback<List<Comentario>?> {
            // Se deu certo
            override fun onResponse(call: Call<List<Comentario>?>?, response: Response<List<Comentario>?>?) {

                // Testa se está ok e retorna a chamada de callback
                if (iCallbackResponse != null) {
                    response?.body()?.let {
                        val comentarios: List<Comentario> = it
                        iCallbackResponse.success(comentarios)
                    }
                }

                Log.i(TAG, "[INFO] getComentarios sucessfull.")
            }

            override fun onFailure(call: Call<List<Comentario>?>?, t: Throwable?) {
                Log.i(TAG, "[ERROR] getComentarios error.")
            }
        })
    }

    /**
     * Atualizar Comentários
     */
    fun updateComentarios(id: Int, comentario: Comentario, iCallbackResponse: ICallbackResponse<Comentario>? = null) {
        val service = RetrofitInitializer().modelsService()

        val call = service.updateComentario(id, comentario)
        call.enqueue(object : Callback<Comentario?> {
            override fun onResponse(call: Call<Comentario?>?, response: Response<Comentario?>?) {

                if (iCallbackResponse != null) {
                    response?.body()?.let {
                        val comentario: Comentario = it
                        iCallbackResponse.success(comentario)
                    }
                }
                Log.i(TAG, "[INFO] updateComentario sucessfull.")
            }

            override fun onFailure(call: Call<Comentario?>?, t: Throwable?) {
                Log.i(TAG, "[ERROR] updateComentario error.")
            }
        })
    }

    /**
     * Inserir Comentários
     */
    fun insertComentarios(comentario: Comentario, iCallbackResponse: ICallbackResponse<Comentario>? = null) {
        val service = RetrofitInitializer().modelsService()

        val call = service.insertComentario(comentario)
        call.enqueue(object : Callback<Comentario?> {
            override fun onResponse(call: Call<Comentario?>?, response: Response<Comentario?>?) {
                if (iCallbackResponse != null) {
                    response?.body()?.let {
                        val comentario: Comentario = it
                        iCallbackResponse.success(comentario)
                    }
                }
                Log.i(TAG, "[INFO] insertComentariosucessfull.")
            }

            override fun onFailure(call: Call<Comentario?>?, t: Throwable?) {
                Log.i(TAG, "[ERROR] insertComentario error.")
            }
        })
    }

    /**
     * Remover Comentários
     */
    fun removeComentarios(id: Int, iCallbackResponse: ICallbackResponse<Any>? = null) {
        val service = RetrofitInitializer().modelsService()

        val call = service.removeComentario(id)
        call.enqueue(object : Callback<Any?> {
            override fun onResponse(call: Call<Any?>?, response: Response<Any?>?) {
                if (response != null && response.isSuccessful) {
                    Log.i(TAG, "[INFO] removeComentario sucessfull.")
                } else {
                    Log.i(TAG, "[INFO] removeComentario error.")
                }
            }

            override fun onFailure(call: Call<Any?>?, t: Throwable?) {
                Log.i(TAG, "[ERROR] removeComentario error.")
            }
        })
    }

    /**
     * Listar Comentarios Topico
     */
    fun listarComentariosTopico(id: Int, iCallbackResponse: ICallbackResponse<List<Comentario>>? = null) {
        val service = RetrofitInitializer().modelsService()

        val call = service.getComentariosTopico(id)
        call.enqueue(object : Callback<List<Comentario>?> {
            override fun onResponse(call: Call<List<Comentario>?>?, response: Response<List<Comentario>?>?) {

                if (iCallbackResponse != null) {
                    response?.body()?.let {
                        val comentario: List<Comentario> = it
                        iCallbackResponse.success(comentario)
                    }
                }

                Log.i(TAG, "[INFO] listarComentarios sucessfull.")
            }

            override fun onFailure(call: Call<List<Comentario>?>?, t: Throwable?) {
                Log.i(TAG, "[ERROR] listarComentarios error.")
            }
        })
    }
}