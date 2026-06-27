package io.github.AndreyMarqz.crudAlunos.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "avaliacao")
public class AvaliacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nota", length = 4, nullable = false)
    private Double nota;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private AlunoEntity aluno;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private MateriaEntity materia;
}
