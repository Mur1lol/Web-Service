package br.edu.ifpr.murilo.webservice.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Resultado(
    var status: String,
    var totalResults: Int,
    var articles: List<Article>
)