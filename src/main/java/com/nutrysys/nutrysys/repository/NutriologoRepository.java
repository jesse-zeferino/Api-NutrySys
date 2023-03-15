package com.nutrysys.nutrysys.repository;
import org.springframework.data.jpa.repository.JpaRepository;




import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.nutrysys.nutrysys.model.Nutriologo;
@CrossOrigin
@Repository 
public interface NutriologoRepository extends JpaRepository<Nutriologo, Integer>{
    
}
