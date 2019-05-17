package br.edu.ifpr.murilo.webservice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Picasso
            .get()
            .load("http://i.imgur.com/DvpvklR.png")
            .error(R.drawable.ic_launcher_background)
            .into(imageView)
    }
}
