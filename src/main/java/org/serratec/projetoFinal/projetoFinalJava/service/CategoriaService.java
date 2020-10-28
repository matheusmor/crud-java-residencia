package org.serratec.projetoFinal.projetoFinalJava.service;

import java.util.List;
import java.util.Optional;

import org.serratec.projetoFinal.projetoFinalJava.entidades.Categoria;
import org.serratec.projetoFinal.projetoFinalJava.exception.CategoriaNotFoundException;
import org.serratec.projetoFinal.projetoFinalJava.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriasRepository;

	public List<Categoria> getAll() {
		List<Categoria> categorias = categoriasRepository.findAll();
		return categorias;
	}

	private Categoria findCategoria(Integer id) throws CategoriaNotFoundException {
		Optional<Categoria> achado = categoriasRepository.findById(id);
		if (!achado.isPresent()) {
			throw new CategoriaNotFoundException(id);
		}
		return achado.get();

	}

	public Categoria getCategoria(Integer id) throws CategoriaNotFoundException {
		return findCategoria(id);
	}

	public Categoria updateCategoria(Integer id, Categoria categoriaNova) throws CategoriaNotFoundException {
		Categoria achado = findCategoria(id);
		if (categoriaNova.getId() != null)
			achado.setId(categoriaNova.getId());
		if (categoriaNova.getNome() != null)
			achado.setNome(categoriaNova.getNome());
		if (categoriaNova.getDescricao() != null)
			achado.setDescricao(categoriaNova.getDescricao());
		
		
		achado = categoriasRepository.save(achado);
		return achado;

	}
	public Categoria deleteCategoria(Integer id) throws CategoriaNotFoundException {
Categoria categoria =findCategoria(id);
		categoriasRepository.delete(categoria);
		return categoria;
	}

	public Categoria createCategoria(Categoria categoria) {
		Categoria obj= categoriasRepository.save(categoria);
		return obj;
	}
}
