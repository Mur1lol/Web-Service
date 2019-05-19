package br.edu.ifpr.murilo.webservice.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifpr.murilo.webservice.R
import br.edu.ifpr.murilo.webservice.entidades.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.artigos_adapter.view.*
import java.text.DateFormat
import android.content.Intent
import android.net.Uri

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
            val publicado = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM).format(article.publicado)

            Picasso.get().load(article.urlToImage).into(itemView.imageView2)
            itemView.txtTitulo.text = article.titulo
            itemView.txtDescricao.text = article.descricao
            itemView.txtConteudo.text = article.conteudo
            itemView.txtAutor.text = article.autor
            itemView.txtNome.text = article.source.nome
            itemView.txtPublicado.text = publicado
            itemView.btMais.setOnClickListener { v ->
                val uri = Uri.parse(article.url)
                val intentBrowser = Intent(Intent.ACTION_VIEW, uri)
                v.context.startActivity(intentBrowser)
            }
        }
    }

}