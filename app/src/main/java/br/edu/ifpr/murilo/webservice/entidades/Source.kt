package br.edu.ifpr.murilo.webservice.entidades

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Source (
    @SerializedName("name")
    var nome: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}