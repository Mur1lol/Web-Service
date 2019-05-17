package br.edu.ifpr.murilo.webservice.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifpr.murilo.webservice.R
import br.edu.ifpr.murilo.webservice.R.id.imageView2
import br.edu.ifpr.murilo.webservice.entidades.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.artigos_adapter.view.*

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

            itemView.txtTitulo.setText(article.titulo)
            itemView.txtDescricao.setText(article.descricao)
            itemView.txtConteudo.setText(article.conteudo)
            itemView.txtAutor.setText(article.autor)
            itemView.txtPublicado.setText(article.publicado)

            Picasso.get().load(article.urlToImage).into(itemView.imageView2)



        }
    }

}