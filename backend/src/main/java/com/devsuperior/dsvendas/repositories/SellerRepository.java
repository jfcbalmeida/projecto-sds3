package com.devsuperior.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository <Seller, Long> {
/* Conjunto de operações com a DB já activos devido ao extends */
	
}
