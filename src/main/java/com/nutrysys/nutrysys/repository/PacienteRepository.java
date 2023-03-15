package com.nutrysys.nutrysys.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.nutrysys.nutrysys.model.Paciente;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin
@Repository 
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{
    
}
