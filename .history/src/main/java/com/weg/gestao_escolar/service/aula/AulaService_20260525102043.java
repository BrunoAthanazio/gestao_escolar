package com.weg.gestao_escolar.service.aula;

import java.sql.SQLException;
import java.util.List;

import com.weg.gestao_escolar.dto.aula.AulaRequestDto;
import com.weg.gestao_escolar.dto.aula.AulaResponseDto;
import com.weg.gestao_escolar.model.Aula;

public interface AulaService {
    AulaResponseDto save(AulaRequestDto aulaRequest) throws SQLException;

    Aula get(Long id) throws SQLException;

    List<AulaRequestDto> getAll() throws SQLException;

    Aula update(Long id, Aula aulaRequest) throws SQLException;

    void delete(Long id) throws SQLException;
}
