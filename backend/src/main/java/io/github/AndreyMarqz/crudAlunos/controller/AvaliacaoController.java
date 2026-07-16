package io.github.AndreyMarqz.crudAlunos.controller;

import io.github.AndreyMarqz.crudAlunos.dto.AvaliacaoRequestDto;
import io.github.AndreyMarqz.crudAlunos.dto.AvaliacaoResponseDto;
import io.github.AndreyMarqz.crudAlunos.service.AvaliacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<AvaliacaoResponseDto> cadastrar(@RequestBody AvaliacaoRequestDto avaliacaoRequestDto) {

        AvaliacaoResponseDto avaliacaoSalva = avaliacaoService.cadastrarNota(avaliacaoRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoSalva);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<AvaliacaoResponseDto> buscarPorId(@PathVariable UUID id) {

        AvaliacaoResponseDto avaliacaoEncontrada = avaliacaoService.consultarNotaPorId(id);
        return ResponseEntity.ok(avaliacaoEncontrada);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AvaliacaoResponseDto>> listarTodos() {

        List<AvaliacaoResponseDto> listarAvaliacoes = avaliacaoService.listarNotas();
        return ResponseEntity.ok(listarAvaliacoes);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<AvaliacaoResponseDto> atualizar(@PathVariable UUID id, @RequestBody AvaliacaoRequestDto avaliacaoRequestDto) {

        AvaliacaoResponseDto avaliacaoAtualizada = avaliacaoService.atualizarNota(id, avaliacaoRequestDto);
        return ResponseEntity.ok(avaliacaoAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<AvaliacaoResponseDto> deletar(@PathVariable UUID id) {

        AvaliacaoResponseDto avaliacaoDeletada = avaliacaoService.deletarNota(id);
        return ResponseEntity.ok(avaliacaoDeletada);
    }
}
