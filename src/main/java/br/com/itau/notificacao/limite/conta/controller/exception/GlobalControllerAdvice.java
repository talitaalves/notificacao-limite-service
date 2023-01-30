package br.com.itau.notificacao.limite.conta.controller.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalControllerAdvice {

	private static final DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	
	public static String now() {
		return LocalDateTime.now()
				.format(formatador);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		
		log.error(ex.getMessage(),ex);
		
		ApiError apiError = new ApiError(
				HttpStatus.BAD_REQUEST.name(),
				"Há parâmetros inválidos na requisição",
				LocalDateTime.now()
				);
		ex.getFieldErrors()
			.forEach( erro -> {
				apiError.getErros().add(
						new SubErro(erro.getObjectName(),
									 erro.getField(),
									 erro.getRejectedValue(),
									 erro.getDefaultMessage()
									 )
						);
			});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
}
