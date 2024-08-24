package net.projecttl.ploky.ui

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.projecttl.ploky.R
import net.projecttl.ploky.ViewActivity
import net.projecttl.ploky.model.Page

@Composable
fun TopBar(page: MutableState<Page>) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
                .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 20.dp)
        ) {
            Spacer(Modifier.width(5.dp))
            Text(
                page.value.pageName,
                fontSize = 20.sp,
                fontWeight = FontWeight(600)
            )
            Spacer(Modifier.width(5.dp))
        }
    }
}

@Composable
fun TopCam() {
    val ctx = LocalContext.current

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
                .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 20.dp)
        ) {
            IconButton(onClick = { ctx.startActivity(Intent(ctx, ViewActivity::class.java)) }) {
                Icon(painterResource(R.drawable.back), null)
            }

            Text(
                "Camera",
                fontSize = 20.sp,
                fontWeight = FontWeight(600)
            )

            IconButton(onClick = {  }) {
                Icon(painterResource(R.drawable.flash), null)
            }
        }
    }
}
