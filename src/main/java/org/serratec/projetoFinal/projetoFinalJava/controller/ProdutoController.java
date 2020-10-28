package org.serratec.projetoFinal.projetoFinalJava.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.projetoFinal.projetoFinalJava.entidades.Produto;
import org.serratec.projetoFinal.projetoFinalJava.exception.CategoriaNotFoundException;
import org.serratec.projetoFinal.projetoFinalJava.exception.DataNotFoundException;
import org.serratec.projetoFinal.projetoFinalJava.exception.ProdutoNotFoundException;
import org.serratec.projetoFinal.projetoFinalJava.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/produto")
	public List<Produto> getProdutos(){
		return produtoService.getAll();
	}
	
	@GetMapping("/produto/{id}")
	public Produto getProduto(@PathVariable Integer id) throws ProdutoNotFoundException {
		return produtoService.getProduto(id);
}
	@PostMapping("/produto")
	public Produto postProduto(@Valid @RequestBody Produto produto) throws Exception {
		return produtoService.createProduto(produto);
	}
	
	@PutMapping("/produto/{id}")
	public Produto putProduto(@PathVariable Integer id, @RequestBody Produto produto) throws ProdutoNotFoundException {
		return produtoService.updateProduto(id,produto);
	}
	
	@DeleteMapping("/produto/{id}")
	public Produto deleteProduto(@PathVariable Integer id) throws ProdutoNotFoundException {
		return produtoService.deleteProduto(id);
	}
	


}
