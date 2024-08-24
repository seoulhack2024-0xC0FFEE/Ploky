package net.projecttl.ploky

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import net.projecttl.ploky.ui.BottomBar
import net.projecttl.ploky.ui.TopCam
import net.projecttl.ploky.ui.theme.PlokyTheme

class CameraActivity : ComponentActivity() {
    private val cameraPermissionRequest =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                cameraView()
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, ViewActivity::class.java)
                startActivity(intent)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        when (PackageManager.PERMISSION_GRANTED) {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) -> {
                cameraView()
            }
            else -> {
                cameraPermissionRequest.launch(Manifest.permission.CAMERA)
            }
        }
    }

    private fun cameraView() {
        setContent {
            PlokyTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CamView()
                }
            }
        }
    }
}

@Composable
fun CamView() {
    val took = remember { mutableStateOf(false) }
    val flash = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopCam()
        },
        bottomBar = {
            BottomBar {
                took.value = true
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
    }
    if (took.value) {
        flash.value = false

        return
    }
}
