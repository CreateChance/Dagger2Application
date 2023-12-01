package com.bytedance.ttgame.dagger2application

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
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
import com.bytedance.ttgame.mylibrary_api.ILibraryApi
import javax.inject.Inject

class MainActivity : ComponentActivity() {

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

    @Inject
    lateinit var libraryApi: ILibraryApi

    @Inject
    lateinit var libraryApi2: ILibraryApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // inject all entry.
        DaggerActivityComponent.builder()
            .applicationComponent(DemoApplication.applicationComponent).build()
            .activitySubcomponentFactory().create().inject(this)

        Log.d("GAOCHAO", "libraryApi1: $libraryApi, $libraryApi2")
        // 调用自模块接口实现
        libraryApi.invoke()
        libraryApi2.invoke()

        setContent {
            Dagger2ApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingMain(
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
                    ) {
                        startActivity(Intent(this, SecondActivity::class.java))
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingMain(name: String, modifier: Modifier = Modifier, click: () -> Unit) {
    Column {
        Text(
            text = "MainActivity $name",
            modifier = modifier
        )
        Button(onClick = click) {
            Text(text = "Jump")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingMainPreview() {
    Dagger2ApplicationTheme {
        GreetingMain("Android") {
            // do nothing for preview.
        }
    }
}