package org.serratec.projetoFinal.projetoFinalJava.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.projetoFinal.projetoFinalJava.entidades.Pedido;
import org.serratec.projetoFinal.projetoFinalJava.exception.ClienteNotFoundException;
import org.serratec.projetoFinal.projetoFinalJava.exception.PedidoNotFoundException;
import org.serratec.projetoFinal.projetoFinalJava.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class PedidoController {
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping("/pedido")
	public List<Pedido> getPedido(){
		return pedidoService.getAll();
	}
	
	@GetMapping("/pedido/{id}")
	public Pedido getPedido(@PathVariable Integer id) throws PedidoNotFoundException {
		return pedidoService.getPedido(id);
	}
	@PostMapping("/pedido")
	public Pedido postPedido(@Valid @RequestBody Pedido pedido) throws Exception {
		return pedidoService.createPedido(pedido);
	}
	
	@PutMapping("/pedido/{id}")
	public Pedido putPedido(@PathVariable Integer id, @RequestBody Pedido pedido) throws PedidoNotFoundException {
		return pedidoService.updatePedido(id,pedido);
	}
	
	@DeleteMapping("/pedido/{id}")
	public Pedido deletePedido(@PathVariable Integer id) throws PedidoNotFoundException {
		return pedidoService.deletePedido(id);
	}
}
