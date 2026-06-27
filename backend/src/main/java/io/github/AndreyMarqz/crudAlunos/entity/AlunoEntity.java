package io.github.AndreyMarqz.crudAlunos.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "aluno")
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @Column(name = "dtaNascimento", nullable = false)
    private LocalDate dtaNascimento;

    @Column(name = "numeroMatricula", length = 10, nullable = false)
    private String numeroMatricula;

    @Column(name = "senha", length = 12, nullable = false)
    private String senha;

    @CreationTimestamp
    private Instant creationTimestamp;

    @UpdateTimestamp
    private Instant updateTimestamp;

    @OneToMany(mappedBy = "aluno")
    private List<AvaliacaoEntity> avaliacoes;
}
