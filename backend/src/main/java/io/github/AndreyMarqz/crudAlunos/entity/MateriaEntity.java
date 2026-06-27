package io.github.AndreyMarqz.crudAlunos.entity;

import jakarta.persistence.*;

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
    private List<AvaliacaoEntity> avaliacoes;
}
