package ru.netology.notesapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.netology.notesapp.navigation.NavRoute
import ru.netology.notesapp.ui.theme.NotesAppTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(NavRoute.Add.route)
                }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add Icon",
                    tint = Color.White )
            }
        }
    ) {
        Column() {
            NoteItem(title = "Note 1", subTitle = "SubTitle for Note 1", navController = navController)
            NoteItem(title = "Note 2", subTitle = "SubTitle for Note 2", navController = navController)
            NoteItem(title = "Note 3", subTitle = "SubTitle for Note 3", navController = navController)
            NoteItem(title = "Note 4", subTitle = "SubTitle for Note 4", navController = navController)
        }
    }
}

@Composable
fun NoteItem(title: String, subTitle: String, navController: NavHostController){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .clickable {
                navController.navigate(NavRoute.Note.route)
            },
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = subTitle)
        }

    }
}

@Preview(showBackground = true)
@Composable

fun prevMainScreen(){
    NotesAppTheme {
        MainScreen(navController = rememberNavController())
    }
}