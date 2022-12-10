package com.dltech.repository;

import com.dltech.model.SalidaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalidaDetalleRepository extends JpaRepository<SalidaDetalle,Long> {
    public List<SalidaDetalle> getSalidaDetalleBySalidaIdSalida(Long salida_id);
}
