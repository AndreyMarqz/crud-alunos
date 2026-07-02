package io.github.AndreyMarqz.crudAlunos.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "materia")
public class MateriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", length = 60, nullable = false)
    private String nome;

    @OneToMany(mappedBy = "materia")
    private List<AvaliacaoEntity> avaliacoes = new ArrayList<>();

    public MateriaEntity() {
    }

    public MateriaEntity(UUID id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<AvaliacaoEntity> getAvaliacoes() {
        return avaliacoes;
    }

    public void addAvaliacoes(AvaliacaoEntity avaliacao) {
        this.avaliacoes.add(avaliacao);
        avaliacao.setMateria(this);
    }
}
