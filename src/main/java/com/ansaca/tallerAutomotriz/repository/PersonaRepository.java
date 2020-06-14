package com.ansaca.tallerAutomotriz.repository;

import com.ansaca.tallerAutomotriz.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {

    PersonaEntity findByNumeroIdentificacion(Long numeroIdentificacion);
}
