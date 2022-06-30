package makaota.app.jetfundamentalsapp.screens

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import makaota.app.jetfundamentalsapp.R
import makaota.app.jetfundamentalsapp.router.BackButtonHandler
import makaota.app.jetfundamentalsapp.router.JetFundamentalsRouter
import makaota.app.jetfundamentalsapp.router.Screen

@Composable
fun AlertDialogScreen() {

    MyAlertDialog()

    BackButtonHandler {
        JetFundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
fun MyAlertDialog() {
    val shouldShowDialog = remember { mutableStateOf(true) } // 1
    if (shouldShowDialog.value) { // 2
        AlertDialog( // 3
            onDismissRequest = { // 4
                shouldShowDialog.value = false
                JetFundamentalsRouter.navigateTo(Screen.Navigation)
            },
            // 5
            title = { Text(text = stringResource(id =
            R.string.alert_dialog_title)) },
            text = { Text(text = stringResource(id =
            R.string.alert_dialog_text)) },
            confirmButton = { // 6
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor =
                    colorResource(id = R.color.colorPrimary)),
                    onClick = {
                        shouldShowDialog.value = false
                        JetFundamentalsRouter.navigateTo(Screen.Navigation)
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.confirm),
                        color = Color.White
                    )
                }
            }
        )
    }
}