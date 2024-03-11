import com.android.build.api.dsl.Packaging

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.epam.test"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.epam.test"
        minSdk = 26
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

    packaging {
        resources {
            excludes += "META-INF/LICENSE*"
            excludes += "META-INF/INDEX.LIST"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.slf4j)
    androidTestImplementation(libs.logback)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.reportportal.logger) {
        exclude ("org.aspectj", "aspectjweaver") // AspectJ is already included by Android
        exclude ("org.aspectj", "aspectjrt") // AspectJ is already included by Android
    }
    androidTestImplementation(libs.reportportal.agent) {
        exclude ("org.aspectj", "aspectjweaver") // AspectJ is already included by Android
        exclude ("org.aspectj", "aspectjrt") // AspectJ is already included by Android
    }

    androidTestImplementation("de.mannodermaus.junit5:android-test-core:1.3.0")
    androidTestImplementation("de.mannodermaus.junit5:android-test-runner:1.3.0")

    // JUnit5 libraries, 'junit-jupiter-api' is inherited from agent
    androidTestImplementation("org.junit.platform:junit-platform-runner:1.9.3")
    androidTestImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.3")
}