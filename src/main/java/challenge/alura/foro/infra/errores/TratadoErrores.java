package challenge.alura.foro.infra.errores;

import challenge.alura.foro.domain.ValidacionException;
import challenge.alura.foro.domain.topicos.validaciones.DatosError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class TratadoErrores {

    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity<DatosError> manejarValidacion(ValidacionException ex, HttpServletRequest request) {

        DatosError error = new DatosError(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                request.getRequestURI(),
                LocalDateTime.now(),
                null
        );

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DatosError> manejarArgumentoNoValido(MethodArgumentNotValidException ex, HttpServletRequest request) {
        Map<String, String> errores = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage,
                        (m1, m2) -> m1
                ));

        DatosError error = new DatosError(
                "Error de validación",
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                request.getRequestURI(),
                LocalDateTime.now(),
                errores
        );

        return ResponseEntity.badRequest().body(error);
    }
}
