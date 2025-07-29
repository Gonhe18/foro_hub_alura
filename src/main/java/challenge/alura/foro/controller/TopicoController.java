package challenge.alura.foro.controller;

import challenge.alura.foro.domain.ValidacionException;
import challenge.alura.foro.domain.topicos.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("topicos")
//@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private TopicoRepository topicoRepository;

    //    CREAR TOPICO
    @PostMapping
    @Transactional
    public ResponseEntity<DatosTopicos> nuevoTopico(@RequestBody @Valid
                                                    DatosTopicos datosTopicos, UriComponentsBuilder uriComponentsBuilder) {

        var detalleTopico = topicoService.crearTopico(datosTopicos);

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(detalleTopico.id()).toUri();
        return ResponseEntity.created(url).body(detalleTopico);
    }

    //    LISTAR TOPICOS
    @GetMapping
    public ResponseEntity<Page<DetalleTopicos>> listadoTopicos(@PageableDefault(size = 10, sort = "fecha_de_creacion",
                                                                       direction = Sort.Direction.DESC) Pageable paginacion,
                                                               @RequestParam(required = false) String curso, @RequestParam(required = false) Integer anio) {

        Page<Topico> topicos = topicoRepository.buscarPorCursoYAnio(curso, anio, paginacion);
        Page<DetalleTopicos> page = topicos.map(DetalleTopicos::new);

        return ResponseEntity.ok(page);
    }

    //    CONSULTAR TOPICO
    @GetMapping("/{id}")
    public ResponseEntity<DetalleTopicos> mostarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ValidacionException("No se encontró un tópico con ID: " + id));

        var datosTopico = new DetalleTopicos(topico);
        return ResponseEntity.ok(datosTopico);
    }

    //    ACTUALIZAR TOPICO
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosActualizarTopico> actualizar(@PathVariable Long id, @RequestBody @Valid
    DatosActualizarTopico datosActualizarTopico) {

        Optional<Topico> topicoOptional = topicoRepository.findById(id);

        if (!topicoOptional.isPresent()) {
            throw new ValidacionException("No se encontró un tópico con ID: " + id);
        }

        Topico topico = topicoOptional.get();

        topicoService.actualizarTopico(topico,datosActualizarTopico);

        DatosActualizarTopico respuesta = new DatosActualizarTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getCurso()
        );

        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        if (!topicoRepository.findById(id).isPresent()) {
            throw new ValidacionException("No se encontró un tópico con ID: " + id);
        }

        topicoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
