package org.serratec.projetoFinal.projetoFinalJava.controller;

import java.util.List;

import org.serratec.projetoFinal.projetoFinalJava.entidades.Categoria;
import org.serratec.projetoFinal.projetoFinalJava.exception.CategoriaNotFoundException;
import org.serratec.projetoFinal.projetoFinalJava.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/categoria")
	public List<Categoria> getCategoria(){
		return categoriaService.getAll();
	}
	
	@GetMapping("/categoria/{id}")
	public Categoria getCategoria(@PathVariable Integer id) throws CategoriaNotFoundException {
		return categoriaService.getCategoria(id);
	}
	@PostMapping("/categoria")
	public Categoria postCategoria(@RequestBody Categoria categoria) {
		return categoriaService.createCategoria(categoria);
	}
	
	@PutMapping("/categoria/{id}")
	public Categoria putCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) throws CategoriaNotFoundException {
		return categoriaService.updateCategoria(id,categoria);
	}
	
	@DeleteMapping("/categoria/{id}")
	public Categoria deleteCategoria(@PathVariable Integer id) throws CategoriaNotFoundException {
		return categoriaService.deleteCategoria(id);
	}
}
