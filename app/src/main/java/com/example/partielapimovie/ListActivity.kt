package com.example.partielapimovie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.partielapimovie.item.FilmItem
import com.example.partielapimovie.model.Film
import com.example.partielapimovie.network.APIrequest
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    val listFilm = mutableListOf<Film>() // liste de films

    private lateinit var filmAdapter: FastItemAdapter<FilmItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        filmAdapter = FastItemAdapter<FilmItem>()

        ListRecyclerView.adapter = filmAdapter

        ListRecyclerView.layoutManager = LinearLayoutManager(this)

        ListRecyclerView.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))


        filmAdapter.withOnClickListener { view, adapter, item, position ->
            val film = item.film
            val intent = DescriptionActivity.createIntent(this, film)

            startActivity(intent)

            true
        }
        getFilms()

    }

    fun getFilms() {

        filmAdapter.clear()
        APIrequest.getMovies({ resultMovies ->
            filmAdapter.clear()

            for (movie in resultMovies) {
                filmAdapter.add(FilmItem(movie))
            }
        }, {
        })
    }

    fun findMovies() {
        APIrequest.searchMovies({ resultMovies ->
            filmAdapter.clear()

            for (movie in resultMovies) {
                filmAdapter.add(FilmItem(movie))
            }
        }, {
        })

    }


}
