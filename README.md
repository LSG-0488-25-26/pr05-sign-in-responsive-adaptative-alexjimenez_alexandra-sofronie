# 🏋️ FitLife Gym - Sistema de Registro y Login

Aplicación de registro y autenticación desarrollada en **Kotlin** con **Jetpack Compose** siguiendo el patrón de arquitectura **MVVM**. Diseño **responsive** y **adaptativo** para diferentes tamaños de pantalla.

## 📱 Descripción

FitLife Gym es una aplicación móvil que permite a los usuarios registrarse e iniciar sesión en un gimnasio ficticio. La app se adapta automáticamente a tres tamaños de pantalla (Compact, Medium, Expanded) y es completamente responsive en orientación horizontal y vertical.

## ✨ Características

- 🎯 **Diseño Adaptativo**: Tres layouts diferentes según el tamaño de pantalla (Compact, Medium, Expanded)
- 📱 **Diseño Responsive**: Se ajusta automáticamente a orientación horizontal y vertical
- ✅ **Validación Completa**: Validación en tiempo real de todos los campos del formulario
- 🔐 **Sistema de Autenticación**: Login y registro de usuarios con almacenamiento en memoria
- 🎨 **Interfaz Moderna**: Desarrollada con Jetpack Compose y Material Design 3
- 🔒 **Seguridad**: Visualización oculta de contraseñas con opción de mostrar/ocultar
- 📋 **Términos y Condiciones**: Checkbox de aceptación obligatoria

## 🏗️ Arquitectura

El proyecto sigue el patrón **MVVM (Model-View-ViewModel)**:

```
├── model/
│   └── User.kt                  # Data class del usuario
├── view/
│   ├── LoginScreen.kt           # Pantalla de inicio de sesión
│   ├── CompactScreen.kt         # Registro (pantalla compacta)
│   ├── MediumScreen.kt          # Registro (pantalla mediana)
│   ├── ExpandedScreen.kt        # Registro (pantalla expandida)
│   └── ConfirmationScreen.kt    # Confirmación de registro/login
├── viewmodel/
│   └── MainViewModel.kt         # Lógica de negocio y validaciones
├── navigation/
│   └── Routes.kt                # Sistema de navegación
├── ui/theme/                    # Tema personalizado
│   ├── Color.kt
│   ├── Theme.kt
│   └── Type.kt
└── MainActivity.kt              # Actividad principal
```

## 🚀 Tecnologías Utilizadas

- **Lenguaje**: Kotlin
- **UI Framework**: Jetpack Compose
- **Arquitectura**: MVVM
- **Gestión de estado**: LiveData
- **Navegación**: Navigation Compose
- **Material Design 3**: Material3 Components
- **Diseño Adaptativo**: BoxWithConstraints para detección de tamaño de pantalla

## 📋 Funcionalidades Técnicas

### Campos del Formulario de Registro
1. **Nom complet** (mínimo 3 caracteres)
2. **Data de naixement** (formato DD/MM/AAAA)
3. **Email** (validación con patrón de email)
4. **Telèfon** (9 dígitos, solo números)
5. **Nom d'usuari** (mínimo 4 caracteres)
6. **Contrasenya** (mínimo 6 caracteres)
7. **Confirmar contrasenya** (debe coincidir con la contraseña)
8. **Termes i condicions** (checkbox obligatorio)

### MainViewModel - Funcionalidades
- **Gestión de estado**: LiveData para todos los campos del formulario
- **Validaciones individuales**:
  - `validateFullName()`: Valida nombre completo
  - `validateBirthDate()`: Valida formato de fecha
  - `validateEmail()`: Valida formato de email con Patterns
  - `validatePhone()`: Valida 9 dígitos numéricos
  - `validateUsername()`: Valida longitud mínima
  - `validatePassword()`: Valida longitud mínima de contraseña
  - `validateConfirmPassword()`: Verifica coincidencia de contraseñas
  - `validateTerms()`: Verifica aceptación de términos
- **Funciones principales**:
  - `validateAll()`: Valida todos los campos
  - `registerUser()`: Registra nuevo usuario (evita duplicados)
  - `login()`: Autentica usuario existente
  - `resetForm()`: Limpia todos los campos
  - `clearAllErrors()`: Limpia mensajes de error

### Diseño Adaptativo
- **Compact** (< 600dp): Layout vertical compacto, banner reducido
- **Medium** (600dp - 839dp): Layout más espaciado, mejor distribución
- **Expanded** (≥ 840dp): Layout en dos columnas, máximo espacio

### Navegación
- Sistema de rutas con parámetros
- Flujo de navegación:
  - `Login` → `Register` → `Confirmation` → `Login`
  - Paso de parámetro `username` a la pantalla de confirmación

## 🎮 Cómo Usar

1. **Pantalla de Login**: 
   - Inicia sesión con usuario/email y contraseña
   - O navega a la pantalla de registro

2. **Pantalla de Registro**:
   - Rellena todos los campos del formulario
   - La app muestra errores de validación en tiempo real
   - Acepta los términos y condiciones
   - Presiona "Registrar-se"

3. **Pantalla de Confirmación**:
   - Visualiza el mensaje de confirmación con tu nombre de usuario
   - Vuelve al login para iniciar sesión

4. **Login con cuenta creada**:
   - Introduce tus credenciales
   - Accede a la pantalla de bienvenida

## 🛠️ Instalación

1. Clona el repositorio:
```bash
git clone https://github.com/tu-usuario/pr05-sign-in-responsive-adaptative-alexjimenez-alexandra-sofronie.git
```

2. Abre el proyecto en **Android Studio**

3. Navega a la carpeta: `PR05-Disseny responsive i adaptative`

4. Sincroniza las dependencias de Gradle

5. Ejecuta la aplicación en un emulador o dispositivo físico

## 📦 Requisitos

- Android Studio Hedgehog o superior
- Kotlin 1.9+
- Android SDK 24+ (Android 7.0)
- Gradle 8.0+
- Jetpack Compose 1.5+


## Capturas de Pantalla
### Login Screen

### Confirmation Screen

### Compact Screen

### Medium Screen

### Expanded Screen


## 🔄 Flujo de la Aplicación

```
┌─────────────┐
│ LoginScreen │
└──────┬──────┘
       │
       ├──────────────┐
       │              │
       ▼              ▼
┌──────────┐   ┌────────────────────┐
│  Login   │   │  Register Screen   │
│ Exitoso  │   │ (Compact/Medium/   │
└────┬─────┘   │    Expanded)       │
     │         └─────────┬──────────┘
     │                   │
     │         ┌─────────▼──────────┐
     └────────►│ ConfirmationScreen │
               └─────────┬──────────┘
                         │
                         ▼
                   ┌───────────┐
                   │   Login   │
                   └───────────┘
```

## 💡 Características del Código

- ✅ Código limpio y comentado en catalán/español
- ✅ Uso de bucles `for` simples (sin operadores avanzados)
- ✅ Separación clara de responsabilidades (MVVM)
- ✅ LiveData para gestión de estado reactivo
- ✅ Composables reutilizables

## 👨‍💻 Autores

**Alex Jiménez**  
**Alexandra Sofronie**

## 📄 Licencia

Este proyecto es parte de un ejercicio académico para el módulo **M07 - Android Studio** de La Salle.

---

⭐ **¡Bienvenido a FitLife Gym!** ⭐
