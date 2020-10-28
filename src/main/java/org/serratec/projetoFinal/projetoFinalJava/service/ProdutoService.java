package org.serratec.projetoFinal.projetoFinalJava.service;

import java.util.List;
import java.util.Optional;

import org.serratec.projetoFinal.projetoFinalJava.entidades.Categoria;
import org.serratec.projetoFinal.projetoFinalJava.entidades.Produto;
import org.serratec.projetoFinal.projetoFinalJava.exception.CategoriaNotFoundException;
import org.serratec.projetoFinal.projetoFinalJava.exception.DataNotFoundException;
import org.serratec.projetoFinal.projetoFinalJava.exception.ProdutoNotFoundException;
import org.serratec.projetoFinal.projetoFinalJava.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {
	@Autowired
	private ProdutosRepository produtosRepository;
	@Autowired
	private CategoriaService categoriaService;

	public List<Produto> getAll() {
		List<Produto> produtos = produtosRepository.findAll();
		return produtos;
	}

	private Produto findProduto(Integer id) throws ProdutoNotFoundException {
		Optional<Produto> achado = produtosRepository.findById(id);
		if (!achado.isPresent()) {
			throw new ProdutoNotFoundException(id);
		}
		return achado.get();

	}

	public Produto getProduto(Integer id) throws ProdutoNotFoundException {
		return findProduto(id);
	}

	public Produto createProduto(Produto produto) throws Exception{
		Categoria categoria = produto.getCategoria();
		Integer id = categoria.getId();
		
		if (!categoriaService.getCategoria(categoria.getId()).equals(null)) {
			Produto obj = produtosRepository.save(produto);
			return obj;
		} else {
			throw new DataNotFoundException(id);
		}
	}

	public Produto updateProduto(Integer id, Produto produtoNovo) throws ProdutoNotFoundException {
		Produto achado = findProduto(id);
		if (produtoNovo.getId() != null)
			achado.setId(produtoNovo.getId());
		if (produtoNovo.getNome() != null)
			achado.setNome(produtoNovo.getNome());
		if (produtoNovo.getDescricao() != null)
			achado.setDescricao(produtoNovo.getDescricao());
		if (produtoNovo.getQuantidade() != null)
			achado.setQuantidade(produtoNovo.getQuantidade());
		if (produtoNovo.getDataFabricacao() != null)
			achado.setDataFabricacao(produtoNovo.getDataFabricacao());
		if (produtoNovo.getValor() > 0)
			achado.setValor(produtoNovo.getValor());
		achado = produtosRepository.save(achado);
		return achado;

	}

	public Produto deleteProduto(Integer id) throws ProdutoNotFoundException {

		Produto produto = findProduto(id);
		produtosRepository.delete(produto);
		return produto;
	}

}
