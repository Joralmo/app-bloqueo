plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "net.noemec.lockdeviceapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "net.noemec.lockdeviceapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    signingConfigs {
        create("release") {
            val filePath = System.getenv("ANDROID_KEYSTORE_FILE")
            val alias    = System.getenv("ANDROID_KEYSTORE_ALIAS")
            val pass     = System.getenv("ANDROID_KEYSTORE_PASSWORD")

            if (filePath.isNullOrBlank() || alias.isNullOrBlank() || pass.isNullOrBlank()) {
                logger.warn("⚠️ Falta ANDROID_KEYSTORE_FILE/ALIAS/PASSWORD en variables de entorno. bundleRelease fallará.")
            } else {
                storeFile = file(filePath)
                storePassword = pass
                keyAlias = alias
                keyPassword = pass
            }
        }
    }

    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = true
            isShrinkResources = true
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
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1") // Esto habilita AppCompatActivity
    implementation("com.google.android.material:material:1.11.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
