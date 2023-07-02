package com.erkindilekci.instagramuiclone.model

data class Post(
    val id: Int,
    val image: String,
    val user: User,
    val isLiked: Boolean = false,
    val likesCount: Int,
    val commentsCount: Int,
    val timeStamp: Long
)

data class Story(
    val image: String,
    val name: String,
    val isSeen: Boolean = false
)

val names = arrayOf(
    "liam",
    "noah",
    "leon",
    "hugo",
    "lucas",
    "oscar",
    "milo",
    "louis",
    "adam",
    "henry"
)
