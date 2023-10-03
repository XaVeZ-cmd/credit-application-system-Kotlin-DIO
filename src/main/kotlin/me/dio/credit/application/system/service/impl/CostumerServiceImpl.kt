package me.dio.credit.application.system.service.impl

import me.dio.credit.application.system.entity.Costumer
import me.dio.credit.application.system.repository.CostumerRepository
import me.dio.credit.application.system.service.ICostumerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CostumerServiceImpl(
        private val repository: CostumerRepository
) : ICostumerService {

    override fun save(costumer: Costumer): Costumer =
            this.repository.save(costumer)

    override fun findById(id: Long): Costumer =
            this.repository.findById(id).orElseThrow() {
                throw RuntimeException("Id $id not found")
            }

    override fun delete(id: Long) =
            this.repository.deleteById(id)
}