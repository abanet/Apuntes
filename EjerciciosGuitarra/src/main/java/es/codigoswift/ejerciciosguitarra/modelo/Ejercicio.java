package es.codigoswift.ejerciciosguitarra.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "Ejercicio")
public class Ejercicio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="codigoYoutube")
	private String codigoYoutube;
	
	@Column(name="activo")
	private Boolean activo;
	
	@Column(name="fechaCreacion")
	private Date fechaCreacion;
	
	@Column(name="fechaModificacion")
	private Date fechaModificacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	
	@PrePersist
	public void prePersist() {
		fechaModificacion = new Date();
	}
	
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Ejercicio [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", codigoYoutube="
				+ codigoYoutube + ", activo=" + activo + ", fechaCreacion=" + fechaCreacion + ", fechaModificacion="
				+ fechaModificacion + "]";
	}

	
}
