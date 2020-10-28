package org.serratec.projetoFinal.projetoFinalJava.service;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import org.serratec.projetoFinal.projetoFinalJava.service.*;
import org.serratec.projetoFinal.projetoFinalJava.entidades.Cliente;
import org.serratec.projetoFinal.projetoFinalJava.entidades.Pedido;
import org.serratec.projetoFinal.projetoFinalJava.exception.ClienteNotFoundException;
import org.serratec.projetoFinal.projetoFinalJava.exception.DataNotFoundException;
import org.serratec.projetoFinal.projetoFinalJava.exception.PedidoNotFoundException;
import org.serratec.projetoFinal.projetoFinalJava.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	@Autowired
	private PedidosRepository pedidosRepository;
	
	@Autowired
	private ClienteService clienteService;

	public List<Pedido> getAll() {

		List<Pedido> pedidos = pedidosRepository.findAll();
		return pedidos;
	}

	private Pedido findPedido(Integer id) throws PedidoNotFoundException {
		Optional<Pedido> achado = pedidosRepository.findById(id);
		if (!achado.isPresent()) {
			throw new PedidoNotFoundException(id);
		}
		return achado.get();

	}

	public Pedido getPedido(Integer id) throws PedidoNotFoundException {
		return findPedido(id);
	}

	public Pedido updatePedido(Integer id, Pedido pedidoNovo) throws PedidoNotFoundException {
		Pedido achado = findPedido(id);
		if (pedidoNovo.getId() != null)
			achado.setId(pedidoNovo.getId());
		if (pedidoNovo.getData_pedido() != null)
			achado.setData_pedido(pedidoNovo.getData_pedido());
		if (pedidoNovo.getItens() != null)
			achado.setItens(pedidoNovo.getItens());

		if (pedidoNovo.getCliente() != null)
			achado.setCliente(pedidoNovo.getCliente());

		achado = pedidosRepository.save(achado);
		return achado;

	}

	public Pedido deletePedido(Integer id) throws PedidoNotFoundException {
		Pedido pedido = findPedido(id);
		pedidosRepository.delete(pedido);
		return pedido;
	}

	public Pedido createPedido(Pedido pedido) throws Exception {

		Cliente cliente = pedido.getCliente();
		Integer id=cliente.getId();
		
		if (!clienteService.getCliente(cliente.getId()).equals(null) ) {
			Pedido obj = pedidosRepository.save(pedido);
			return obj;
		} else {

			throw new DataNotFoundException(id);
		}

	}
}
