package forumHub.api.domain.topico;

import forumHub.api.domain.curso.Curso;
import jakarta.validation.constraints.NotNull;

public record DadosDetalhamentoTopico(@NotNull Long id, String titulo, String mensagem, boolean status, Curso curso) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.isStatus(), topico.getCurso());
    }
}
