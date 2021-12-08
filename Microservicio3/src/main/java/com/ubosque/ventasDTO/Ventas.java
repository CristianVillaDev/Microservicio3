package com.ubosque.ventasDTO;

import java.util.ArrayList;

public class Ventas {

	private int codigoVenta;
	private int cedulaCliente;
	private int cedulaUsuario;
	private double valor_venta;
	private double ivaVenta;
	private double total_venta;
	private ArrayList<DetalleVenta> detalleVentas;
	private String ciudad;
	
	public int getCodigoVenta() {
		return codigoVenta;
	}
	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}
	public int getCedulaCliente() {
		return cedulaCliente;
	}
	public void setCedulaCliente(int cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	public int getCedulaUsuario() {
		return cedulaUsuario;
	}
	public void setCedulaUsuario(int cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}
	public double getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}
	public double getIvaVenta() {
		return ivaVenta;
	}
	public void setIvaVenta(double ivaVenta) {
		this.ivaVenta = ivaVenta;
	}
	public double getTotal_venta() {
		return total_venta;
	}
	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}
	public ArrayList<DetalleVenta> getDetalleVentas() {
		return detalleVentas;
	}
	public void setDetalleVentas(ArrayList<DetalleVenta> detalleVentas) {
		this.detalleVentas = detalleVentas;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
	
	
}
