package com.dltech.repository;

import com.dltech.model.IngresoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngresoDetalleRepository extends JpaRepository<IngresoDetalle,Long> {
    public List<IngresoDetalle> getIngresoDetalleByIngresoIdIngreso(Long ingreso_id);
}
