package modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import views.Estado;

@Entity
@Table(name = "reclamos")
public class Reclamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idreclamo")
	private int numero;
	@ManyToOne
	@JoinColumn(name = "documento")
	private Persona usuario;
	@ManyToOne
	@JoinColumn(name = "codigo")
	private Edificio edificio;
	private String ubicacion;
	private String descripcion;
	@ManyToOne
	@JoinColumn(name = "identificador")
	private Unidad unidad;
    @Enumerated(EnumType.STRING)
	private Estado estado;
	@OneToMany(mappedBy = "reclamo")
	private List<Imagen> imagenes;
	
	public Reclamo(Persona usuario, Edificio edificio, String ubicacion, String descripcion, Unidad unidad) {
		this.usuario = usuario;
		this.edificio = edificio;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.estado = Estado.nuevo;
		imagenes = new ArrayList<Imagen>();
	}

	public void agregarImagen(String direccion, String tipo) {
		Imagen imagen = new Imagen(direccion, tipo);
		imagenes.add(imagen);
		imagen.save(numero);
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Persona getUsuario() {
		return usuario;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public Estado getEstado() {
		return estado;
	}
	
	public List<Imagen> getImagenes(){
		return this.imagenes;
	}
	
	public void cambiarEstado(Estado estado) {
		this.estado = estado;
	}

	public void save() {
		
	}
	
	public void update() {
		
	}
}
