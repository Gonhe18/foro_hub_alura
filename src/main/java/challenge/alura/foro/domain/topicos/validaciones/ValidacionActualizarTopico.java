package challenge.alura.foro.domain.topicos.validaciones;

import challenge.alura.foro.domain.ValidacionException;
import challenge.alura.foro.domain.topicos.DatosActualizarTopico;
import challenge.alura.foro.domain.topicos.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ValidacionActualizarTopico implements ValidadorActualizacionTopicos {

    @Autowired
    private TopicoRepository repository;

    public void validar(DatosActualizarTopico datos) {

        var existeTopico = repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());
        if(existeTopico){
            throw new ValidacionException("Ya existe un tópico con los datos ingresados");
        }

        List<String> errores = new ArrayList<>();

        if (datos.titulo() != null && datos.titulo().isBlank()) {
            errores.add("titulo");
        }
        if (datos.mensaje() != null && datos.mensaje().isBlank()) {
            errores.add("mensaje");
        }
        if (datos.curso() != null && datos.curso().isBlank()) {
            errores.add("curso");
        }

        if (!errores.isEmpty()) {
            String campos = String.join(", ", errores);
            throw new ValidacionException("Los siguientes campos son inválidos: " + campos);
        }
    }
}
