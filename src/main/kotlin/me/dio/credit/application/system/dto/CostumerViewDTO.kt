package me.dio.credit.application.system.dto

import me.dio.credit.application.system.entity.Costumer
import java.math.BigDecimal

data class CostumerViewDTO(
        val firstName: String,
        val lastName: String,
        val cpf: String,
        val income: BigDecimal,
        val password: String,
        val email: String,
        val zipCode: String,
        val street: String
){
    constructor(costumer: Costumer): this(
            firstName = costumer.firstName,
            lastName = costumer.lastName,
            cpf = costumer.cpf,
            income = costumer.income,
            password = costumer.password,
            email = costumer.email,
            zipCode = costumer.address.zipCode,
            street = costumer.address.street
    )
}
