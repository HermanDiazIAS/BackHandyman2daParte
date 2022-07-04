package com.ias.omega.BackHandyman.technicals.aplication.ports.output;

import com.ias.omega.BackHandyman.servicesdetail.aplication.models.ServicesDetail;
import com.ias.omega.BackHandyman.technicals.aplication.models.Technicals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TechnicalsRepository extends JpaRepository<Technicals, Long> {
    @Query(nativeQuery = true,value = "select * from technicals where id = ?1")
    public Optional<Technicals> queryTechnicalById(String IdTechnical);

    @Query(nativeQuery = true,value = "select id,name_technical,if(type_document ='Cédula de extrangería','CE',type_document ) as type_document from technicals ORDER BY id")
    public List<Technicals> queryAllTechnicals();
}
