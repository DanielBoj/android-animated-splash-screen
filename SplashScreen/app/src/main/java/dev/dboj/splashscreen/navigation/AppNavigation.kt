package dev.dboj.splashscreen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.dboj.splashscreen.ui.screen.OverviewScreen
import dev.dboj.splashscreen.ui.screen.SplashScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = AppRoutes.SplashScreen.route,
    ) {
        composable(AppRoutes.SplashScreen.route) { SplashScreen(navController = navController) }
        composable(AppRoutes.OverviewScreen.route) { OverviewScreen() }
    }
}