package forumHub.api.domain.topico;

import forumHub.api.domain.curso.Curso;
import org.springframework.web.bind.annotation.PathVariable;

public record DadosAtualizaTopico(Long id,
                                  String titulo,
                                  String mensagem,
                                  boolean status,
                                  Curso curso) {
}
