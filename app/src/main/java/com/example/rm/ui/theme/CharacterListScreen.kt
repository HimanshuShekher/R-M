package com.example.rm.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.rm.data.network.RetrofitInstance
import com.example.rm.data.repository.CharacterRepository
import com.example.rm.viewmodel.CharacterListViewModel
import com.example.rm.viewmodel.CharacterListViewModelFactory

@Composable
fun CharacterListScreen(navController: NavController) {
    val apiService = RetrofitInstance.api
    val repository = CharacterRepository(apiService)

    val viewModel: CharacterListViewModel = viewModel(
        factory = CharacterListViewModelFactory(repository)
    )

    val characters by viewModel.characters.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCharacters()
    }

    LazyColumn {
        items(characters) { character ->
            ListItem(
                modifier = Modifier.clickable {
                    navController.navigate("character_detail/${character.id}")
                },
                headlineContent = { Text(text = character.name) },
                leadingContent = {

                    AsyncImage(
                        model = character.image,
                        contentDescription = character.name,
                        modifier = Modifier.size(40.dp)
                    )
                }
            )
        }
    }
}
