package com.sharito.demo.fruteria.dto;

public class FrutaDto {

	private String nombre;
	private int precio;
	private Integer id;

	public FrutaDto() {
		super();
	}

	public FrutaDto(String nombre, int precio, Integer id) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
