package com.example.disseny_responsive_i_adaptative.ui.theme.navigation

sealed class Routes(val route: String) {
    object Register : Routes("register")
    object Confirmation : Routes("confirmation/{username}")

    fun createConfirmationRoute(username: String): String {
        return "confirmation/$username"
    }
}