package io.github.AndreyMarqz.crudAlunos.service;

import io.github.AndreyMarqz.crudAlunos.dto.AvaliacaoRequestDto;
import io.github.AndreyMarqz.crudAlunos.dto.AvaliacaoResponseDto;
import io.github.AndreyMarqz.crudAlunos.entity.AlunoEntity;
import io.github.AndreyMarqz.crudAlunos.entity.AvaliacaoEntity;
import io.github.AndreyMarqz.crudAlunos.entity.MateriaEntity;
import io.github.AndreyMarqz.crudAlunos.repository.AlunoRepository;
import io.github.AndreyMarqz.crudAlunos.repository.AvaliacaoRepository;
import io.github.AndreyMarqz.crudAlunos.repository.MateriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final AlunoRepository alunoRepository;
    private final MateriaRepository materiaRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository, AlunoRepository alunoRepository, MateriaRepository materiaRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
        this.alunoRepository = alunoRepository;
        this.materiaRepository = materiaRepository;
    }

    @Transactional
    public AvaliacaoResponseDto cadastrarNota(AvaliacaoRequestDto avaliacaoRequestDto) {

        AlunoEntity alunoEncontrado = alunoRepository.findById(avaliacaoRequestDto.alunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        MateriaEntity materiaEncontrada = materiaRepository.findById(avaliacaoRequestDto.materiaId())
                .orElseThrow(() -> new RuntimeException("Matéria não encontrada"));

        AvaliacaoEntity avaliacao = new AvaliacaoEntity();
        avaliacao.setNota(avaliacaoRequestDto.nota());
        avaliacao.setAluno(alunoEncontrado);
        avaliacao.setMateria(materiaEncontrada);

        AvaliacaoEntity avaliacaoSalva = avaliacaoRepository.save(avaliacao);

        return new AvaliacaoResponseDto(avaliacaoSalva.getId(), avaliacaoSalva.getNota(), avaliacaoSalva.getAluno().getNome(), avaliacaoSalva.getMateria().getNome());
    }

    public AvaliacaoResponseDto consultarNotaPorId(UUID id) {

        AvaliacaoEntity avaliacao = avaliacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota não encontrada com o ID: " + id));

        return new AvaliacaoResponseDto(avaliacao.getId(), avaliacao.getNota(), avaliacao.getAluno().getNome(), avaliacao.getMateria().getNome());
    }

    @Transactional
    public AvaliacaoResponseDto atualizarNota(UUID notaId, AvaliacaoRequestDto avaliacaoRequestDto) {

        AvaliacaoEntity avaliacao = avaliacaoRepository.findById(notaId)
                .orElseThrow(() -> new RuntimeException("Nota não encontrada com o ID: " + notaId));

        AlunoEntity aluno = alunoRepository.findById(avaliacaoRequestDto.alunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + avaliacaoRequestDto.alunoId()));

        MateriaEntity materia = materiaRepository.findById(avaliacaoRequestDto.materiaId())
                .orElseThrow(() -> new RuntimeException("Matéria não encontrada com o ID: " + avaliacaoRequestDto.materiaId()));

        avaliacao.setNota(avaliacaoRequestDto.nota());
        avaliacao.setAluno(aluno);
        avaliacao.setMateria(materia);

        AvaliacaoEntity avaliacaoSalva = avaliacaoRepository.save(avaliacao);

        return new AvaliacaoResponseDto(avaliacaoSalva.getId(), avaliacaoSalva.getNota(), avaliacaoSalva.getAluno().getNome(), avaliacaoSalva.getMateria().getNome());
    }

    public List<AvaliacaoResponseDto> listarNotas() {
        return avaliacaoRepository.findAll()
                .stream()
                .map(avaliacao -> new AvaliacaoResponseDto(avaliacao.getId(), avaliacao.getNota(), avaliacao.getAluno().getNome(), avaliacao.getMateria().getNome()))
                .collect(Collectors.toList());
    }

    @Transactional
    public AvaliacaoResponseDto deletarNota(UUID id) {

        if(!avaliacaoRepository.existsById(id)) {
            throw new RuntimeException("Nota não encontrada para exclusão.");
        }
        avaliacaoRepository.deleteById(id);
        return null;
    }
}
