package com.example.trial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Button
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material.Divider
import androidx.compose.ui.Alignment
import com.example.trial.ui.theme.TrialTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Trial {
                Content()
                //ComposeNavigation()
                 }
            }
        }
    }
@Composable
fun Trial(content: @Composable () -> Unit){
    TrialTheme{
        Surface(color = Color.Black) {
            content()
        }
    }
}
//for navigating (start)
//open class Trial(val route : String) {
//    object content : Trial("content")
//    object screen2 : Trial("screen2")
//}
//@Composable
//fun ComposeNavigation() {
//
//    val navController = rememberNavController()
//    androidx.navigation.compose.NavHost(
//        navController = navController,
//        startDestination = Trial.content.route
//    ) {
//        composable(route = Trial.content.route) {
//            content(navController = navController)
//        }
//        composable(route = Trial.screen2.route){
//            screen2(navController = navController)
//        }
//    }
//}
//
//@Composable
//fun content(navController:NavController) {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.Start
//    ) {
//        Text(
//            text = "content",
//            color = Color.Cyan,
//            modifier = Modifier
//                .padding(30.dp)
//                .clickable(onClick = {
//                    navController.navigate("screen2")
//                    Color.White
//                })
//        )
//    }
//}
//@Composable
//fun screen2(navController:NavController) {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.Start
//    ) {
//        Text(
//            text = "screen 2",
//            color = Color.Cyan,
//            modifier = Modifier
//                .padding(30.dp)
//                .clickable(onClick = {
//                    navController.navigate("content")
//                    Color.White
//                })
//        )
//    }
//}
 //fr navigating (end)

@Composable
fun Content(names: List<String> = List(100) {"Compose Level $it"}) {
    val counterState = remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxHeight() .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally){
        NameList(names,Modifier.weight(1f))
        Counter(
            count = counterState.value,
            updateCount ={ newCount ->
                counterState.value = newCount
            }
        )
        }
    }


@Composable
fun NameList(names: List<String>, modifier: Modifier=Modifier){
    LazyColumn(modifier = modifier) {
        items(items = names) { name ->
            Greeting(name =name)
            Divider(color = Color.Yellow,thickness = 2.dp)
        }
    }
}
@Composable
fun Greeting(name: String){
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "$name", modifier = Modifier.fillMaxWidth().padding(25.dp), color = Color.White)
    }
}
@Composable
fun Counter(count: Int,updateCount: (Int)->Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Spacer(modifier=Modifier.fillMaxWidth())
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { updateCount(count + 1) },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (count > 5) Color.Green else Color.Yellow
            )
        ) {
            Text("Click Record : $count  ")
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    Trial{
        Content()
        //ComposeNavigation()
    }
}