package dev.dboj.splashscreen.navigation

sealed class AppRoutes(
    val route: String
) {
    object SplashScreen: AppRoutes("splash_screen")
    object OverviewScreen: AppRoutes("overview_screen")
}