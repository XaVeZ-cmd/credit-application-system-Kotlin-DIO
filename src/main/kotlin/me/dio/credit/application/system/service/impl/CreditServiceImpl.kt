package me.dio.credit.application.system.service.impl

import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.repository.CreditRepository
import me.dio.credit.application.system.service.ICreditServive
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*

@Service
class CreditServiceImpl(
        private val costumerServiceImpl: CostumerServiceImpl,
        private val repositoty: CreditRepository
): ICreditServive {
    override fun save(credit: Credit): Credit {
            credit.apply {
                costumer = costumerServiceImpl.findById(credit.costumer?.id!!)
            }
        return this.repositoty.save(credit)
    }

    override fun findAllByCostumerId(costumerId: Long): List<Credit> =
            this.repositoty.findAllByCredits(costumerId)

    override fun findByCreditCode(costumerId: Long, creditCode: UUID): Credit {
        var credit: Credit = (this.repositoty.findByCreditCode(creditCode)
                ?: throw RuntimeException("CreditCode $creditCode not found"))
        return if (credit.costumer?.id == costumerId) credit else throw RuntimeException("Contact admin")
    }
}