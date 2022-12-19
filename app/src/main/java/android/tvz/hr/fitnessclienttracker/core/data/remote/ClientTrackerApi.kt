package android.tvz.hr.fitnessclienttracker.core.data.remote

import android.tvz.hr.fitnessclienttracker.core.data.local.User
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ClientTrackerApi {
    @Headers("Content-Type: application/json")
    @POST("/register")
    suspend fun registerAccount(
        @Body user: User
    ) : RegisterResponse
}