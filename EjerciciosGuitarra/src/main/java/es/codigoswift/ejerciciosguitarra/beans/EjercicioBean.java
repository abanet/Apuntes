package es.codigoswift.ejerciciosguitarra.beans;

import java.util.Date;

import es.codigoswift.ejerciciosguitarra.modelo.Usuario;

public class EjercicioBean {

	private Integer id;
	private String nombre;
	private String descripcion;
	private String codigoYoutube;
	private Boolean activo;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Usuario usuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigoYoutube() {
		return codigoYoutube;
	}

	public void setCodigoYoutube(String codigoYoutube) {
		this.codigoYoutube = codigoYoutube;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "EjercicioBean [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", codigoYoutube="
				+ codigoYoutube + ", activo=" + activo + ", fechaCreacion=" + fechaCreacion + ", fechaModificacion="
				+ fechaModificacion + "]";
	}

}
