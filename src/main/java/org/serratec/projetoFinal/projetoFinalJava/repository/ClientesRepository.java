package org.serratec.projetoFinal.projetoFinalJava.repository;

import org.serratec.projetoFinal.projetoFinalJava.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente,Integer>{
	
	
}
