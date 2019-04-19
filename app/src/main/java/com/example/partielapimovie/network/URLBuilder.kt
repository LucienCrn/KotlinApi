package com.example.partielapimovie.network

class URLBuilder {

    companion object {

        //Clef de l'api
        val apiKey = "eaf024e6930da02103a1d6f7dd1f98f175c3ae5a"

        //Url du film
        fun UrlMovieSearcher() : String {

            return "https://comicvine.gamespot.com/api/movies/?api_key=$apiKey&format=json"

        }

    }

}