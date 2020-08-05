package com.ml.mvc.data.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the menus database table.
 * 
 */
@Entity
@NamedQuery(name="Menus.findAll", query="SELECT m FROM Menus m")
public class Menus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="id_padre")
	private Integer idPadre;

	@Column(name="nombre_nodo")
	private String nombreNodo;

	private String ventana;

	public Menus() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPadre() {
		return this.idPadre;
	}

	public void setIdPadre(Integer idPadre) {
		this.idPadre = idPadre;
	}

	public String getNombreNodo() {
		return this.nombreNodo;
	}

	public void setNombreNodo(String nombreNodo) {
		this.nombreNodo = nombreNodo;
	}

	public String getVentana() {
		return this.ventana;
	}

	public void setVentana(String ventana) {
		this.ventana = ventana;
	}

}