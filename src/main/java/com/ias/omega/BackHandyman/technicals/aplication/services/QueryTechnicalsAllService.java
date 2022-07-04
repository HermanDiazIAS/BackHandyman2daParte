package com.ias.omega.BackHandyman.technicals.aplication.services;

import com.ias.omega.BackHandyman.infrastructure.models.technicals.TechnicalDTO;
import com.ias.omega.BackHandyman.technicals.aplication.models.Technicals;
import com.ias.omega.BackHandyman.technicals.aplication.ports.input.QueryAllTechnicals;
import com.ias.omega.BackHandyman.technicals.aplication.ports.output.TechnicalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class QueryTechnicalsAllService implements QueryAllTechnicals {

    @Autowired
    private TechnicalsRepository repository;

    @Override
    public List<TechnicalDTO> execute(Long aLong) {
        List<Technicals> technicalsList = repository.queryAllTechnicals();
        return technicalsList.stream().map(technicals -> TechnicalDTO.fromToDomain(technicals)).collect(Collectors.toList());
    }
}
