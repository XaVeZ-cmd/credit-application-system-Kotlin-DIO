package me.dio.credit.application.system.repository

import me.dio.credit.application.system.entity.Costumer
import org.springframework.data.jpa.repository.JpaRepository

interface CostumerRepository: JpaRepository<Costumer, Long>