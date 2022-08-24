package com.ias.omega.BackHandyman.servicesdetail.aplication.ports.output;

import com.ias.omega.BackHandyman.services.aplication.models.ServicesClient;
import com.ias.omega.BackHandyman.servicesdetail.aplication.models.ServicesDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceDetailRepository extends JpaRepository<ServicesDetail,Long> {
    @Query(nativeQuery = true,value = "select * from register_service where id_technical = ?1 and (start_date >= ?2 and end_date <= ?3)")
    public List<ServicesDetail> queryAllServicesByTechinicalAndDate(String idTechnical, Date startDate, Date endDate);

    @Query(nativeQuery = true,value = "select * from register_service where id_service = ?1 and `status` = 1")
    public List<ServicesDetail> validateServiceCompleted(Integer IdService);

    @Query(value="select * from register_service r where r.id_technical = ?1",nativeQuery = true)
    public List<ServicesDetail> queryServices(String idTechnical);

    @Query(value="select r.* from register_service r where r.id_technical = :idTechnical and start_date >= :startDate and end_date <= :endDate",nativeQuery = true)
    public List<ServicesDetail> queryServices(String idTechnical, String startDate, String endDate);


}
