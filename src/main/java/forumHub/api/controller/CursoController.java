package forumHub.api.controller;

import forumHub.api.domain.curso.*;
import forumHub.api.domain.topico.DadosAtualizaTopico;
import forumHub.api.domain.topico.DadosDetalhamentoTopico;
import forumHub.api.domain.topico.Topico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController //Avisa que é um controller
@RequestMapping("cursos") // é a rota de requisição da url
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping //método post na requisição
    @Transactional
    public void criarCursos(@RequestBody @Valid DadosCriaCurso dadoscriaCurso) {
        //RequestBody permite pegar o corpo do json na requisição

        cursoRepository.save(new Curso(dadoscriaCurso));
    }

    @GetMapping
    public ResponseEntity listagemCursos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = cursoRepository.findAll();
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaCurso dados) {
        var atualizaCurso = cursoRepository.getReferenceById(dados.id());
        atualizaCurso.atualizaCurso(dados);

        return ResponseEntity.ok(new DadosDetalhamentoCurso(atualizaCurso));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Optional<Curso> cursoExclui = cursoRepository.findById(id);
        if (cursoExclui.isPresent()){
            cursoRepository.deleteById(id);
        }

        return ResponseEntity.noContent().build();
    }
}