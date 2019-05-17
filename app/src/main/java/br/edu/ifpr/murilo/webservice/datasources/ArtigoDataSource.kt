package br.edu.ifpr.murilo.webservice.datasources

import br.edu.ifpr.murilo.webservice.entidades.Article
import io.reactivex.Completable
import io.reactivex.Single

interface ArtigoDataSource {
    fun getNews(
        busca: String,
        pais: String = "br",
        apiKey: String = "ef6b7eef6082426ba0a7990ceb0ce8fd"
    )
}