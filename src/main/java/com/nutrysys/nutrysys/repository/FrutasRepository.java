package com.nutrysys.nutrysys.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.nutrysys.nutrysys.model.Frutas;
@CrossOrigin
@Repository
public interface FrutasRepository extends JpaRepository<Frutas, Integer>{
    
}
