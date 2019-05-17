package br.edu.ifpr.murilo.webservice.entidades

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.sql.Date

@Entity(tableName = "artigos")
data class Article(
    var source: List<Source>,
    @SerializedName("author")
    var autor: String,
    @SerializedName("title")
    var titulo: String,
    @SerializedName("description")
    var descricao: String,
    var url: String,
    var urlToImage: String,
    @SerializedName("publishedAt")
    var publicado: Date,
    @SerializedName("content")
    var conteudo: String
)
