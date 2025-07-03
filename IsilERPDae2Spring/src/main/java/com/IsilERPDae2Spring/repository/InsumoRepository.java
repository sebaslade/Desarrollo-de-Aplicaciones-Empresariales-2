package com.IsilERPDae2Spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.IsilERPDae2Spring.entity.Insumo;

public interface InsumoRepository extends JpaRepository<Insumo, Integer>{
	List<Insumo> findAll();
	Insumo findById(int id);
	
	@Transactional
	void deleteById(int id);
}
