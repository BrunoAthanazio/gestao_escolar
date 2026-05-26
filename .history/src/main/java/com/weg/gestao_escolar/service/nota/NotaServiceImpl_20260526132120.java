package com.weg.gestao_escolar.service.nota;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.gestao_escolar.dto.nota.NotaRequestDto;
import com.weg.gestao_escolar.dto.nota.NotaResponseDto;
import com.weg.gestao_escolar.mapper.NotaMapper;
import com.weg.gestao_escolar.model.Nota;
import com.weg.gestao_escolar.repository.nota.NotaRepository;

@Service
public class NotaServiceImpl implements NotaService{

    private NotaMapper notaMapper;
    private NotaRepository notaRepository;

    public NotaServiceImpl(NotaMapper notaMapper, NotaRepository notaRepository){
        this.notaMapper = notaMapper;
        this.notaRepository = notaRepository;
    }

    @Override
    public NotaResponseDto save(NotaRequestDto notaRequest) throws SQLException {
        Nota nota = notaMapper.toEntity(notaRequest);
        notaRepository.save(nota);
        nota = notaRepository.get(nota.getId());
        NotaResponseDto notaResponse = notaMapper.toResponse(nota);
        return notaResponse;
    }

    @Override
    public NotaResponseDto get(Long id) throws SQLException {
        Nota nota = notaRepository.get(id);
        NotaResponseDto notaResponse = notaMapper.toResponse(nota);
        return notaResponse;
    }

    @Override
    public List<NotaResponseDto> getAll() throws SQLException {
        List<Nota> notas = notaRepository.getAll();
        List<NotaResponseDto> notaResponses = new ArrayList<>();
        for(Nota nota : notas){
            NotaResponseDto notaResponse = nota
        }
    }

    @Override
    public NotaResponseDto update(Long id, NotaRequestDto notaRequest) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
