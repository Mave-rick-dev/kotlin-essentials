package com.maverick.kotlinessentials.unitTest.hashing

import org.apache.tomcat.util.codec.binary.Base64
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

class HMACcalculator

fun main() {
    try {
        val secret = "secret"
        val message = "Message"

        val sha256_HMAC = Mac.getInstance("HmacSHA256")
        val secret_key = SecretKeySpec(secret.toByteArray(), "HmacSHA256")
        sha256_HMAC.init(secret_key)

        // HOw to acquire HMAC from response header (webClient)

        // HMAC to Base64 (at host side)
        val hostHSM = Base64.encodeBase64String(sha256_HMAC.doFinal(message.toByteArray()))
        println("HSM in resp header: $hostHSM")

        // Base64 to HMAC (at our side)
        // issued certs in xml format
        val issuedCert = "Message".toByteArray()
        val clientHSM = Base64.encodeBase64String(sha256_HMAC.doFinal(issuedCert))
        println("HSM calculated on our side: $clientHSM")

        if (hostHSM == clientHSM) {
            println("HostHSM == clientHSM")
        } else {
            println("HostHSM != clientHSM")
        }
    } catch (e: Exception) {
        println(e)
    }
}
