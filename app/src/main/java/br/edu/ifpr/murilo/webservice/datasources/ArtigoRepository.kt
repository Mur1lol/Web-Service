package br.edu.ifpr.murilo.webservice.datasources

import br.edu.ifpr.murilo.webservice.entidades.Article
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class ArtigoRepository: ArtigoDataSource {
    private val dataSource: ArtigoDataSource
        get() = ArtigoRemoteDataSource()

    override fun getNews(busca: String, pais: String, apiKey: String) {
        return dataSource.getNews("", "br", "ef6b7eef6082426ba0a7990ceb0ce8fd")
            .subscribeOn(Schedulers.io())
    }
}