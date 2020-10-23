object Dependencies {
    object Version {

        const val kotlin = "1.4.10"
        const val ktx = "1.3.2"
        const val androidX = "1.1.0"
        const val constraintLayout = "2.0.1"

        const val junit = "4.12"


    }
    // kotlin
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"
    val ktx = "androidx.core:core-ktx:${Version.ktx}"

    // androidx
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    // test
    val junit = "junit:junit:${Version.junit}"
}
