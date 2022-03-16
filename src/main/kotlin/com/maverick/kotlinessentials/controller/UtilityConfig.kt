/*
package com.maverick.kotlinessentials.controller

import com.rapipay.nyeshared.config.CustomMessageSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class UtilityConfig {

    @Bean
    fun resourceBundleMessageSource(): ResourceBundleMessageSource {
        val resourceBundleMessageSource = ResourceBundleMessageSource()
        resourceBundleMessageSource.setBasename("classpath:messages")
        resourceBundleMessageSource.setDefaultEncoding("UTF-8")
        return resourceBundleMessageSource
    }

    @Bean
    fun customMessageSource(): CustomMessageSource {
        val messageSource: MessageSource = resourceBundleMessageSource()
        return CustomMessageSource(messageSource)
    }
}*/
