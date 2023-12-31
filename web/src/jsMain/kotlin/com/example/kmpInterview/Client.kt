package com.example.kmpInterview

import com.example.kmpInterview.api.RocketReserverApi
import com.example.kmpInterview.di.commonModule
import com.example.kmpInterview.graphql.rocketreserver.LaunchListQuery
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Table
import org.jetbrains.compose.web.dom.Td
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Th
import org.jetbrains.compose.web.dom.Tr
import org.jetbrains.compose.web.renderComposable
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        modules(commonModule)
    }

    val page = MainPage()
    page.writeAllLaunches()
}

class MainPage : KoinComponent {
    private val scope = CoroutineScope(Dispatchers.Unconfined)
    private val api: RocketReserverApi by inject()

    fun writeAllLaunches() {
        scope.launch {
            api.getLaunches().collect {launches ->
                if (launches != null) {
                    displayLaunches(launches)
                }
            }
        }
    }

    private fun displayLaunches(launches: List<LaunchListQuery.Launch?>) {
        renderComposable(rootElementId = "target") {
            Style(AppStylesheet)

            Table {
                Tr {
                    Th { Text("ID") }
                    Th { Text("Site") }
                    Th { Text("Mission Name") }
                }
                for (launch in launches) {
                    if (launch != null){
                        Tr {
                            Td { Text(launch.id) }
                            Td { Text("${launch.site}") }
                            Td {
                                Img(
                                    src = launch.mission?.missionPatch ?: "",
                                    attrs = { classes(AppStylesheet.imgStyle) }
                                )
                                Text("${launch.mission?.name}")
                            }
                        }
                    }
                }
            }
        }
    }
}
