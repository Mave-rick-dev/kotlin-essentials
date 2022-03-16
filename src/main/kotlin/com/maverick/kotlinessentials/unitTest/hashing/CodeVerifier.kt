package com.maverick.kotlinessentials.unitTest.hashing

import org.apache.tomcat.util.codec.binary.Base64
import java.nio.charset.StandardCharsets
import java.security.MessageDigest

class CodeVerifier

fun main() {
    val charPool: List<Char> = ('a'..'z') +
        ('A'..'Z') +
        ('0'..'9') +
        ('-') +
        ('.') +
        ('_') +
        ('~')

    // code_verifier generation
    val codeVerifierLength = (43..128).shuffled().first()
    val codeVerifier = (1..codeVerifierLength)
        .map { kotlin.random.Random.nextInt(0, charPool.size) }
        .map(charPool::get)
        .joinToString("")

    println("From java.util.Random() Random String: $codeVerifier")
    println("From java.util.Random() length of random String: ${codeVerifier.count()}")

    // SHA256 hashing
    val digest = MessageDigest.getInstance("SHA-256")
    val hashedCodeVerifier: ByteArray = digest.digest(
        codeVerifier.toByteArray(StandardCharsets.UTF_8)
    )

    // Base64 encoding without padding (java.util.Base64)
    /*val encodedStringJava = java.util.Base64.getEncoder().encodeToString(hashedCodeVerifier)
    println("java.util.Base64 $encodedStringJava")
 // Base64URLSafe encoding without padding (java.util.Base64)
    val encodedStringJava: String = java.util.Base64.getUrlEncoder().encodeToString(hashedCodeVerifier)
    println(" Base64URLSafe encoding without padding (java.util.Base64) $encodedStringJava")
*/

    // Base64URLSafe encoding
    val urlSafeCodeVerifier = Base64.encodeBase64URLSafeString(hashedCodeVerifier)
    println("URL safe encoding: $urlSafeCodeVerifier ${urlSafeCodeVerifier.length}")

  /*  // Base64 encoding
    var encodedString = Base64.encodeBase64String(hashedCodeVerifier)
    println("Before padding: $encodedString")

    encodedString = encodedString.trim('=')
    encodedString = encodedString.replace('+', '-')
    encodedString = encodedString.replace('/', '_')

    println("After Base64 encoding (without padding): $encodedString ${encodedString.length}")
    if(urlSafeCodeVerifier!!.contentEquals(encodedString)){
        println("encodeBase64URLSafeString is equal to encodeBase64String")
    }*/
}
