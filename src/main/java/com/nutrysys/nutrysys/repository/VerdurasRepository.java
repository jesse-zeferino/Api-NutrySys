package com.nutrysys.nutrysys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.nutrysys.nutrysys.model.Verduras;
@CrossOrigin
@Repository
public interface VerdurasRepository extends JpaRepository<Verduras, Integer>{
    
}
