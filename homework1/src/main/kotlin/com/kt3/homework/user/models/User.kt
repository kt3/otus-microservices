/**
* User Service
* This is simple client API 
*
* The version of the OpenAPI document: 1.0.0
* Contact: kpote3@gmail.com
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package com.kt3.homework.user.models

/**
 * 
 * @param id 
 * @param username 
 * @param firstName 
 * @param lastName 
 * @param email 
 * @param phone 
 */
@kotlinx.serialization.Serializable
data class User(
    val id: Long? = null,
    val username: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val email: String? = null,
    val phone: String? = null
) 

