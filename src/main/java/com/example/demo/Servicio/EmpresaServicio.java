package com.example.demo.Servicio;

import java.util.List;

import com.example.demo.Modelo.Empresa;

public class EmpresaServicio {
	private List<Empresa> listEmpresas;
	
	
public List <Empresa> listAll (List <Empresa> lista){
	this.listEmpresas=lista;
	return this.listEmpresas;
}
}
