package com.erkindilekci.instagramuiclone.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.erkindilekci.instagramuiclone.R
import com.erkindilekci.instagramuiclone.util.ProfilePosts

@Composable
fun ProfileScreen() {
    val posts = ProfilePosts.posts

    Column {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.surface)
        ) {
            Row {
                ProfileImage(
                    imageUrl = "https://media.licdn.com/dms/image/D4E03AQGFTSq8qdsjZw/profile-displayphoto-shrink_800_800/0/1680002356682?e=2147483647&v=beta&t=-MmMSIK2tzSLk98TV-jm5UY4bS3DFzgFC3qYMzEBSyk"
                )

                Text(
                    text = "${posts.size}\nposts",
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onSurface
                )
                Text(
                    text = "2450\nfollowers",
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onSurface
                )
                Text(
                    text = "348\nfollowing",
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onSurface
                )
            }
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = "Erkin Dilekçi",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onSurface
                )

                Text(
                    text = "This is my bio",
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 15.sp
                )
            }
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .padding(start = 8.dp, bottom = 8.dp)
                    .weight(4f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = MaterialTheme.colors.onSurface
                ),
                shape = RoundedCornerShape(15)
            ) {
                Text(text = "Edit Profile")
            }

            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .padding(start = 4.dp, bottom = 8.dp)
                    .weight(4f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = MaterialTheme.colors.onSurface
                ),
                shape = RoundedCornerShape(15)
            ) {
                Text(text = "Share profile")
            }

            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .padding(start = 4.dp, end = 8.dp, bottom = 8.dp)
                    .weight(1.5f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = MaterialTheme.colors.onSurface
                ),
                shape = RoundedCornerShape(15)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.outline_person_add_24),
                    contentDescription = null,
                    tint = MaterialTheme.colors.onSurface
                )
            }
        }

        PostList(
            posts = posts,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(1.dp)
        )
    }
}

@Composable
fun ProfileImage(imageUrl: String?) {
    Box(modifier = Modifier.padding(top = 16.dp)) {
        UserImageCard(
            userImage = imageUrl, modifier = Modifier
                .padding(8.dp)
                .size(110.dp)
        )
    }
}

@Composable
fun PostList(
    posts: List<String>,
    modifier: Modifier
) {
    LazyVerticalGrid(modifier = modifier, columns = GridCells.Fixed(3)) {
        items(posts) {
            CommonImage(data = it)
            Divider(color = Color.Black)
        }
    }
}

@Composable
fun CommonImage(
    data: String?
) {
    data?.let {
        AsyncImage(
            model = data,
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(120.dp),
            contentScale = ContentScale.FillBounds,
            placeholder = painterResource(id = R.drawable.loading)
        )
    }
}

@Composable
fun UserImageCard(
    userImage: String?,
    modifier: Modifier = Modifier
) {
    Card(
        shape = CircleShape, modifier = modifier
            .padding(8.dp)
            .size(64.dp)
    ) {
        if (userImage.isNullOrEmpty()) {
            Image(
                painter = painterResource(id = R.drawable.ic_user),
                modifier = Modifier
                    .size(55.dp),
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.Gray)
            )
        } else {
            CommonImage(data = userImage)
        }
    }
}

@Preview
@Composable
fun ProfileScreenPrev() {
    ProfileScreen()
}