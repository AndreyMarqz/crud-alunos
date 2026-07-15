package io.github.AndreyMarqz.crudAlunos.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "aluno")
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.BINARY)
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
    private List<AvaliacaoEntity> avaliacoes = new ArrayList<>();

    public AlunoEntity() {
    }

    public AlunoEntity(UUID id, String nome, String cpf, LocalDate dtaNascimento, String numeroMatricula, String senha, Instant creationTimestamp, Instant updateTimestamp) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dtaNascimento = dtaNascimento;
        this.numeroMatricula = numeroMatricula;
        this.senha = senha;
        this.creationTimestamp = creationTimestamp;
        this.updateTimestamp = updateTimestamp;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDtaNascimento() {
        return dtaNascimento;
    }

    public void setDtaNascimento(LocalDate dtaNascimento) {
        this.dtaNascimento = dtaNascimento;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Instant getCreationTimeStamp() {
        return creationTimestamp;
    }

    public void setCreationTimeStamp(Instant creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Instant getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimeStamp(Instant updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public List<AvaliacaoEntity> getAvaliacoes() {
        return avaliacoes;
    }

    public void addAvaliacoes(AvaliacaoEntity avaliacao) {
        this.avaliacoes.add(avaliacao);
        avaliacao.setAluno(this);
    }
}
