package com.erkindilekci.instagramuiclone.model

data class User(
    val name: String,
    val username: String,
    val image: String
)

val currentUser = User(
    name = "Erkin Dilekci",
    username = "erkindilekci",
    image = "https://media.licdn.com/dms/image/D4E03AQGFTSq8qdsjZw/profile-displayphoto-shrink_800_800/0/1680002356682?e=2147483647&v=beta&t=-MmMSIK2tzSLk98TV-jm5UY4bS3DFzgFC3qYMzEBSyk"
)
