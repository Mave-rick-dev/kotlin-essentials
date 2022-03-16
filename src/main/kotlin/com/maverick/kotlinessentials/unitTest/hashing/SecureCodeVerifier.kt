package com.maverick.kotlinessentials.unitTest.hashing

import org.apache.tomcat.util.codec.binary.Base64
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.SecureRandom

class SecureCodeVerifier

fun main() {
    val charPool: List<Char> = ('a'..'z') +
        ('A'..'Z') +
        ('0'..'9') +
        ('-') +
        ('.') +
        ('_') +
        ('~')
    // Java Secure Random
    val codeVerifierLength = (43..128).shuffled().first()
    println("Code Verifier length: $codeVerifierLength")
    val secure: SecureRandom = SecureRandom()
    val secureCodeVerifier = (1..codeVerifierLength)
        .map { secure.nextInt(charPool.size) }
        .map(charPool::get)
        .joinToString("")

    println("Secure Code Verifier: $secureCodeVerifier")

    // SHA256 hashing
    val digest = MessageDigest.getInstance("SHA-256")
    val hashedCodeVerifier: ByteArray = digest.digest(
        secureCodeVerifier.toByteArray(StandardCharsets.UTF_8)
    )

    // Base64URLSafe encoding
    val urlSafeCodeVerifier = Base64.encodeBase64URLSafeString(hashedCodeVerifier)
    println("URL safe encoding: $urlSafeCodeVerifier ${urlSafeCodeVerifier.length}")
}
