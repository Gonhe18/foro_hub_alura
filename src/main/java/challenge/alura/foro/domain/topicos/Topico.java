package challenge.alura.foro.domain.topicos;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;


import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String titulo;
    @Setter
    private String mensaje;
//    @Column(name = "fecha_de_creacion", nullable = false)
    private LocalDateTime fecha_de_creacion = LocalDateTime.now();
    private String status;
    private String autor;
    @Setter
    private String curso;

    public Topico(@Valid DatosTopicos datosTopicos) {
        this.titulo = datosTopicos.titulo();
        this.mensaje = datosTopicos.mensaje();
        this.fecha_de_creacion = LocalDateTime.now();
        this.status = "Creado";
        this.autor = datosTopicos.autor();
        this.curso = datosTopicos.curso();
    }
}
