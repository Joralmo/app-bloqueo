plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "net.noemec.lockdeviceapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "net.noemec.lockdeviceapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    // 🔥 No vamos a usar Compose, así que lo quitamos por ahora:
    buildFeatures {
        // Si lo necesitas más adelante, lo puedes volver a activar
        // compose = true
    }

    // composeOptions se puede eliminar si no vas a usar Compose
}

dependencies {
    // 👇 Aquí vienen tus dependencias principales
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1") // Esto habilita AppCompatActivity
    implementation("com.google.android.material:material:1.11.0")

    // Si no usas Compose, puedes borrar estas:
    // implementation("androidx.activity:activity-compose:1.8.0")
    // implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    // implementation("androidx.compose.ui:ui")
    // implementation("androidx.compose.ui:ui-graphics")
    // implementation("androidx.compose.ui:ui-tooling-preview")
    // implementation("androidx.compose.material3:material3")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
