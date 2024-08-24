package net.projecttl.ploky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.naver.maps.map.NaverMap
import com.naver.maps.map.NaverMapSdk
import com.naver.maps.map.compose.*
import net.projecttl.ploky.model.Page
import net.projecttl.ploky.ui.BottomBar
import net.projecttl.ploky.ui.TopBar
import net.projecttl.ploky.ui.theme.PlokyTheme

class ViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PlokyTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    View()
                }
            }
        }
    }
}

@Composable
fun View() {
    val page = remember { mutableStateOf(Page.HOME) }

    Scaffold(
        topBar = {
            TopBar(page)
        },
        bottomBar = {
            BottomBar(page)
        },
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        when (page.value) {
            Page.HOME -> {
                Home(Modifier.padding(innerPadding))
            }

            Page.MAP -> {
                Place(Modifier.padding(innerPadding))
            }

            Page.COIN -> {
                Badge(Modifier.padding(innerPadding))
            }

            Page.MORE -> {
                More(Modifier.padding(innerPadding))
            }
        }
    }
}

@Composable
fun Home(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text("asdf")
    }
}

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun Place(modifier: Modifier = Modifier) {
    val ctx = LocalContext.current
    NaverMapSdk.getInstance(ctx).client =
        NaverMapSdk.NaverCloudPlatformClient(stringResource(R.string.naver_client_id))

    NaverMap(
        locationSource = rememberFusedLocationSource(isCompassEnabled = true),
        properties = MapProperties(
            locationTrackingMode = LocationTrackingMode.Face,
        ),
        uiSettings = MapUiSettings(
            isLocationButtonEnabled = true,
        ),
        modifier = modifier
    )
}

@Composable
fun Badge(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text("asdf")
    }
}

@Composable
fun More(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text("asdf")
    }
}
