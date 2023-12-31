package com.example.kmpInterview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.kmpInterview.graphql.rocketreserver.LaunchListQuery
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val vm: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val launches by vm.launches.collectAsState()

            LaunchedEffect(Unit) {
                vm.getLaunches()
            }
            MaterialTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                ) {
                    LazyColumn {
                        when(launches){
                            is List<LaunchListQuery.Launch?> -> {
                                items(launches!!) { launch ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(8.dp)
                                    ) {
                                        Image(
                                            painter = rememberAsyncImagePainter(
                                                model = launch?.mission?.missionPatch
                                            ),
                                            contentDescription = "Mission Patch",
                                            modifier = Modifier.size(64.dp)
                                        )
                                        Column {
                                            Text("ID: ${launch?.id}")
                                            Text("Site: ${launch?.site}")
                                            Text("Mission Name: ${launch?.mission?.name}")
                                        }
                                    }
                                }
                            }
                            else -> {
                            }
                        }
                    }
                }
            }
        }
    }
}
