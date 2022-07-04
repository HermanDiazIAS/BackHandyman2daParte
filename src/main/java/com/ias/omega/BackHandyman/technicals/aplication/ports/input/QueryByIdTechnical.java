package com.ias.omega.BackHandyman.technicals.aplication.ports.input;

import com.ias.omega.BackHandyman.commons.UseCase;
import com.ias.omega.BackHandyman.infrastructure.models.technicals.TechnicalDTO;
import com.ias.omega.BackHandyman.technicals.aplication.models.Technicals;

public interface QueryByIdTechnical extends UseCase<Long, TechnicalDTO> {

}
