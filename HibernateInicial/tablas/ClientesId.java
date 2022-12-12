package tablas;
// Generated 12 dic 2022 11:10:18 by Hibernate Tools 5.6.12.Final

/**
 * ClientesId generated by hbm2java
 */
public class ClientesId implements java.io.Serializable {

	private int id;
	private String nombre;
	private String apellidos;
	private int telefono;
	private String direccion;
	private String email;
	private boolean vip;

	public ClientesId() {
	}

	public ClientesId(int id, String nombre, String apellidos, int telefono, String direccion, String email,
			boolean vip) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
		this.vip = vip;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isVip() {
		return this.vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ClientesId))
			return false;
		ClientesId castOther = (ClientesId) other;

		return (this.getId() == castOther.getId())
				&& ((this.getNombre() == castOther.getNombre()) || (this.getNombre() != null
						&& castOther.getNombre() != null && this.getNombre().equals(castOther.getNombre())))
				&& ((this.getApellidos() == castOther.getApellidos()) || (this.getApellidos() != null
						&& castOther.getApellidos() != null && this.getApellidos().equals(castOther.getApellidos())))
				&& (this.getTelefono() == castOther.getTelefono())
				&& ((this.getDireccion() == castOther.getDireccion()) || (this.getDireccion() != null
						&& castOther.getDireccion() != null && this.getDireccion().equals(castOther.getDireccion())))
				&& ((this.getEmail() == castOther.getEmail()) || (this.getEmail() != null
						&& castOther.getEmail() != null && this.getEmail().equals(castOther.getEmail())))
				&& (this.isVip() == castOther.isVip());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result + (getNombre() == null ? 0 : this.getNombre().hashCode());
		result = 37 * result + (getApellidos() == null ? 0 : this.getApellidos().hashCode());
		result = 37 * result + this.getTelefono();
		result = 37 * result + (getDireccion() == null ? 0 : this.getDireccion().hashCode());
		result = 37 * result + (getEmail() == null ? 0 : this.getEmail().hashCode());
		result = 37 * result + (this.isVip() ? 1 : 0);
		return result;
	}

}
