package net.projecttl.ploky.ui

import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import net.projecttl.ploky.CameraActivity
import net.projecttl.ploky.R
import net.projecttl.ploky.model.Page
import net.projecttl.ploky.ui.theme.ColorScheme

@Composable
fun CameraButton(action: () -> Unit = {}) {
    Button(
        onClick = action,
        contentPadding = PaddingValues(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = ColorScheme.BrandPrimary
        ),
        border = BorderStroke(4.dp, ColorScheme.BrandPlaceHolder),
        modifier = Modifier
            .width(68.dp)
            .height(68.dp)
    ) {
        Image(
            painterResource(R.drawable.camera),
            null,
            modifier = Modifier.padding(1.dp)
                .width(36.dp)
                .height(36.dp)
        )
    }
}

@Composable
fun BottomBar(page: MutableState<Page>) {
    val ctx = LocalContext.current

    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.fillMaxWidth()
                .height(84.dp)
                .padding(horizontal = 20.dp),
        ) {
            IconButton(onClick = { page.value = Page.HOME }) {
                val color = if (page.value == Page.HOME) {
                    ColorScheme.BrandPrimary
                } else {
                    Color.White
                }

                Icon(painterResource(R.drawable.home), null, tint = color)
            }

            IconButton(onClick = { page.value = Page.MAP }) {
                val color = if (page.value == Page.MAP) {
                    ColorScheme.BrandPrimary
                } else {
                    Color.White
                }

                Icon(painterResource(R.drawable.map), null, tint = color)
            }

            CameraButton {
                val intent = Intent(ctx, CameraActivity::class.java)
                ctx.startActivity(intent)
            }

            IconButton(onClick = { page.value = Page.COIN }) {
                val color = if (page.value == Page.COIN) {
                    ColorScheme.BrandPrimary
                } else {
                    Color.White
                }

                Icon(painterResource(R.drawable.coin), null, tint = color)
            }

            IconButton(onClick = { page.value = Page.MORE }) {
                val color = if (page.value == Page.MORE) {
                    ColorScheme.BrandPrimary
                } else {
                    Color.White
                }

                Icon(painterResource(R.drawable.more), null, tint = color)
            }
        }

        Spacer(Modifier.height(55.dp))
    }
}

@Composable
fun BottomBar(photo: () -> Unit = {}, flip: () -> Unit = {}, action: () -> Unit = {}) {
    val ctx = LocalContext.current

    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.fillMaxWidth()
                .height(84.dp)
                .padding(horizontal = 20.dp),
        ) {
            IconButton(onClick = photo) {
                Icon(painterResource(R.drawable.image), null)
            }

            CameraButton(action = action)

            IconButton(onClick = flip) {
                Icon(painterResource(R.drawable.flip), null)
            }
        }

        Spacer(Modifier.height(55.dp))
    }
}
