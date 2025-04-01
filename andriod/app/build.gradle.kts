plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation ("com.airbnb.android:lottie:6.6.2")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.github.denzcoskun:ImageSlideshow:0.1.2")
    implementation("com.google.code.gson:gson:2.12.1")
    implementation("com.android.volley:volley:1.2.1")
    implementation("com.android.volley:volley:1.2.1")
    implementation("com.android.volley:volley:1.2.1")
    implementation("com.github.denzcoskun:ImageSlideshow:0.1.2")
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    implementation("com.github.ibrahimsn98:SmoothBottomBar:1.7.9")
    implementation ("com.github.Foysalofficial:NafisBottomNav:5.0")
        implementation("com.razorpay:checkout:1.6.37")

    dependencies {
        implementation("com.google.android.material:material:1.11.0") // Use latest version
    }
    dependencies {
        implementation("com.google.android.material:material:1.11.0") // Check for latest version
    }
    dependencies {
        implementation("com.google.android.material:material:1.9.0")
    }
    dependencies {
        implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    }
    dependencies {
        implementation("com.google.android.material:material:1.11.0")
        // Or use the latest version:
        // implementation("com.google.android.material:material:<latest-version>")
    }
    dependencies {
        implementation("com.google.android.material:material:1.11.0")
    }












}