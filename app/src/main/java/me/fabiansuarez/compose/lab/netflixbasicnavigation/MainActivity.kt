package me.fabiansuarez.compose.lab.netflixbasicnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.screen.HomeScreen
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.screen.LoginScreen
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.screen.RegisterScreen
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.screen.RegisterStep2Screen
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.screen.RegisterStep3Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "login",
                modifier = Modifier.fillMaxSize()
            ) {
                composable(route = "login") {
                    LoginScreen(
                        onClickRegister = {
                            navController.navigate("register")
                        },
                        onClickLogin = {
                            navController.navigate("home")
                        }
                    )
                }
                composable(route = "register") {
                    RegisterScreen(
                        onClickBack = {
                            navController.popBackStack()
                        },
                        onNextStep = {
                            navController.navigate("register_step2")
                        },
                        onClickLogin = {
                            navController.navigate("login")
                        }
                    )
                }

                composable(route = "register_step2") {
                    RegisterStep2Screen(
                        onClickBack = {
                            navController.popBackStack()
                        },
                        onNextStep = {
                            navController.navigate("register_step3")
                        }
                    )
                }
                composable(route = "register_step3") {
                    RegisterStep3Screen(
                        onClickBack = {
                            navController.popBackStack()
                        },
                        onFinishRegister = {
                            navController.navigate("home")
                        }
                    )
                }
                composable(route = "home") {
                    HomeScreen()
                }
            }
        }
    }
}