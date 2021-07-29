package com.example.demo.Modelo;


public class Empresa {
	private Long NroContrato;
	private String CUIT;
	private String DENOMINACION;
	private String DOMICILIO;
	private Long CODIGOPOSTAL;
	private String PRODUCTOR;
	public Long getNroContrato() {
		return NroContrato;
	}
	public void setNroContrato(Long nroContrato) {
		NroContrato = nroContrato;
	}
	public String getCUIT() {
		return CUIT;
	}
	public void setCUIT(String cUIT) {
		CUIT = cUIT;
	}
	public String getDENOMINACION() {
		return DENOMINACION;
	}
	public void setDENOMINACION(String dENOMINACION) {
		DENOMINACION = dENOMINACION;
	}
	public String getDOMICILIO() {
		return DOMICILIO;
	}
	public void setDOMICILIO(String dOMICILIO) {
		DOMICILIO = dOMICILIO;
	}
	public Long getCODIGOPOSTAL() {
		return CODIGOPOSTAL;
	}
	public void setCODIGOPOSTAL(Long cODIGOPOSTAL) {
		CODIGOPOSTAL = cODIGOPOSTAL;
	}
	public String getPRODUCTOR() {
		return PRODUCTOR;
	}
	public void setPRODUCTOR(String pRODUCTOR) {
		PRODUCTOR = pRODUCTOR;
	} 
	public String validarCampos() {
		String faltan="";
		if (this.getNroContrato()==null) {
			faltan="Nro Contrato";
		}
		if (this.getDENOMINACION()==null) {
			faltan=faltan + "-" + "Denominacion";
		}
		
		if (faltan.equals("")) {
			return faltan;
		}
		else
			{return "Faltan los campos: " + faltan;}
	}
	
	
	
	}
