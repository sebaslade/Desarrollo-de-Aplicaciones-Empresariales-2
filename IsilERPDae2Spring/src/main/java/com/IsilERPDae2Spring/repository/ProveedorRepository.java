package com.IsilERPDae2Spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IsilERPDae2Spring.entity.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{
	List<Proveedor> findByEstado(String estado);
}
