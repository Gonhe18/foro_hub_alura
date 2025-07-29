package challenge.alura.foro.domain.topicos.validaciones;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@NoArgsConstructor
public class DatosError {
    private String mensaje;
    private int status;
    private String error;
    private String path;
    private LocalDateTime timestamp;
    private Map<String, String> errores; // ← este campo

    public DatosError(String mensaje, int status, String error, String path,
                      LocalDateTime timestamp, Map<String, String> errores) {
        this.mensaje = mensaje;
        this.status = status;
        this.error = error;
        this.path = path;
        this.timestamp = timestamp;
        this.errores = errores;
    }
}
