package com.example.partielapimovie.item

import android.view.View
import com.bumptech.glide.Glide
import com.example.partielapimovie.R
import com.example.partielapimovie.model.Film
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.cellule_list.view.*

class FilmItem(val film: Film): AbstractItem<FilmItem, FilmItem.MovieViewHolder>() {

    override fun getType(): Int {
        return R.id.cellTitle
    }

    override fun getViewHolder(v: View): MovieViewHolder {
        return MovieViewHolder(v)
    }

    override fun getLayoutRes(): Int {
        return R.layout.cellule_list
    }

    class MovieViewHolder(itemView: View) : FastAdapter.ViewHolder<FilmItem>(itemView) {

        override fun unbindView(item: FilmItem) {
            itemView.cellTitle.text = null
        }

        override fun bindView(item: FilmItem, payloads: MutableList<Any>) {
            val film = item.film

            itemView.cellTitle.text = film.title

            Glide
                .with(itemView.cellImg)
                .load(film.URLimage)
                .into(itemView.cellImg)
        }
    }

}