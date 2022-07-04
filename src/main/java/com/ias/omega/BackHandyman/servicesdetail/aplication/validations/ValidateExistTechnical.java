package com.ias.omega.BackHandyman.servicesdetail.aplication.validations;

import com.ias.omega.BackHandyman.commons.UseCase;
import com.ias.omega.BackHandyman.technicals.aplication.models.Technicals;
import com.ias.omega.BackHandyman.technicals.aplication.ports.output.TechnicalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidateExistTechnical implements UseCase<String,Boolean> {
    @Autowired
    private TechnicalsRepository technicalsRepository;

    @Override
    public Boolean execute(String idTechnical) {
        Optional<Technicals> validateExistTechnical = technicalsRepository.queryTechnicalById(idTechnical);
        return !validateExistTechnical.isPresent() ? false: true;
    }
}
