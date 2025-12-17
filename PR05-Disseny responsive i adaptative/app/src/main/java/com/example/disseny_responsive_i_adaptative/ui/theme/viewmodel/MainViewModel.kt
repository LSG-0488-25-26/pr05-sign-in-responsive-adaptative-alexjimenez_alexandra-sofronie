package com.example.disseny_responsive_i_adaptative.ui.theme.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

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
}