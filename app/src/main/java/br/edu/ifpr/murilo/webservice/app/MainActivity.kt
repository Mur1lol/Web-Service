package br.edu.ifpr.murilo.webservice.app

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
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

class MainActivity : AppCompatActivity() {

    lateinit var retrofit: Retrofit
    lateinit var service: ArtigosService
    lateinit var adapter: ArtigosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configuraRetrofit()
        carregaDados()

        swipe.setOnRefreshListener {
            carregaDados()
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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
        service.getNews("mundo").enqueue(object : Callback<Resultado>{
            override fun onFailure(call: Call<Resultado>, t: Throwable) {

            }

            override fun onResponse(call: Call<Resultado>, response: Response<Resultado>) {
                val articles = response.body()?.articles
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
