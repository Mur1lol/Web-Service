package br.edu.ifpr.murilo.webservice.servicos

import br.edu.ifpr.murilo.webservice.entidades.Article
import br.edu.ifpr.murilo.webservice.entidades.Resultado
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.*

interface ArtigosService {
    @GET("top-headlines")
    fun getNews(

        @Query("q")
        busca: String,

        @Query("country")
        pais: String,

        @Query("apiKey")
        apiKey: String

    ): Call<Resultado>
}