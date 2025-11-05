package com.sharito.demo.fruteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sharito.demo.fruteria.entity.FrutaEntity;

@Repository
public interface FrutaRepository extends JpaRepository<FrutaEntity, Integer> {

}
