package kr.ac.kumoh.ce.s20190467.s23w1102counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.ce.s20190467.s23w1102counter.ui.theme.S23W1102CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //MyApp(content = { Greeting("test") })
            MyApp {
                Column{
                    Clicker()
                    Counter()
                    Counter()
                }

            }

        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    S23W1102CounterTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Clicker() {
    //var txtString by remember { mutableStateOf("눌러주세요") }
    val (txtString, setTxtString) = rememberSaveable { mutableStateOf("눌러주세요") }

    Column(modifier = Modifier
        //.fillMaxSize()
        .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = txtString,
            fontSize = 70.sp,
        )
        Button(modifier = Modifier
            .fillMaxWidth(),
            onClick = {
                setTxtString("눌렸습니다")
            }) {
            // Text(text = "눌러봐")
            Text("눌러봐")
        }
    }
}

@Composable
fun Counter() {
    //var count = 0;
    val (count, setCount) = remember { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$count",
            fontSize = 70.sp,
        )
        Row {
            Button(modifier = Modifier
                .weight(1f),
                onClick = { setCount( count + 1) }) {
                Text(text = "증가")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(modifier = Modifier.weight(1f),
                onClick = { if (count > 0) setCount( count - 1) }) {
                Text(text = "감소")
            }
        }
    }
}