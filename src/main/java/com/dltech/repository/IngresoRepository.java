package com.dltech.repository;

import com.dltech.model.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IngresoRepository extends JpaRepository<Ingreso, Long> {

}
