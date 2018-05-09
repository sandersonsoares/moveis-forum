package com.moveis.helloworld.restservice

import java.util.*

class Categoria(var id: Int? = null, var nome: String?)

class Topico(var id: Int? = null, var titulo: String?, var autor: String?, var descricao: String?,
             var categoria: Int? = null, var created_at: Date? = null, var updated_at: Date? = null)

class Comentario(var id: Int?, var autor: String?, var comentario: String?, var created_at: Date?, var updated_at: Date?, var topico: Int?)