package com.example.rm.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rm.data.model.Character
import com.example.rm.data.repository.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterListViewModel(private val repository: CharacterRepository) : ViewModel() {
    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters: StateFlow<List<Character>> get() = _characters

    fun fetchCharacters() {
        viewModelScope.launch {
            try {
                Log.d("CL", "Fetching")
                val result = repository.getCharacters()
                Log.d("CL", "Characters: ${result.size} items")
                _characters.value = result
            } catch (e: Exception) {
                Log.e("CL", "Error: ${e.message}", e)
                _characters.value = emptyList()
            }
        }
    }
}
