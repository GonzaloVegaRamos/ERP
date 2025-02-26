package com.empresa.erp.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.erp.ventas.model.Venta;
import com.empresa.erp.ventas.service.VentaService;

@RestController
@RequestMapping("/ventas")
public class VentasController {

    @Autowired
    private VentaService servicio;

    @GetMapping
    public List<Venta> listarVentas() {
        return servicio.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Venta obtenerVenta(@PathVariable Long id) {
        return servicio.obtenerVentaPorId(id);
    }

    @PostMapping
    public Venta crearVenta(@RequestBody Venta venta) {
        return servicio.guardarVenta(venta);
    }

    @DeleteMapping("/{id}")
    public void eliminarVenta(@PathVariable Long id) {
        servicio.eliminarVenta(id);
    }

    @PutMapping("/{id}")
    public Venta actualizarVenta(@PathVariable Long id, @RequestBody Venta ventaActualizada) {
        return servicio.actualizarVenta(id, ventaActualizada);
    }

    @GetMapping("/paginado")
    public Page<Venta> listarVentasPaginadas(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return servicio.listarVentasPaginadas(page, size);
    }
}
