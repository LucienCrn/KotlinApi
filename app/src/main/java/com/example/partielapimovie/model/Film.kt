package com.example.partielapimovie.model

import android.media.Image
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.IntegerRes
import com.fasterxml.jackson.annotation.JacksonAnnotation
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)

class Film(): Parcelable {

    //Variables class film
                                //->API
    /*@JsonProperty(value = "id")
    private val id = null //id */

    @JsonProperty(value = "name")
    lateinit var title: String //->name

    @JsonProperty(value = "image")
    var URLimage: String? = null //->image

    @JsonProperty(value = "description")
    var description: String? = null //->description

    //Info pas forcement utile

    /*lateinit var rating: String //->rating

    lateinit var budget: String //->budget

    lateinit var bor: String //->box_office_revenu

    lateinit var trevenu: String //->total_revenu*/

    constructor(leTitle: String, lImage: String, laDescription: String) : this() {

        this.title = leTitle
        this.URLimage = lImage
        this.description = laDescription

    }

    constructor(parcel: Parcel) : this(){
        title = parcel.readString()
        URLimage = parcel.readString()
        description = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(URLimage)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Film> {
        override fun createFromParcel(parcel: Parcel): Film {
            return Film(parcel)
        }

        override fun newArray(size: Int): Array<Film?> {
            return arrayOfNulls(size)
        }
    }

}