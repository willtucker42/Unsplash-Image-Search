package com.codinginflow.imagesearchapp.api

import com.codinginflow.imagesearchapp.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi {
    /*
    * query: Search terms
    * page: Page number to retrieve (For pagination)
    * per_page: Number of items per page
     */
    companion object {
        // Companion objects allow us to create static variables. Kotlin doesn't have static keyword
        const val BASE_URL = "https://api.unsplash.com/"
        const val API_KEY = BuildConfig.UNSPLASH_ACCESS_KEY
    }
    @Headers("Accept-Version: v1", "Authorization: Client-ID $API_KEY")
    @GET("search/photos")
    suspend fun searchPhotos(
        // suspend functions can be paused and resumed without blocking the thread they are called on
        // can only be called from another suspend function or coroutine
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): UnsplashResponse
}