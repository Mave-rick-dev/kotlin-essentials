/*
package com.maverick.kotlinessentials.controller


import com.rapipay.nyeshared.config.CustomMessageSource
import org.springframework.http.ResponseEntity
import com.rapipay.nyeshared.enum.ResponseStatus
import com.rapipay.nyeshared.dto.GlobalApiResponse

open class BaseController(

    //private val customMessageSource: CustomMessageSource
) {
    private val customMessageSource: CustomMessageSource
        get() {
            return customMessageSource
        }
    private val API_SUCCESS_STATUS = ResponseStatus.SUCCESS

    private val API_ERROR_STATUS = ResponseStatus.FAIL

    protected fun successResponse(message: String, data: Any?): ResponseEntity<GlobalApiResponse> = ResponseEntity.ok(
        GlobalApiResponse(API_SUCCESS_STATUS, customMessageSource[message], data)
    )

    protected fun errorResponse(message: String, errors: Any?): ResponseEntity<GlobalApiResponse> =
        ResponseEntity.badRequest().body(
            GlobalApiResponse(API_ERROR_STATUS, message, errors)
        )
}
*/
