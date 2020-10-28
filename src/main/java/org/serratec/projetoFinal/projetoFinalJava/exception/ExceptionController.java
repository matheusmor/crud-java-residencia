package org.serratec.projetoFinal.projetoFinalJava.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	@ExceptionHandler(ProdutoNotFoundException.class)
	public ResponseEntity<String> trataProdutoNotFound(ProdutoNotFoundException exception) {
		String msg = String.format("O Produto com ID %d não foi encontrado", exception.getId());
		return ResponseEntity.notFound().header("x mesg erro", msg).header("x codigo erro", "PRODUTO_NOT_FOUND")
				.header("x erro valor", exception.getId().toString()).build();
	}

	@ExceptionHandler(ClienteNotFoundException.class)
	public ResponseEntity<String> trataClienteNotFound(ClienteNotFoundException exception) {
		String msg = String.format("O Cliente com ID %d não foi encontrado", exception.getId());
		return ResponseEntity.notFound().header("x mesg erro", msg).header("x codigo erro", "CLIENTE_NOT_FOUND")
				.header("x erro valor", exception.getId().toString()).build();
	}

	@ExceptionHandler(CategoriaNotFoundException.class)
	public ResponseEntity<String> trataCategoriaNotFound(CategoriaNotFoundException exception) {
		String msg = String.format("O Categoria com ID %d não foi encontrado", exception.getId());
		return ResponseEntity.notFound().header("x mesg erro", msg).header("x codigo erro", "CATEGORIA_NOT_FOUND")
				.header("x erro valor", exception.getId().toString()).build();
	}

	@ExceptionHandler(PedidoNotFoundException.class)
	public ResponseEntity<String> trataPedidoNotFound(PedidoNotFoundException exception) {
		String msg = String.format("O Pedido com ID %d não foi encontrado", exception.getId());
		return ResponseEntity.notFound().header("x mesg erro", msg).header("x codigo erro", "PEDIDO_NOT_FOUND")
				.header("x erro valor", exception.getId().toString()).build();

	}

	@ExceptionHandler(FuncionarioNotFoundException.class)
	public ResponseEntity<String> trataFuncionarioNotFound(FuncionarioNotFoundException exception) {
		String msg = String.format("O Funcionario com ID %d não foi encontrado", exception.getId());
		return ResponseEntity.notFound().header("x mesg erro", msg).header("x codigo erro", "FUNCIONARIO_NOT_FOUND")
				.header("x erro valor", exception.getId().toString()).build();

	}

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<String> trataDataNotFound(DataNotFoundException exception) {
		String msg = String.format("O ID %d não foi encontrado", exception.getId());
		return ResponseEntity.notFound().header("x msg erro", msg).header("x codigo erro", "DATA_NOT_FOUND")
				.header("x erro valor", exception.getId().toString()).build();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> trataValidacao(MethodArgumentNotValidException e) {
		return ResponseEntity.badRequest().header("error-code", "REGISTRO_INVAIDO")
				.header("error-message", "NULL FOUND").build();

	}
}
