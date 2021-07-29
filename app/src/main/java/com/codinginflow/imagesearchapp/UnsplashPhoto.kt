package com.codinginflow.imagesearchapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/*
Parcelize allows us to send this object to another fragments/activities
Without Parcelize we would only be able to send primitive data such as strings and ints
 */
@Parcelize
data class UnsplashPhoto(
    val id: String,
    val description: String?,
    val urls: UnsplashPhotoUrls,
    val user: UnsplashUser
) : Parcelable {

    @Parcelize
    data class UnsplashPhotoUrls(
        val raw: String,
        val full: String,
        val small: String,
        val thumb: String,
        val regular: String
    ) : Parcelable

    @Parcelize
    data class UnsplashUser(
        val name: String,
        val username: String
    ) : Parcelable {
        val attributionUrl get() = "https://unsplash.com/$username?utm_source=ImageSearchApp&utm_medium=referral"
    }
}