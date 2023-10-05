package me.dio.credit.application.system.service.impl

import me.dio.credit.application.system.entity.Customer
import me.dio.credit.application.system.repository.CustomerRepository
import me.dio.credit.application.system.service.CustomerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CustomerServiceImpl(
        private val repository: CustomerRepository
) : CustomerService {

    override fun save(customer: Customer): Customer =
            this.repository.save(customer)

    override fun findById(id: Long): Customer =
            this.repository.findById(id).orElseThrow() {
                throw RuntimeException("Id $id not found")
            }

    override fun delete(id: Long) =
            this.repository.deleteById(id)
}