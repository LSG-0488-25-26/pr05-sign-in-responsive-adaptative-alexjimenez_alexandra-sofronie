package com.example.disseny_responsive_i_adaptative.model

/**
 * Model de dades per representar un usuari del gimnàs
 * Data class amb totes les propietats necessàries per al registre
 */
data class User(
    val fullName: String = "",
    val birthDate: String = "",
    val email: String = "",
    val phone: String = "",
    val username: String = "",
    val password: String = ""
) {

    /**
     * Valida si l'usuari té tots els campsomplerts correctament
     * @return true si tots els camps tenen valor, false si algun està buit
     */
    fun isValid(): Boolean {
        return fullName.isNotEmpty() &&
                birthDate.isNotEmpty() &&
                email.isNotEmpty() &&
                phone.isNotEmpty() &&
                username.isNotEmpty() &&
                password.isNotEmpty()
    }

    fun credentialsMatch(inputUsernameOrEmail: String, inputPassword: String): Boolean {

        var usuarioCorrecto = false
        var contraseñaCorrecta = false

        if (username == inputUsernameOrEmail) {
            usuarioCorrecto = true
        } else if (email == inputUsernameOrEmail) {
            usuarioCorrecto = true
        } else {
            usuarioCorrecto = false
        }

        if (password == inputPassword) {
            contraseñaCorrecta = true
        } else {
            contraseñaCorrecta = false
        }

        return usuarioCorrecto && contraseñaCorrecta
    }
}