plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinKapt)
    alias(libs.plugins.navigationSafeArgs)
}

android {
    namespace = "com.example.cadastroalunos"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.cadastroalunos"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    // Alinhar a compatibilidade do Java e Kotlin com a JVM
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    // Configuração do Room para exportar o esquema
    kapt {
        arguments {
            arg("room.schemaLocation", "$projectDir/schemas") // Exporta o esquema do banco
            arg("room.incremental", "true") // Habilita a compilação incremental do Room
        }
    }
}

dependencies {
    // AndroidX
    implementation(libs.androidxCoreKtx)
    implementation(libs.androidxAppcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)

    // Lifecycle components
    implementation(libs.lifecycleViewmodelKtx)
    implementation(libs.lifecycleLivedataKtx)

    // Room Database
    implementation(libs.roomRuntime)
    kapt(libs.roomCompiler)
    implementation(libs.roomKtx)

    // Navigation Component
    implementation(libs.navigationFragmentKtx)
    implementation(libs.navigationUiKtx)

    // Glide for image loading
    implementation(libs.glide)
    kapt(libs.glideCompiler)


    // Coroutines
    implementation(libs.coroutinesAndroid)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidxJunit)
    androidTestImplementation(libs.espressoCore)
}
