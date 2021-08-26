package com.example.tools2.model

import com.google.gson.annotations.SerializedName

sealed class DataClasses(){

    data class Joke(@SerializedName("id") val id : Int,
                    @SerializedName("type") val type : String,
                    @SerializedName("setup") val setup : String,
                    @SerializedName("punchline") val punchline : String):DataClasses()
}
