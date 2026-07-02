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


    public AvaliacaoEntity() {
    }

    public AvaliacaoEntity(UUID id, Double nota, AlunoEntity aluno, MateriaEntity materia) {
        this.id = id;
        this.nota = nota;
        this.aluno = aluno;
        this.materia = materia;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public AlunoEntity getAluno() {
        return aluno;
    }

    public void setAluno(AlunoEntity aluno) {
        this.aluno = aluno;
    }

    public MateriaEntity getMateria() {
        return materia;
    }

    public void setMateria(MateriaEntity materia) {
        this.materia = materia;
    }
}
