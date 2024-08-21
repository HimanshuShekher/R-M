package com.example.rm.data.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CharacterResponse(
    @SerializedName("results")
    val results: List<Character>
)


data class Character(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("species")
    val species: String,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("origin")
    val origin: Origin,

    @SerializedName("location")
    val location: Location
) : Serializable


data class Origin(
    @SerializedName("name")
    val name: String
) : Serializable


data class Location(
    @SerializedName("name")
    val name: String
) : Serializable
