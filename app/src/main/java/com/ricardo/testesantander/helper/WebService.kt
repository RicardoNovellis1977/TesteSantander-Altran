package com.ricardo.testesantander.helper

interface WebService {
    fun success(obj: Any?)
    fun erro(throwable: Throwable?)
}
