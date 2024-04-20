package br.com.api.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.api.model.error.ErrorMessage;
import br.com.api.model.exception.ResourceNotFoundException;

// para saber que ele é um manipulador de eventos usamos a notacao abaixo.
@ControllerAdvice
public class RestExceptiohandler {
    @ExceptionHandler(ResourceNotFoundException.class) // quero que esse evento ocorra quando acontecer esse outro evento.
    // esse ResponseEntity da tipagem que ele pode voltar qualquer coisa
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception) {
        ErrorMessage error = new ErrorMessage("Not found", HttpStatus.NOT_FOUND.value(), exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
