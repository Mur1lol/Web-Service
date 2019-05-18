package br.edu.ifpr.murilo.webservice.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifpr.murilo.webservice.R
import br.edu.ifpr.murilo.webservice.entidades.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.artigos_adapter.view.*
import java.text.DateFormat
import java.util.*

class ArtigosAdapter(private var articles: List<Article>) :
    RecyclerView.Adapter<ArtigosAdapter.ArtigoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ArtigoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.artigos_adapter, parent, false)
        )

    override fun getItemCount() = articles.size

    override fun onBindViewHolder(holder: ArtigoViewHolder, position: Int) =
        holder.preencherView(articles[position])

    inner class ArtigoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun preencherView(article: Article) {

            itemView.txtTitulo.text = article.titulo
            itemView.txtDescricao.text = article.descricao
            itemView.txtConteudo.text = article.conteudo
            itemView.txtAutor.text = article.autor
            itemView.txtPublicado.text = article.publicado

            val date = Date()
            val abc = DateFormat.getDateInstance(DateFormat.SHORT).format(date)
            Log.e("Mur1lol", abc)

            Picasso.get().load(article.urlToImage).into(itemView.imageView2)

            itemView.btMais.setOnClickListener {

            }

        }
    }

}