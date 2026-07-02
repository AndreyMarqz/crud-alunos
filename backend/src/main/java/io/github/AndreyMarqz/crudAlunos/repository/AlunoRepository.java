package io.github.AndreyMarqz.crudAlunos.repository;

import io.github.AndreyMarqz.crudAlunos.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, UUID> {
}
