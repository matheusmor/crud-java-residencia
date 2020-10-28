package org.serratec.projetoFinal.projetoFinalJava.repository;

import java.util.List;

import org.serratec.projetoFinal.projetoFinalJava.entidades.Pedido;
import org.serratec.projetoFinal.projetoFinalJava.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produto, Integer> {

	//@Query("select P from Produto P join fetch P.Categoria C where C.id= :id")
	//List<Pedido> findByCategoriaId(@Param("id") Integer categoria);
}
