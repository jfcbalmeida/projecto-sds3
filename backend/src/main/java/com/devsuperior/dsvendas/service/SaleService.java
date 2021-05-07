package com.devsuperior.dsvendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	// Permite injectar no repositoty uma nova instancia do object SellerRepository de forma automatica pela framework (tipo o ter o new)
	@Autowired 
	private SaleRepository repository;
	
	@Autowired 
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		Page<Sale> result =  repository.findAll(pageable);
		sellerRepository.findAll();
		//Para evitar uma ligação premanente à DB vamos passar para um novo objecto
		return result.map(x -> new SaleDTO(x));
	}
}
