package com.example.lsl.ui.theme

// Sign.kt
data class Sign(
    val name: String,
    val description: String,
    val imageResourceId: Int,
    val videoFilePath: String? = null,  // Optional: Add a field for video file path
    val videoFileResourceId: Int? = null // Optional: Add a field for video file resource ID
)

// SignDictionary.kt
object SignDictionary {
    private val allSigns = mutableMapOf<String, Sign>()

    // Function to add a sign to the dictionary
    fun addSign(signName: String, sign: Sign) {
        allSigns[signName] = sign
    }

    // Function to get a sign by name
    fun getSign(signName: String): Sign? {
        return allSigns[signName]
    }

    // Function to get all signs in the dictionary
    fun getAllSigns(): List<Sign> {
        return allSigns.values.toList()
    }
}


// Main.kt
fun main() {
    // Example signs
    val sign1 = Sign(
        name = "Sign 1",
        description = "Description for Sign 1",
        imageResourceId = R.drawable.A.mp4,
        videoFilePath = "file:///android_asset/sign1.mp4" // Update with your actual file path
    )

    val sign2 = Sign(
        name = "Sign 2",
        description = "Description for Sign 2",
        imageResourceId = R.drawable.B.mp4,
        videoFilePath = "file:///android_asset/sign2.mp4" // Update with your actual file path
    )

    // Add signs to the dictionary
    SignDictionary.addSign("Sign1", sign1)
    SignDictionary.addSign("Sign2", sign2)

    // Retrieve and print all signs
    val allSigns = SignDictionary.getAllSigns()
    allSigns.forEach { println(it) }
}

