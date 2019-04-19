package com.example.partielapimovie

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.partielapimovie.model.Film
import kotlinx.android.synthetic.main.activity_description.*

class DescriptionActivity : AppCompatActivity() {

    companion object {

        private val INTENT_MOVIE = "intent_movie"

            fun createIntent(context: Context, film: Film): Intent {
                val intent = Intent(context, DescriptionActivity::class.java)
                intent.putExtra(INTENT_MOVIE, film)
                return intent
            }
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_description)

            val film = intent.getParcelableExtra<Film>(INTENT_MOVIE)

            this.title = film.title


            Glide
                .with(imgDescription)
                .load(film.URLimage)
                .into(imgDescription)

            //Remplir la description du film
            tvTitreFilmD.text = film.title
            tvDescription.text = film.description


        }
}
