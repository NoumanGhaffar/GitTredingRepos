object Dependencies {
    object Version {

        const val kotlin = "1.4.10"
        const val ktx = "1.3.2"
        const val constraintLayout = "2.0.1"
        const val junit = "4.12"
        const val dagger = "2.24"
        const val androidX = "1.1.0"
        const val lifecycle = "2.1.0"

    }

    // kotlin
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"
    val ktx = "androidx.core:core-ktx:${Version.ktx}"

    // androidx
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"

    // dependency injection
    val dagger = "com.google.dagger:dagger:${Version.dagger}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Version.dagger}"
    val daggerAndroid = "com.google.dagger:dagger-android:${Version.dagger}"
    val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Version.dagger}"
    val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Version.dagger}"


    // test
    val junit = "junit:junit:${Version.junit}"

    // lifecycle
    val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    val activityKtx = "androidx.activity:activity-ktx:${Version.androidX}"
}
