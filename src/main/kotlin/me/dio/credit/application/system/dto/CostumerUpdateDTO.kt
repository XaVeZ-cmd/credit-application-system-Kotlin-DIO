package me.dio.credit.application.system.dto

import me.dio.credit.application.system.entity.Costumer
import java.math.BigDecimal

data class CostumerUpdateDTO(
        val firstName: String,
        val lastName: String,
        val income: BigDecimal,
        val zipCode: String,
        val street: String
){
    fun toEntity(costumer: Costumer): Costumer {
        costumer.firstName = this.firstName
        costumer.lastName = this.lastName
        costumer.income = this.income
        costumer.address.zipCode = this.zipCode
        costumer.address.street = this.street
        return costumer
    }
}
