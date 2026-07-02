package io.github.AndreyMarqz.crudAlunos.repository;

import io.github.AndreyMarqz.crudAlunos.entity.AvaliacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, UUID> {
}
