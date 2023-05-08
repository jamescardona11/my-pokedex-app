package com.tkmonkey.mypokedexapp.pokemondetail

import androidx.lifecycle.ViewModel
import com.tkmonkey.mypokedexapp.data.remote.responses.Pokemon
import com.tkmonkey.mypokedexapp.data.repository.PokemonRepository
import com.tkmonkey.mypokedexapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemon(pokemonName)
    }
}