package com.example.rm.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.rm.data.network.RetrofitInstance
import com.example.rm.data.repository.CharacterRepository
import com.example.rm.viewmodel.CharacterDetailViewModel
import com.example.rm.viewmodel.CharacterDetailViewModelFactory

@Composable
fun CharacterDetailScreen(navController: NavController, characterId: Int) {

    val apiService = RetrofitInstance.api
    val repository = CharacterRepository(apiService)


    val viewModel: CharacterDetailViewModel = viewModel(
        factory = CharacterDetailViewModelFactory(repository)
    )


    val characterDetail by viewModel.characterDetail.collectAsState()


    LaunchedEffect(characterId) {
        viewModel.fetchCharacterDetail(characterId)
    }


    if (characterDetail != null) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Name: ${characterDetail!!.name}", style = MaterialTheme.typography.headlineMedium)
            Text(text = "Status: ${characterDetail!!.status}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Species: ${characterDetail!!.species}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Gender: ${characterDetail!!.gender}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Origin: ${characterDetail!!.origin.name}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Location: ${characterDetail!!.location.name}", style = MaterialTheme.typography.bodyMedium)
        }
    } else {
        CircularProgressIndicator(modifier = Modifier.padding(16.dp))
    }
}
