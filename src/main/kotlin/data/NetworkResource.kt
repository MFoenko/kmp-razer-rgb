package data

import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.flow.flow

sealed class NetworkResource<T> {
    class Success<T>(
        val resource: T
    ): NetworkResource<T>()

    class Failure<T>(
        val message: String?
    ): NetworkResource<T>()
}
