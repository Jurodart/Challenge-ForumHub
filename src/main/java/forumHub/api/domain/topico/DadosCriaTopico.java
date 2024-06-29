package forumHub.api.domain.topico;

import forumHub.api.domain.curso.Curso;
import forumHub.api.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DadosCriaTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime data,
        boolean status,
        Curso curso,
        Usuario usuario) {
}
