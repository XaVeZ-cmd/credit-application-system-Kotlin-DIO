package me.dio.credit.application.system.controller

import me.dio.credit.application.system.dto.CustomerDTO
import me.dio.credit.application.system.dto.CustomerUpdateDTO
import me.dio.credit.application.system.dto.CustomerViewDTO
import me.dio.credit.application.system.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController(
        private val service: CustomerService
) {

    @PostMapping
    fun saveCostumer(@RequestBody dto: CustomerDTO): ResponseEntity<String> {
        val savedCostumer = this.service.save(dto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Costumer ${savedCostumer.email} saved!")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerViewDTO> {
        val costumer = this.service.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerViewDTO(costumer))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) {
        this.service.delete(id)
    }

    @PatchMapping
    fun updateCostumer(@RequestParam(value = "customerId") id: Long,
                       @RequestBody customerUpdateDTO: CustomerUpdateDTO): ResponseEntity<CustomerViewDTO> {
        val customer = this.service.findById(id)
        val customerToUpdate = customerUpdateDTO.toEntity(customer)
        val customerUpdated = this.service.save(customerToUpdate)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerViewDTO(customerUpdated))
    }
}