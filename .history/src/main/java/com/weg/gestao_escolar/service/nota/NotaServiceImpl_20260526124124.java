package com.weg.gestao_escolar.service.nota;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.gestao_escolar.dto.nota.NotaRequestDto;
import com.weg.gestao_escolar.dto.nota.NotaResponseDto;
import com.weg.gestao_escolar.mapper.NotaMapper;
import com.weg.gestao_escolar.repository.nota.NotaRepository;

@Service
public class NotaServiceImpl implements NotaService{

    private NotaMapper notaMapper;
    private NotaRepository notaRepository;

    public NotaServiceImpl(NotaMapper notaMapper, NotaRepository notaRepository)

    @Override
    public NotaResponseDto save(NotaRequestDto notaRequest) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public NotaRequestDto get(Long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public List<NotaRequestDto> getAll() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public NotaRequestDto update(Long id, NotaRequestDto notaRequest) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
