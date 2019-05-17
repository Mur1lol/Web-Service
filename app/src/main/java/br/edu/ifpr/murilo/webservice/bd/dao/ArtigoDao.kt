package br.edu.ifpr.murilo.webservice.bd.dao

import androidx.room.*
import br.edu.ifpr.murilo.webservice.entidades.Article
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface ArtigoDao {
    @Query("SELECT * FROM artigos")
    fun buscaTodas(): Single<List<Article>>

    @Insert
    fun inserir(noticia: Article): Single<Long>

    @Update
    fun atualizar(noticia: Article): Completable

    @Delete
    fun apagar(noticia: Article): Completable
}