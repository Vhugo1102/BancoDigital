package br.com.cdb.bancodigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cdb.bancodigital.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	
}
