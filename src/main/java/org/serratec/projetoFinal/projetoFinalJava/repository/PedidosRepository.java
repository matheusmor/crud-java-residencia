package org.serratec.projetoFinal.projetoFinalJava.repository;

import java.util.List;

import org.serratec.projetoFinal.projetoFinalJava.entidades.Pedido;
import org.serratec.projetoFinal.projetoFinalJava.entidades.Produto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PedidosRepository extends JpaRepository<Pedido,Integer> {
	
	@Query("select P from Pedido P join  fetch P.cliente C where C.id= :id")
	List<Pedido> findByClienteId(@Param("id") Integer cliente);
	


}
