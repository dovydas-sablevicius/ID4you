plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("io.gitlab.arturbosch.detekt") version "1.23.5"
    id("org.jetbrains.kotlinx.kover") version "0.7.6"
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.project.id4you"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.project.id4you"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.project.id4you.HiltTestRunner"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

koverReport {

    filters {
        excludes {

            classes(
                "*_*Factory.*",
                "*_Factory.*",
                "Hilt_*",
                "*_Hilt*",
                "*_Factory*",
                "NavigationHostKt",
                "*ComposableSingletons*",
                "*Hilt_MainActivity*",
                "AppModule_*",
                "*NavigationHostKt*",
                "*DocumentStatus*"
            )
            annotatedBy(
                "KoverIgnore",
                "androidx.compose.runtime.Composable",
                "androidx.compose.ui.tooling.preview.Preview",
                "dagger.hilt.android.AndroidEntryPoint",
                "dagger.hilt.android.HiltAndroidApp"
            )
            packages(
                "dagger.hilt.internal.aggregatedroot.codegen",
                "hilt_aggregated_deps",
                "com.project.id4you.di",
                "com.project.id4you.presentation.navigation.graphs",
                "com.project.id4you.presentation.screens.documentDetail"
            )
        }
    }

    verify {
        rule {
            isEnabled = true
            bound {
                minValue = 80
            }
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    kapt(libs.hilt.compiler)

    // For instrumentation tests
    androidTestImplementation(libs.hilt.android.testing)
    kaptAndroidTest(libs.hilt.android.compiler)
    testImplementation(libs.jetbrains.kotlinx.coroutines.test)

    // For local unit tests
    testImplementation(libs.hilt.android.testing)
    kaptTest(libs.hilt.compiler)
    testImplementation(libs.jetbrains.kotlinx.coroutines.test)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.robolectric)

    //retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    //QR code
    implementation(libs.core)
    implementation(libs.javase)

    //JWT
    implementation(libs.java.jwt)
}
kapt {
    correctErrorTypes = true
}