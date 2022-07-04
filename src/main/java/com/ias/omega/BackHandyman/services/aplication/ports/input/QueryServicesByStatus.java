package com.ias.omega.BackHandyman.services.aplication.ports.input;
import com.ias.omega.BackHandyman.commons.UseCase;
import com.ias.omega.BackHandyman.infrastructure.models.services.ServiceDTO;
import java.util.List;

public interface QueryServicesByStatus extends UseCase<Integer, List<ServiceDTO>> {

}
