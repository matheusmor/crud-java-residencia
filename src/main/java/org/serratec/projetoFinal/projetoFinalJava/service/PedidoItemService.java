package org.serratec.projetoFinal.projetoFinalJava.service;

import java.util.List;
import java.util.Optional;

import org.serratec.projetoFinal.projetoFinalJava.entidades.Categoria;
import org.serratec.projetoFinal.projetoFinalJava.entidades.Pedido;
import org.serratec.projetoFinal.projetoFinalJava.entidades.PedidoItem;
import org.serratec.projetoFinal.projetoFinalJava.exception.CategoriaNotFoundException;
import org.serratec.projetoFinal.projetoFinalJava.repository.PedidoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoItemService {
	@Autowired
	private PedidoItemRepository pedidoItemRepository;

	public List<PedidoItem> getAll() {
		List<PedidoItem> pedidosItens = pedidoItemRepository.findAll();
		return pedidosItens;
	}
	
	

	private PedidoItem findPedidoItem(Integer id)  {
		Optional<PedidoItem> achado = pedidoItemRepository.findById(id);
		if (!achado.isPresent()) {
			return null;
		}
		return achado.get();

	}

	public PedidoItem getPedidoItem(Integer id)  {
		return findPedidoItem(id);
	}

	public PedidoItem updatePedidoItem(Integer id, PedidoItem PedidoItemNovo)  {
		PedidoItem achado = findPedidoItem(id);
		if (PedidoItemNovo.getId() != null)
			achado.setId(PedidoItemNovo.getId());
		if (PedidoItemNovo.getQuantidade() != null)
			achado.setQuantidade(PedidoItemNovo.getQuantidade());
		
		
		
		achado = pedidoItemRepository.save(achado);
		return achado;

	}
	public PedidoItem deletePedido(Integer id) throws CategoriaNotFoundException {
PedidoItem pedidoItem =findPedidoItem(id);
		pedidoItemRepository.delete(pedidoItem);
		return pedidoItem;
	}

	public PedidoItem createPedidoItem(PedidoItem pedidoItem) {
		PedidoItem obj= pedidoItemRepository.save(pedidoItem);
		return obj;
	}

}
