package com.annaginagili.avengers

import com.google.gson.annotations.SerializedName

class Hero(name: String, realName: String, team: String, firstAppearance: String, createdBy: String,
publisher: String, imageUrl: String, bio: String) {
    @SerializedName("name")
    private var name = name
    @SerializedName("realname")
    private var realName = realName
    @SerializedName("team")
    private var team = team
    @SerializedName("firstappearance")
    private var firstAppearance = firstAppearance
    @SerializedName("createdby")
    private var createdBy = createdBy
    @SerializedName("publisher")
    private var publisher = publisher
    @SerializedName("imageurl")
    private var imageUrl = imageUrl
    @SerializedName("bio")
    private var bio = bio

    fun getName(): String {
        return name
    }

    fun getRealName(): String {
        return realName
    }

    fun getTeam(): String {
        return team
    }

    fun getFirstAppearance(): String {
        return firstAppearance
    }

    fun getCreatedBy(): String {
        return createdBy
    }

    fun getPublisher(): String {
        return publisher
    }

    fun getImageUrl(): String {
        return imageUrl
    }

    fun getBio(): String {
        return bio
    }
}