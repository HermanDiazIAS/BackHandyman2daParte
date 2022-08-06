package com.ias.omega.BackHandyman.technicals.aplication.services;

import com.ias.omega.BackHandyman.infrastructure.models.technicals.TechnicalDTO;
import com.ias.omega.BackHandyman.technicals.aplication.models.Technicals;
import com.ias.omega.BackHandyman.technicals.aplication.ports.input.QueryByIdTechnical;
import com.ias.omega.BackHandyman.technicals.aplication.ports.output.TechnicalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class QueryByIdTechnicalService implements QueryByIdTechnical {

    @Autowired
    private TechnicalsRepository repository;

    @Override
    public TechnicalDTO execute(String s) {
        TechnicalDTO dto= null;
        Optional<Technicals> optionalTec =  repository.queryTechnicalById(s);
        if (optionalTec.isPresent()){
            dto = TechnicalDTO.fromToDomain(optionalTec.get());
        }
        return dto;
    }

}
