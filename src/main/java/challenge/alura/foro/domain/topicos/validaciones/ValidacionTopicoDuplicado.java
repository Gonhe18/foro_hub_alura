package challenge.alura.foro.domain.topicos.validaciones;

import challenge.alura.foro.domain.ValidacionException;
import challenge.alura.foro.domain.topicos.DatosTopicos;
import challenge.alura.foro.domain.topicos.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacionTopicoDuplicado implements ValidadorTopicos{

    @Autowired
    private TopicoRepository repository;

    public void validar(DatosTopicos datos) {
        var existeTopico = repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());

        if(existeTopico){
            throw new ValidacionException("Ya existe un tópico con los datos ingresados");
        }
    }
}
