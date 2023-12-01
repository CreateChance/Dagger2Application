package com.bytedance.ttgame.dagger2application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bytedance.ttgame.dagger2application.dagger.DaggerActivityComponent
import com.bytedance.ttgame.dagger2application.models.ActivityImmutableData1
import com.bytedance.ttgame.dagger2application.models.ActivityImmutableData2
import com.bytedance.ttgame.dagger2application.models.ActivityMutableData1
import com.bytedance.ttgame.dagger2application.models.ActivityMutableData2
import com.bytedance.ttgame.dagger2application.models.GlobalData1
import com.bytedance.ttgame.dagger2application.models.GlobalData2
import com.bytedance.ttgame.dagger2application.ui.theme.Dagger2ApplicationTheme
import javax.inject.Inject

class SecondActivity : ComponentActivity() {

    @Inject
    lateinit var globalData11: GlobalData1

    @Inject
    lateinit var globalData12: GlobalData1

    @Inject
    lateinit var globalData21: GlobalData2

    @Inject
    lateinit var globalData22: GlobalData2

    @Inject
    lateinit var immutableData11: ActivityImmutableData1

    @Inject
    lateinit var immutableData12: ActivityImmutableData1

    @Inject
    lateinit var immutableData21: ActivityImmutableData2

    @Inject
    lateinit var immutableData22: ActivityImmutableData2

    @Inject
    lateinit var mutableData11: ActivityMutableData1

    @Inject
    lateinit var mutableData12: ActivityMutableData1

    @Inject
    lateinit var mutableData21: ActivityMutableData2

    @Inject
    lateinit var mutableData22: ActivityMutableData2

    @Inject
    lateinit var demoApplication: DemoApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // inject all entry.
        DaggerActivityComponent.builder()
            .applicationComponent(DemoApplication.applicationComponent).build()
            .activitySubcomponentFactory().create().inject(this)

        setContent {
            Dagger2ApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingSecond(
                        globalData11.toString() + "\n" +
                                globalData12.toString() + "\n" +
                                globalData21.toString() + "\n" +
                                globalData22.toString() + "\n" +
                                immutableData11.toString() + "\n" +
                                immutableData12.toString() + "\n" +
                                immutableData21.toString() + "\n" +
                                immutableData22.toString() + "\n" +
                                mutableData11.toString() + "\n" +
                                mutableData12.toString() + "\n" +
                                mutableData21.toString() + "\n" +
                                mutableData22.toString() + "\n" +
                                demoApplication.toString()
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingSecond(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "SecondActivity $name",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingSecondPreview() {
    Dagger2ApplicationTheme {
        GreetingSecond("Android")
    }
}