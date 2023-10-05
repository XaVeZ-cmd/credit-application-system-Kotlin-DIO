package me.dio.credit.application.system.service

import me.dio.credit.application.system.entity.Credit
import java.util.*

interface CreditService {
    fun save(credit: Credit): Credit

    fun findAllByCostumerId(costumerId: Long): List<Credit>

    fun findByCreditCode(constumerId: Long, creditCode: UUID): Credit
}