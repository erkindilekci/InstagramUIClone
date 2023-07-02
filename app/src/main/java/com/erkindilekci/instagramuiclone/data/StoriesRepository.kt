package com.erkindilekci.instagramuiclone.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.erkindilekci.instagramuiclone.model.Story
import com.erkindilekci.instagramuiclone.model.currentUser
import com.erkindilekci.instagramuiclone.model.names

object StoriesRepository {

    private val stories = mutableStateOf<List<Story>>(emptyList())
    private fun populateStories() {
        val _stories = ArrayList<Story>()

        _stories.add(
            Story(
                image = currentUser.image,
                name = "Your Story"
            )
        )

        (0..9).forEach { index ->
            val story = Story(
                image = "https://randomuser.me/api/portraits/men/${index + 15}.jpg",
                name = names[index]
            )
            _stories.add(story)
        }

        stories.value = _stories
    }

    init {
        populateStories()
    }

    fun observeStories(): MutableState<List<Story>> = stories
}