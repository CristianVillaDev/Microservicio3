package com.ubosque.ventas;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubosque.ventasDAO.VentasDAO;
import com.ubosque.ventasDTO.Ventas;

@RestController
@CrossOrigin(origins = "*")
@ComponentScan(basePackages = { "com.ubosque.ventasDAO" })
@RequestMapping("/ventas")

public class VentasController {

	@PostMapping("/crear")
	public boolean crear(@RequestBody Ventas venta) {
		boolean estado = false;
		VentasDAO ventasDAO = new VentasDAO();
		estado = (boolean) ventasDAO.crear(venta);
		return estado;
	}
	
	@RequestMapping("/codigo")
	public int traerCodigo () {
		VentasDAO codigo = new VentasDAO();
		return codigo.traerCodigo();
	}
}
	
