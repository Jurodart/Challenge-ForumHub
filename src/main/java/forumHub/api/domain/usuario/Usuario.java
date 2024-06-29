package forumHub.api.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String senha;

    @Column
    private boolean status;

    public Usuario(DadosCriaUsuario dadosCriaUsuario) {
        this.id = dadosCriaUsuario.id();
        this.nome = dadosCriaUsuario.nome();
        this.email = dadosCriaUsuario.email();
        this.senha = dadosCriaUsuario.senha();
        this.status = dadosCriaUsuario.status();
    }

    public void atualizaUsuario(DadosAtualizaUsuario dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.email() != null){
            this.email = dados.email();
        }
        if (dados.senha() != null){
            this.senha = dados.senha();
        }
    }
}
