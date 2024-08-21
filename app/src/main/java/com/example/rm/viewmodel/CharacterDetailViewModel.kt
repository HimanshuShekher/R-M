package com.example.rm.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rm.data.model.Character
import com.example.rm.data.repository.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterDetailViewModel(private val repository: CharacterRepository) : ViewModel() {
    private val _characterDetail = MutableStateFlow<Character?>(null)
    val characterDetail: StateFlow<Character?> get() = _characterDetail

    fun fetchCharacterDetail(id: Int) {
        viewModelScope.launch {
            try {
                val character = repository.getCharacterDetail(id)
                _characterDetail.value = character
            } catch (e: Exception) {
                Log.e("CharacterDetailViewModel", "Error: ${e.message}", e)
                _characterDetail.value = null
            }
        }
    }
}
