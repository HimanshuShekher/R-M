package com.example.rm.data.network

import com.example.rm.data.model.Character
import com.example.rm.data.model.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("api/character")
    suspend fun getCharacters(): Response<CharacterResponse>

    @GET("api/character/{id}")
    suspend fun getCharacterDetail(@Path("id") id: Int): Response<Character>
}
