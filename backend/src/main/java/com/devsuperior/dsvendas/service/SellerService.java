package com.devsuperior.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	// Permite injectar no repositoty uma nova instancia do object SellerRepository de forma automatica pela framework (tipo o ter o new)
	@Autowired 
	private SellerRepository repository;
	
	public List<SellerDTO> findAll() {
		List<Seller> result =  repository.findAll();
		
		//Para evitar uma ligação premanente à DB vamos passar para um novo objecto
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
}
