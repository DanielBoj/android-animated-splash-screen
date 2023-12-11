# Android Animated Splash Screen <img src="https://raw.githubusercontent.com/DanielBoj/DanielBoj/main/pixel-me.png" alt="Logo desarrollador de Daniel Boj" width="60"> 
by [Daniel Boj](https://github.com/DanielBoj)
## Description
This tutorial shows how to create a splash screen in Jetpack Compose. The splash screen is displayed while the app is loading. It is usually displayed for a few seconds.
# Spanish
## Introducción

Una *splash screen* es la pantalla de espera que vemos en nuestro dispositivo mientras se está iniciando una aplicación. Mediante *Jetpack Compose*, podemos controlar fácilmente el contenido a mostrar y la duración de este antes de navegar a la pantalla principal de la app.

## Implementación

Usaremos una vista independiente para representar la *************spalsh screen*************. Durante la carga de la app, mostramos la *splash screen* y luego navegamos directamente a nuestra pantalla principal. Finalmente, usaremos la navegación de *Jetpack Compose* para mostrar nuestra pantalla de inicio y navegar a la pantall principal tras un periodo de espera que estipulemos.

### Creación de la vista de la *splash screen*

Creamos un fichero *composable* para generar la *Splash Screen*. Dentro de este, tendremos una función para diseñar la vista en general que implementará la lógica de la ventana →

```kotlin
@Composable
fun SplashScreen() {
    Splash()
}
```

Además, crearemos la función *Splash* donde implementaremos la vista de nuestra pantalla de espera, así que solo tendrá lógica de UI. Es importante que hayamos creado un recurso *mipmap* con una imagen o logo adaptable a las distintas resoluciones del dispositivo. Además, se incluye un sencillo ejemplo de animación →

```kotlin
@Composable
private fun Splash() {
    val scale = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.5f,
            animationSpec = tween(
                durationMillis = 2000,
                delayMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF202020),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.mipmap.ic_logo_round), contentDescription = "Developer Logo",
                modifier = Modifier
                    .size(200.dp)
                    .padding(20.dp)
		    .scale(scale.value)
            )
            Text(
                "Bienevenid@s a la App de Android",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
```

Por último, implementamos la lógica de navegación en la pantalla de espera →

```kotlin
@Composable
fun SplashScreen(
    navController: NavHostController
) {
    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.navigate("overview_screen") {
            popUpTo("splash_screen") { inclusive = true }
        }
    }

    Splash()
}
```
# English
## Introducción
A *splash screen* is the waiting screen that we see on our device while an application is starting up. With *Jetpack Compose*, we can easily control the content to display and its duration before navigating to the main screen of the app.

## Implementación
We will use an independent view to represent the *splash screen*. During the app loading, we show the *splash screen* and then navigate directly to our *main screen*. Finally, we will use the *Jetpack Compose* navigation to display our *home screen* and navigate to the *main screen* after a stipulated waiting period.

### Creación de la vista de la *splash screen*
We create a *composable* file to generate the *Splash Screen*. Inside this, we will have a function to design the overall view that will implement the window logic →

```kotlin
@Composable
fun SplashScreen() {
    Splash()
}
```

In addition, we will create the *Splash* function where we will implement the view of our waiting screen, so it will only have UI logic. It is important that we have created a *mipmap* resource with an image or logo adaptable to the different resolutions of the device. Additionally, a simple animation example is included →

```kotlin
@Composable
private fun Splash() {
    val scale = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.5f,
            animationSpec = tween(
                durationMillis = 2000,
                delayMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF202020),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.mipmap.ic_logo_round), contentDescription = "Developer Logo",
                modifier = Modifier
                    .size(200.dp)
                    .padding(20.dp)
										.scale(scale.value)
            )
            Text(
                "Bienevenid@s a la App de Android",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
```

Finally, we implement the navigation logic on the waiting screen →

```kotlin
@Composable
fun SplashScreen(
    navController: NavHostController
) {
    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.navigate("overview_screen") {
            popUpTo("splash_screen") { inclusive = true }
        }
    }

    Splash()
}
```
