package com.example.errors

open class ApiException: Exception {
    constructor(msg: String): super(msg);
    constructor(msg: String, throwable: Throwable): super(msg, throwable);

}