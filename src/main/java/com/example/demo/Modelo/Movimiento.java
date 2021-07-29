package com.example.demo.Modelo;

public class Movimiento {
	private Long NroContrato;
	private Double SaldoCtaCte;
	private String Concepto;
	private Double Importe;
	public Long getNroContrato() {
		return NroContrato;
	}
	public void setNroContrato(Long nroContrato) {
		NroContrato = nroContrato;
	}
	public Double getSaldoCtaCte() {
		return SaldoCtaCte;
	}
	public void setSaldoCtaCte(Double saldoCtaCte) {
		SaldoCtaCte = saldoCtaCte;
	}
	public String getConcepto() {
		return Concepto;
	}
	public void setConcepto(String concepto) {
		Concepto = concepto;
	}
	public Double getImporte() {
		return Importe;
	}
	public void setImporte(Double importe) {
		Importe = importe;
	}
	
	public String validarCampos() {
		String faltan="";
		if (this.getSaldoCtaCte()==null) {
			faltan="Saldo Cta Cte";
		}
		if (this.getConcepto()==null) {
			faltan=faltan + "-" + "Concepto";
		}
		if (this.getImporte()==null) {
			faltan=faltan + "-" + "Importe";
		}
		
		if (faltan.equals("")) {
			return faltan;
		}
		else
			{return "Faltan los campos: " + faltan;}
	}
	
	
}
