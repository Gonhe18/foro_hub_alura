package challenge.alura.foro.domain.topicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    boolean existsByTituloAndMensaje(String titulo, String mensaje);

    @Query("""
    SELECT t FROM Topico t
    WHERE (:curso IS NULL OR t.curso = :curso)
      AND (:anio IS NULL OR FUNCTION('YEAR', t.fecha_de_creacion) = :anio)
""")
    Page<Topico> buscarPorCursoYAnio(@Param("curso") String curso,
                                     @Param("anio") Integer anio,
                                     Pageable pageable);
}
