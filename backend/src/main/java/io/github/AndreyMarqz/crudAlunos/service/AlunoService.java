package io.github.AndreyMarqz.crudAlunos.service;

import io.github.AndreyMarqz.crudAlunos.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
}

