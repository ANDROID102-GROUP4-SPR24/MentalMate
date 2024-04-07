plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.mentalmate_android__app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mentalmate_android__app"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {
    // Retrofit for network operations
   // implementation(com.squareup.retrofit2:retrofit:2.9.0)
   // implementation(com.squareup.retrofit2:converter-gson:2.9.0)

    // Kotlin Coroutines for background operations
   // implementation(org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9)

    // Coroutines support for Retrofit
   // implementation(com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2)



    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}