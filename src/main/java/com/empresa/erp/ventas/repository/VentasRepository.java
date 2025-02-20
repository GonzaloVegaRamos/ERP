package com.empresa.erp.ventas.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.empresa.erp.ventas.model.Venta;

@Repository
public interface VentasRepository extends JpaRepository<Venta, Long> {
    // Método para obtener todas las ventas paginadas
    Page<Venta> findAll(Pageable pageable);

    // Consulta personalizada para obtener ventas agrupadas por mes
    @Query("SELECT MONTH(v.fecha) AS mes, COUNT(v) AS cantidad FROM Venta v GROUP BY MONTH(v.fecha)")
    List<Object[]> obtenerVentasAgrupadasPorMes();

    // Consulta personalizada para obtener el total de ventas en el mes actual
    @Query("SELECT SUM(v.total) FROM Venta v WHERE YEAR(v.fecha) = YEAR(CURRENT_DATE) AND MONTH(v.fecha) = MONTH(CURRENT_DATE)")
    Double obtenerTotalVentasDelMes();
}
