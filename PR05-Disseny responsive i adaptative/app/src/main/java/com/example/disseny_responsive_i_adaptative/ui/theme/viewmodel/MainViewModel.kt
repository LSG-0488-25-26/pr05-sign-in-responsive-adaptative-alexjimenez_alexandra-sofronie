package com.example.disseny_responsive_i_adaptative.ui.theme.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.util.Patterns

class MainViewModel: ViewModel() {
    //Estados de los campos del formulario
    private val _fullName = MutableLiveData("")
    val fullName: LiveData<String> = _fullName

    private val _birthDate = MutableLiveData("")
    val birthDate: LiveData<String> = _birthDate

    private val _email = MutableLiveData("")
    val email: LiveData<String> = _email

    private val _phone = MutableLiveData("")
    val phone: LiveData<String> = _phone

    private val _username = MutableLiveData("")
    val username: LiveData<String> = _username

    private val _password = MutableLiveData("")
    val password: LiveData<String> = _password

    private val _confirmPassword = MutableLiveData("")
    val confirmPassword: LiveData<String> = _confirmPassword

    private val _termsAccepted = MutableLiveData(false)
    val termsAccepted: LiveData<Boolean> = _termsAccepted

    // Estados de validación
    private val _fullNameError = MutableLiveData<String>("")
    val fullNameError: LiveData<String> = _fullNameError

    private val _emailError = MutableLiveData<String>("")
    val emailError: LiveData<String> = _emailError

    private val _phoneError = MutableLiveData<String>("")
    val phoneError: LiveData<String> = _phoneError

    private val _usernameError = MutableLiveData<String>("")
    val usernameError: LiveData<String> = _usernameError

    private val _passwordError = MutableLiveData<String>("")
    val passwordError: LiveData<String> = _passwordError

    private val _confirmPasswordError = MutableLiveData<String>("")
    val confirmPasswordError: LiveData<String> = _confirmPasswordError

    private val _birthDateError = MutableLiveData<String>("")
    val birthDateError: LiveData<String> = _birthDateError

    fun onFullNameChange(value: String) {
        _fullName.value = value
    }

    fun onBirthDateChange(value: String) {
        _birthDate.value = value
    }

    fun onEmailChange(value: String) {
        _email.value = value
    }

    fun onPhoneChange(value: String) {
        _phone.value = value
    }

    fun onUsernameChange(value: String) {
        _username.value = value
    }

    fun onPasswordChange(value: String) {
        _password.value = value
    }

    fun onConfirmPasswordChange(value: String) {
        _confirmPassword.value = value
    }

    fun onTermsAcceptedChange(value: Boolean) {
        _termsAccepted.value = value
    }

    private fun validateFullName(): Boolean {
        val name = _fullName.value

        if (name.isNullOrBlank()) {
            _fullNameError.value = "El nom complet és obligatori"
            return false
        }

        if (name.length < 3) {
            _fullNameError.value = "Mínim 3 caràcters"
            return false
        }

        _fullNameError.value = ""
        return true
    }

    private fun validateBirthDate(): Boolean {
        val date = _birthDate.value

        if (date.isNullOrBlank()) {
            _birthDateError.value = "La data de naixement és obligatòria"
            return false
        }

        // Verificar formato básico DD/MM/AAAA
        if (date.length != 10) {
            _birthDateError.value = "Format: DD/MM/AAAA (10 caràcters)"
            return false
        }

        // Verificar que tenga las barras
        if (date[2] != '/' || date[5] != '/') {
            _birthDateError.value = "Format vàlid: DD/MM/AAAA"
            return false
        }

        _birthDateError.value = ""
        return true
    }

    private fun validateEmail(): Boolean {
        val email = _email.value

        if (email.isNullOrBlank()) {
            _emailError.value = "L'email és obligatori"
            return false
        }

        val isValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()

        if (!isValid) {
            _emailError.value = "Email no vàlid"
            return false
        }

        _emailError.value = ""
        return true
    }

    private fun validatePhone(): Boolean {
        val phone = _phone.value

        if (phone.isNullOrBlank()) {
            _phoneError.value = "El telèfon és obligatori"
            return false
        }

        // Verificar que tenga 9 dígitos
        if (phone.length != 9) {
            _phoneError.value = "Ha de tenir 9 números"
            return false
        }

        // Verificar que todos sean números
        var allDigits = true
        for (char in phone) {
            if (!char.isDigit()) {
                allDigits = false
                break
            }
        }

        if (!allDigits) {
            _phoneError.value = "Només es permeten números"
            return false
        }

        _phoneError.value = ""
        return true
    }

    private fun validateUsername(): Boolean {
        val username = _username.value

        if (username.isNullOrBlank()) {
            _usernameError.value = "El nom d'usuari és obligatori"
            return false
        }

        if (username.length < 4) {
            _usernameError.value = "Mínim 4 caràcters"
            return false
        }

        _usernameError.value = ""
        return true
    }

    private fun validatePassword(): Boolean {
        val password = _password.value

        if (password.isNullOrBlank()) {
            _passwordError.value = "La contrasenya és obligatòria"
            return false
        }

        if (password.length < 6) {
            _passwordError.value = "Mínim 6 caràcters"
            return false
        }

        _passwordError.value = ""
        return true
    }

    private fun validateConfirmPassword(): Boolean {
        val confirm = _confirmPassword.value
        val password = _password.value

        if (confirm.isNullOrBlank()) {
            _confirmPasswordError.value = "Confirma la contrasenya"
            return false
        }

        if (confirm != password) {
            _confirmPasswordError.value = "Les contrasenyes no coincideixen"
            return false
        }

        _confirmPasswordError.value = ""
        return true
    }

    private fun validateTerms(): Boolean {
        val accepted = _termsAccepted.value
        return accepted == true
    }

    fun validateAll(): Boolean {
        // Validamos todos los campos
        val isValidFullName = validateFullName()
        val isValidBirthDate = validateBirthDate()
        val isValidEmail = validateEmail()
        val isValidPhone = validatePhone()
        val isValidUsername = validateUsername()
        val isValidPassword = validatePassword()
        val isValidConfirmPassword = validateConfirmPassword()
        val isValidTerms = validateTerms()

        if (isValidFullName && isValidBirthDate && isValidEmail &&
            isValidPhone && isValidUsername && isValidPassword &&
            isValidConfirmPassword && isValidTerms) {
            return true
        } else {
            return false
        }
    }

}