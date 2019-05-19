package br.edu.ifpr.murilo.webservice.app

import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.ConfigurationCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifpr.murilo.webservice.R
import br.edu.ifpr.murilo.webservice.entidades.Article
import br.edu.ifpr.murilo.webservice.entidades.Resultado
import br.edu.ifpr.murilo.webservice.servicos.ArtigosService
import br.edu.ifpr.murilo.webservice.ui.ArtigosAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.text.DateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var retrofit: Retrofit
    lateinit var service: ArtigosService
    lateinit var adapter: ArtigosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipe.isRefreshing = true
        configuraRetrofit()
        carregaDados()

        swipe.setOnRefreshListener {
            swipe.isRefreshing = true
            carregaDados()
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    if (newText.length >= 3) {
                        carregaDados()
                        return false
                    }
                    else if(newText.isEmpty()) {
                        swipe.isRefreshing = true
                        carregaDados()
                    }
                }
                return false
            }
        })
    }

    fun configuraRetrofit() {
        retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        service = retrofit.create(ArtigosService::class.java)
    }

    fun carregaDados() {
        val locale = ConfigurationCompat.getLocales(Resources.getSystem().configuration).get(0)
        service.getNews(searchView.query.toString(), locale.country).enqueue(object : Callback<Resultado>{
            override fun onFailure(call: Call<Resultado>, t: Throwable) {
                swipe.isRefreshing = false
            }

            override fun onResponse(call: Call<Resultado>, response: Response<Resultado>) {
                val articles = response.body()?.articles
                swipe.isRefreshing = false
                if (articles != null)
                    configuraRecyclerView(articles)
            }
        })

    }

    fun configuraRecyclerView(articles: List<Article>) {
        adapter = ArtigosAdapter(articles)
        listArtigos.adapter = adapter
        listArtigos.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }
}
