package com.sobolev.usersapp.data.network

import com.sobolev.usersapp.data.network.dto.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/")
    suspend fun getAllUsers(
        @Query("results") count: Int = 10
    ): UserResponse
}