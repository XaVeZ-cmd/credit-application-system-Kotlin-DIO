package me.dio.credit.application.system.service

import me.dio.credit.application.system.entity.Costumer

interface ICostumerService {
    fun save(costumer: Costumer): Costumer

    fun findById(id: Long): Costumer

    fun delete(id: Long)
}