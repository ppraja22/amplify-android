package com.amplifyframework.core.model

import com.amplifyframework.AmplifyException
import com.amplifyframework.core.Consumer


abstract class LazyModel< M: Model> {
    abstract fun getValue():M?

    abstract suspend fun get(): M?

    suspend fun require(): M {
        return get() ?: throw DataIntegrityException("Required model could not be found")
    }

    abstract fun get(onSuccess: Consumer<M>,
                     onFailure: Consumer<AmplifyException>)
}

 class DataIntegrityException(s: String) : Throwable() {

}