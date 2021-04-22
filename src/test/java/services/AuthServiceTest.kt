package services

import ACCESS_TOKEN
import com.haroldadmin.cnradapter.NetworkResponse
import com.haroldadmin.cnradapter.invoke
import de.vkay.api.tmdb.TMDb
import kotlinx.coroutines.runBlocking
import org.junit.Test

class AuthServiceTest : BaseServiceTest() {

    @Test
    fun `Get request token`() = runBlocking {
        when (val response = TMDb.seasonService.details(SHOW_ID_HORIMIYA, 1)) {
            is NetworkResponse.Success -> {
                println("Success")
                println("Body: ${response.body}")
            }
            is NetworkResponse.NetworkError -> {
                println("NetworkError")
                println("Error: ${response.error.message}")
            }
            is NetworkResponse.ServerError -> {
                println("ServerError")
                println("Body: ${response.body}")
            }
            is NetworkResponse.UnknownError -> {
                println("UnknownError")
                println("Error: ${response.error.message}")
            }
        }
    }
}