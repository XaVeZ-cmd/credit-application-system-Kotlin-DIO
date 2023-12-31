package me.dio.credit.application.system.dto

import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal

data class CustomerViewDTO(
        val firstName: String,
        val lastName: String,
        val cpf: String,
        val income: BigDecimal,
        val password: String,
        val email: String,
        val zipCode: String,
        val street: String
){
    constructor(customer: Customer): this(
            firstName = customer.firstName,
            lastName = customer.lastName,
            cpf = customer.cpf,
            income = customer.income,
            password = customer.password,
            email = customer.email,
            zipCode = customer.address.zipCode,
            street = customer.address.street
    )
}
