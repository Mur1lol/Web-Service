package br.edu.ifpr.murilo.webservice.bd

import androidx.room.Database
import androidx.room.RoomDatabase
import br.edu.ifpr.murilo.webservice.bd.dao.ArtigoDao
import br.edu.ifpr.murilo.webservice.entidades.Article

@Database(entities = arrayOf(Article::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun artigoDao(): ArtigoDao
}