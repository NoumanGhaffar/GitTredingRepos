object Dependencies {
    object Version {

        const val kotlin = "1.4.10"
        const val ktx = "1.3.2"
        const val constraintLayout = "2.0.1"
        const val junit = "4.12"
        const val dagger = "2.24"
        const val androidX = "1.1.0"
        const val lifecycle = "2.1.0"
        const val retrofit = "2.6.1"
        const val okhttp = "4.6.0"
        const val conscrypt = "2.2.1"

    }

    // kotlin
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"
    const val ktx = "androidx.core:core-ktx:${Version.ktx}"

    // androidx
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"

    // dependency injection
    const val dagger = "com.google.dagger:dagger:${Version.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Version.dagger}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Version.dagger}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Version.dagger}"
    const val daggerAndroidProcessor =
        "com.google.dagger:dagger-android-processor:${Version.dagger}"

    // network
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp}"
    const val conscrypt = "org.conscrypt:conscrypt-android:${Version.conscrypt}"

    // test
    const val junit = "junit:junit:${Version.junit}"

    // lifecycle
    const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    const val activityKtx = "androidx.activity:activity-ktx:${Version.androidX}"
}
