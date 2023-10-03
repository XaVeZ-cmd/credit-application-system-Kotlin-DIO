package me.dio.credit.application.system.dto

import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Costumer
import java.math.BigDecimal

data class CostumerDTO(
        val firstName: String,
        val lastName: String,
        val cpf: String,
        val income: BigDecimal,
        val password: String,
        val email: String,
        val zipCode: String,
        val street: String
) {
    fun toEntity(): Costumer = Costumer(
            firstName = this.firstName,
            lastName = this.lastName,
            cpf = this.cpf,
            income = this.income,
            email = this.email,
            password = this.password,
            address = Address(
                    zipCode = this.zipCode,
                    street = this.street
            )
    )
}
