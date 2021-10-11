// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.viewmodel.MainViewModel


@Composable
@Preview
fun App() {
    val viewModel = MainViewModel(rememberCoroutineScope())
    val latestPlayerInfo by viewModel.latestPlayerInfo.collectAsState()
    LaunchedEffect(true){
        viewModel.beginListenPlayerInfo()
    }

    MaterialTheme {
        Text(latestPlayerInfo.toString())
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        icon = painterResource("lightbulb_black_24dp.svg"),

    ) {
        App()
    }

    Tray(
        icon = painterResource("lightbulb_black_24dp.svg")
    )
}
