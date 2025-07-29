package challenge.alura.foro.domain.topicos;

import challenge.alura.foro.domain.topicos.validaciones.ValidadorTopicos;
import challenge.alura.foro.domain.topicos.validaciones.ValidadorActualizacionTopicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {


    @Autowired
    private List<ValidadorTopicos> validadores;

    @Autowired
    private List<ValidadorActualizacionTopicos> validadoresActualizacion;

    @Autowired
    private TopicoRepository repository;



    public DatosTopicos crearTopico(DatosTopicos datosTopico){

        validadores.forEach(v -> v.validar(datosTopico));

        Topico topico = repository.save(new Topico(datosTopico));

        return new DatosTopicos(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor(),
                topico.getCurso()
        );
    }

    public void actualizarTopico(Topico topico,DatosActualizarTopico datosActualizarTopico) {

        validadoresActualizacion.forEach(v -> v.validar(datosActualizarTopico));

        if (datosActualizarTopico.titulo() != null && !datosActualizarTopico.titulo().isBlank()) {
            topico.setTitulo(datosActualizarTopico.titulo());
        }

        if (datosActualizarTopico.mensaje() != null && !datosActualizarTopico.mensaje().isBlank()) {
            topico.setMensaje(datosActualizarTopico.mensaje());
        }

        if (datosActualizarTopico.curso() != null && !datosActualizarTopico.curso().isBlank()) {
            topico.setCurso(datosActualizarTopico.curso());
        }
    }
}
