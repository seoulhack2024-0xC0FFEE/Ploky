package net.projecttl.ploky

import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import net.projecttl.ploky.ui.theme.ColorScheme
import net.projecttl.ploky.ui.theme.PlokyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setOnExitAnimationListener { viewProvider ->
                ObjectAnimator.ofFloat(
                    viewProvider.view,
                    "scaleX",
                    0.5f, 0f
                ).apply {
                    interpolator = OvershootInterpolator()
                    duration = 300
                    doOnEnd { viewProvider.remove() }
                    start()
                }
                ObjectAnimator.ofFloat(
                    viewProvider.view,
                    "scaleY",
                    0.5f, 0f
                ).apply {
                    interpolator = OvershootInterpolator()
                    duration = 300
                    doOnEnd { viewProvider.remove() }
                    start()
                }
            }
        }

        actionBar?.hide()

        enableEdgeToEdge()
        setContent {
            PlokyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Login(this, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Login(ctx: Context, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxSize()
    ) {
        Column {
            Spacer(Modifier.height(70.dp))
            Image(
                painterResource(R.drawable.ploky),
                null,
                modifier = Modifier
                    .padding(1.dp)
                    .width(177.96001.dp)
                    .height(77.2.dp)
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to Ploky!")
            Spacer(Modifier.height(10.dp))
            OutlinedButton(
                modifier = Modifier
                    .padding(1.69492.dp)
                    .width(312.dp)
                    .height(60.dp),
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp
                ),
                border = BorderStroke(
                    width = 1.69492.dp,
                    color = ColorScheme.BrandPrimary
                ),
                onClick = {
                    val home = Intent(ctx, ViewActivity::class.java)
                    ctx.startActivity(home)
                }
            ) {
                Text(
                    "Login",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 27.sp,
                        color = ColorScheme.BrandPrimary,
                        letterSpacing = 0.9.sp
                    )
                )
            }

            Spacer(Modifier.height(12.dp))

            Button(
                modifier = Modifier
                    .padding(1.69492.dp)
                    .width(312.dp)
                    .height(60.dp),
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ColorScheme.BrandPrimary
                ),
                onClick = {  }
            ) {
                Text(
                    "Sign Up",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 27.sp,
                        letterSpacing = 0.9.sp
                    )
                )
            }
            Spacer(Modifier.height(88.dp))
        }
    }
}

@Composable
fun Register() {
}
