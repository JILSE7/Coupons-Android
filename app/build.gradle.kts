plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "org.bedu.architecturerecommend_cuppons"
    compileSdk = 33

    defaultConfig {
        applicationId = "org.bedu.architecturerecommend_cuppons"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        compileSdkPreview = "UpsideDownCake"
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
    buildFeatures {
        // viewBinding = true
        dataBinding = true
    }
}


dependencies {
    val room_version = "2.6.0"
    val lifecycle_version = "2.6.1"
    val activity_version = "1.6.1"

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    /*ROOM*/
    kapt("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version")

    /*View Model*/
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")

    /* GSON */
    implementation("com.google.code.gson:gson:2.8.6")

    /* COUROUTINES */
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")
    /*LIVE DATA*/
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")

    implementation("androidx.activity:activity-ktx:$activity_version")
}