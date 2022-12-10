package com.dltech.repository;

import com.dltech.model.TipoOperacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoOperacionRepository extends JpaRepository<TipoOperacion,Long> {
}
