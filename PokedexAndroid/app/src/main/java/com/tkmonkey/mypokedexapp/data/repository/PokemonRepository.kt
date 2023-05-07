package com.tkmonkey.mypokedexapp.data.repository

import com.tkmonkey.mypokedexapp.data.remote.PokeApi
import com.tkmonkey.mypokedexapp.data.remote.responses.Pokemon
import com.tkmonkey.mypokedexapp.data.remote.responses.PokemonList
import com.tkmonkey.mypokedexapp.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
){

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        }catch (e: Exception) {
            return Resource.Error("An unknown error occurred")
        }

        return Resource.Success(response)
    }

    suspend fun getPokemon(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        }catch (e: Exception) {
            return Resource.Error("An unknown error occurred")
        }

        return Resource.Success(response)
    }

}