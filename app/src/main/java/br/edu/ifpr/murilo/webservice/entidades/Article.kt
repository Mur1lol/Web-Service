package br.edu.ifpr.murilo.webservice.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.sql.Date
import java.text.DateFormat

@Entity(tableName = "articles")
data class Article(
    var source: Source,
    @SerializedName("author")
    var autor: String,
    @SerializedName("title")
    var titulo: String,
    @SerializedName("description")
    var descricao: String,
    var url: String,
    var urlToImage: String,
    @SerializedName("publishedAt")
    var publicado: String,
    @SerializedName("content")
    var conteudo: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
