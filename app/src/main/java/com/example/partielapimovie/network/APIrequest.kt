package com.example.partielapimovie.network

import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.example.partielapimovie.MovieApp
import com.example.partielapimovie.model.Film
import org.json.JSONArray
import org.json.JSONObject

class APIrequest {

    companion object {

        fun searchMovies(success: (film: Array<Film>) -> Unit, failure: (error: VolleyError?) -> Unit) {

            val url  = URLBuilder.UrlMovieSearcher()
            Log.d("url",url)
            Log.d("ok","Super")


            val requete = JsonArrayRequest(Request.Method.GET, url, null,
                Response.Listener { response ->
                    Log.d("hah",response.toString())

                },
                Response.ErrorListener { error ->
                }
            )

            // Access the RequestQueue through your singleton class.
            MovieApp.requetQueue.add(requete)

        }


        fun getMovies(success: (movies: MutableList<Film>) -> Unit, failure: (error: VolleyError?) ->Unit  ) {
            // Instantiate the RequestQueue.

            val url: String = URLBuilder.UrlMovieSearcher()

            // Request a string response from the provided URL.
            val stringReq = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    Log.d( "letest","response")
                    var strResp = response.toString()
                    val jsonObj: JSONObject = JSONObject(strResp)

                    //Déclaration variables et recup de la requete
                    val jsonArray: JSONArray = jsonObj.getJSONArray("results")
                    var titre: String = ""
                    var image: String = ""
                    var description : String = ""
                    val listeFilms = mutableListOf<Film>()
                    var jsonInner: JSONObject = jsonArray.getJSONObject(0)

                    for (i in 0 until  jsonArray.length()) {
                        var jsonInner: JSONObject = jsonArray.getJSONObject(i)
                        titre = "\n" + jsonInner.get("name")

                        image = jsonInner.getJSONObject("image").getString("small_url")
                        description = "\n" + jsonInner.get("description")
                        Log.d( "letest","Le titre: $titre ")

                        listeFilms.add(Film(titre,image,description))

                    }
                    success(listeFilms)
                    // success(JsonToMovies(jsonArray))
                },
                Response.ErrorListener { Log.d( "ERROR","Impossible de trouver les films") })


            MovieApp.requetQueue.add(stringReq)
            }
        }

    }