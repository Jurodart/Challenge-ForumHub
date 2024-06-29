package forumHub.api.controller;

import forumHub.api.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController //Avisa que é um controller
@RequestMapping("topicos") // é a rota de requisição da url
public class TopicoController {

    private Topico topico;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping //método post na requisição
    @Transactional
    public void criarTopicos(@RequestBody @Valid DadosCriaTopico dadosCriaTopico) {
        //RequestBody permite pegar o corpo do json na requisição

        topicoRepository.save(new Topico(dadosCriaTopico));
    }

    @GetMapping
    public ResponseEntity listagemTopicos(@PageableDefault(size = 10, sort = {"data"}) Pageable paginacao){
        var page = topicoRepository.findAll(Sort.by(Sort.Direction.DESC, "data"));
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaTopico dados) {
        var atualizatopico = topicoRepository.getReferenceById(dados.id());
        atualizatopico.atualizaTopico(dados);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(atualizatopico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Optional<Topico> topicoExclui = topicoRepository.findById(id);
        if (topicoExclui.isPresent()){
            topicoRepository.deleteById(id);
        }

        return ResponseEntity.noContent().build();
    }
}
