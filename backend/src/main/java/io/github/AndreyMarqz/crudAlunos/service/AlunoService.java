package io.github.AndreyMarqz.crudAlunos.service;

import io.github.AndreyMarqz.crudAlunos.dto.AlunoRequestDto;
import io.github.AndreyMarqz.crudAlunos.dto.AlunoResponseDto;
import io.github.AndreyMarqz.crudAlunos.entity.AlunoEntity;
import io.github.AndreyMarqz.crudAlunos.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Transactional
    public AlunoResponseDto cadastrarAluno(AlunoRequestDto alunoRequestDto) {

        AlunoEntity aluno = new AlunoEntity();
        aluno.setNome(alunoRequestDto.nome());
        aluno.setCpf(alunoRequestDto.cpf());
        aluno.setDtaNascimento(alunoRequestDto.dtaNascimento());
        aluno.setNumeroMatricula(alunoRequestDto.numeroMatricula());
        aluno.setSenha(alunoRequestDto.senha());

        AlunoEntity alunoSalvo = alunoRepository.save(aluno);

        return new AlunoResponseDto(alunoSalvo.getId(), alunoSalvo.getNome(), alunoSalvo.getDtaNascimento(), alunoSalvo.getNumeroMatricula());
    }

    public AlunoResponseDto buscarAlunoPorId(UUID id) {

        AlunoEntity aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));

        return new AlunoResponseDto(aluno.getId(), aluno.getNome(), aluno.getDtaNascimento(), aluno.getNumeroMatricula());
    }

    @Transactional
    public AlunoResponseDto atualizarAluno(UUID id, AlunoRequestDto alunoRequestDto) {

        AlunoEntity aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));

        aluno.setNome(alunoRequestDto.nome());
        aluno.setCpf(alunoRequestDto.cpf());
        aluno.setDtaNascimento(alunoRequestDto.dtaNascimento());
        aluno.setNumeroMatricula(alunoRequestDto.numeroMatricula());

        if (alunoRequestDto.senha() != null && !alunoRequestDto.senha().isBlank()) {
            aluno.setSenha(alunoRequestDto.senha());
        }

        AlunoEntity alunoSalvo = alunoRepository.save(aluno);

        return new AlunoResponseDto(alunoSalvo.getId(), alunoSalvo.getNome(), alunoSalvo.getDtaNascimento(), alunoSalvo.getNumeroMatricula());
    }

    public List<AlunoResponseDto> listarAlunos() {

        return alunoRepository.findAll()
                .stream()
                .map(aluno -> new AlunoResponseDto(aluno.getId(), aluno.getNome(), aluno.getDtaNascimento(), aluno.getNumeroMatricula()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void deletarAluno(UUID id) {

        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno não encontrado para exclusão.");
        }
        alunoRepository.deleteById(id);
    }
}

