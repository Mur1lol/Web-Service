package br.edu.ifpr.murilo.webservice.datasources

import br.edu.ifpr.murilo.webservice.entidades.Article
import br.edu.ifpr.murilo.webservice.servicos.ArtigosService
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
class ArtigoRemoteDataSource: ArtigoDataSource {
    var retrofit: Retrofit
    var service: ArtigosService

    init {
        retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        service = retrofit.create(ArtigosService::class.java)
    }

    override fun getNews(busca: String, pais: String, apiKey: String) {
        return service.getNews(
            "esporte",
            "br",
            "ef6b7eef6082426ba0a7990ceb0ce8fd"
        )
        .subscribeOn(Schedulers.io())
    }


}

