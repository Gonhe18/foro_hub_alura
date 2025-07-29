package challenge.alura.foro.domain.topicos;

import jakarta.validation.constraints.NotBlank;

public record DatosTopicos(
        Long id,

        @NotBlank(message = "El título es obligatorio")
        String titulo,

        @NotBlank(message = "El mensaje es obligatorio")
        String mensaje,

        @NotBlank(message = "El autor es obligatorio")
        String autor,

        @NotBlank(message = "El curso es obligatorio")
        String curso
) {
        public DatosTopicos(Topico topico) {
                this(topico.getId(),topico.getTitulo(), topico.getMensaje(), topico.getAutor(), topico.getCurso());
        }
}
