package com.moveis.helloworld.restservice

interface ICallbackResponse<T> {
    fun success(instance: T)
}