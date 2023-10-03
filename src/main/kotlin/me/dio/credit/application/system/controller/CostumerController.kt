package me.dio.credit.application.system.controller

import me.dio.credit.application.system.dto.CostumerDTO
import me.dio.credit.application.system.dto.CostumerUpdateDTO
import me.dio.credit.application.system.dto.CostumerViewDTO
import me.dio.credit.application.system.service.ICostumerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/costumers")
class CostumerController (
        private val service: ICostumerService
){

    @PostMapping
    fun saveCostumer(@RequestBody dto: CostumerDTO): String{
        val savedCostumer = this.service.save(dto.toEntity())
        return "Costumer ${savedCostumer.email} saved!"
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : CostumerViewDTO {
        val costumer = this.service.findById(id)
        return CostumerViewDTO(costumer)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) {
       this.service.delete(id)
    }

    @PatchMapping
    fun updateCostumer(@RequestParam(value = "costumerId") id: Long,
                       @RequestBody costumerUpdateDTO: CostumerUpdateDTO): CostumerViewDTO{
        val costumer = this.service.findById(id)
        val costumerToUpdate = costumerUpdateDTO.toEntity(costumer)
        val costumerUpdated = this.service.save(costumerToUpdate)
        return CostumerViewDTO(costumerUpdated)
    }
}