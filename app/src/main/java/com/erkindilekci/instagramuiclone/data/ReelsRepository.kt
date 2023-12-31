package com.erkindilekci.instagramuiclone.data

import com.erkindilekci.instagramuiclone.model.Reel
import com.erkindilekci.instagramuiclone.model.User
import com.erkindilekci.instagramuiclone.model.names

object ReelsRepository {

    private val reels = arrayListOf<Reel>()
    private fun populateReels() {
        val _reels = ArrayList<Reel>()
        (0..9).forEach { index ->
            val post = Reel(
                id = index + 1,
                video = videos[index],
                user = User(
                    name = names[index],
                    username = names[index],
                    image = "https://randomuser.me/api/portraits/men/${index + 15}.jpg"
                ),
                likesCount = index + 100,
                commentsCount = index + 20
            )
            _reels.add(post)
        }

        reels.clear()
        reels.addAll(_reels)
    }

    init {
        populateReels()
    }

    fun getReels(): List<Reel> = reels
}

private val videos = listOf(
    "video3.mp4",
    "video4.mp4",
    "video3.mp4",
    "video4.mp4",
    "video3.mp4",
    "video4.mp4",
    "video3.mp4",
    "video4.mp4",
    "video3.mp4",
    "video4.mp4"
)