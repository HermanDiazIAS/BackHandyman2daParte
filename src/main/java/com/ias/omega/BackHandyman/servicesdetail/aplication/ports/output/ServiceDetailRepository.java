package com.ias.omega.BackHandyman.servicesdetail.aplication.ports.output;

import com.ias.omega.BackHandyman.services.aplication.models.ServicesClient;
import com.ias.omega.BackHandyman.servicesdetail.aplication.models.ServicesDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ServiceDetailRepository extends JpaRepository<ServicesDetail,Long> {
    @Query(nativeQuery = true,value = "select * from register_service where id_technical = ?1 and (start_date >= ?2 and end_date <= ?3)")
    public List<ServicesDetail> queryAllServicesByTechinicalAndDate(String idTechnical, Date startDate, Date endDate);

    @Query(nativeQuery = true,value = "select * from register_service where id_service = ?1 and `status` = 1")
    public List<ServicesDetail> validateServiceCompleted(Integer IdService);
}
