package com.example.rm.data.repository

import android.util.Log
import com.example.rm.data.model.Character
import com.example.rm.data.model.CharacterResponse
import com.example.rm.data.network.ApiService
import retrofit2.Response
import java.io.IOException

class CharacterRepository(private val apiService: ApiService) {

    suspend fun getCharacters(): List<Character> {
        return try {
            val response: Response<CharacterResponse> = apiService.getCharacters()
            if (response.isSuccessful) {
                response.body()?.results ?: emptyList()
            } else {
                Log.e("CharacterRepository", "Error: ${response.errorBody()}")
                emptyList()
            }
        } catch (e: IOException) {
            Log.e("CharacterRepository", "IO: ${e.message}", e)
            emptyList()
        } catch (e: Exception) {
            Log.e("CharacterRepository", "Exception: ${e.message}", e)
            emptyList()
        }
    }

    suspend fun getCharacterDetail(id: Int): Character? {
        return try {
            val response: Response<Character> = apiService.getCharacterDetail(id)
            if (response.isSuccessful) {
                response.body()
            } else {
                Log.e("CR", "Error: ${response.errorBody()}")
                null
            }
        } catch (e: IOException) {
            Log.e("CR", "IO Exception: ${e.message}", e)
            null
        } catch (e: Exception) {
            Log.e("CR", "Exception: ${e.message}", e)
            null
        }
    }
}
