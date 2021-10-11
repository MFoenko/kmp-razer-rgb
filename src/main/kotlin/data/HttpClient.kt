package data

import io.ktor.client.*
import io.ktor.client.engine.curl.*

object Data {

    val client = HttpClient(Curl)

}