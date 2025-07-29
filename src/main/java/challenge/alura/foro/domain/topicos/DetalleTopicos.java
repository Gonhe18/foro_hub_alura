package challenge.alura.foro.domain.topicos;

import java.time.LocalDateTime;

public record DetalleTopicos(
        String titulo,
        String mensaje,
        String autor,
        String status,
        LocalDateTime fecha_de_creacion,
        String curso
) {
    public DetalleTopicos(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getAutor(), topico.getStatus(),
                topico.getFecha_de_creacion(), topico.getCurso());
    }
}
