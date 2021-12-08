package com.ubosque.ventasDTO;

public class DetalleVenta {

	private double cantidadProducto;
	private int codigoProducto;
	private double valorTotal;
	private double valorVenta;
	private double valorIva;

	public double getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(double cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(double valorVenta) {
		this.valorVenta = valorVenta;
	}

	public double getValorIva() {
		return valorIva;
	}

	public void setValorIva(double valorIva) {
		this.valorIva = valorIva;
	}

}
