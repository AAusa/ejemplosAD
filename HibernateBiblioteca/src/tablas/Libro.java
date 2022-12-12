package tablas;
// Generated 12 dic 2022 12:15:42 by Hibernate Tools 5.6.12.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Libro generated by hbm2java
 */
public class Libro implements java.io.Serializable {

	private int codigo;
	private String titulo;
	private String autor;
	private String editorial;
	private Integer agno;
	private String isbn;
	private Integer nejemplares;
	private Integer npaginas;
	private Set prestamos = new HashSet(0);

	public Libro() {
	}

	public Libro(int codigo, String isbn) {
		this.codigo = codigo;
		this.isbn = isbn;
	}

	public Libro(int codigo, String titulo, String autor, String editorial, Integer agno, String isbn,
			Integer nejemplares, Integer npaginas, Set prestamos) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.agno = agno;
		this.isbn = isbn;
		this.nejemplares = nejemplares;
		this.npaginas = npaginas;
		this.prestamos = prestamos;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return this.editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Integer getAgno() {
		return this.agno;
	}

	public void setAgno(Integer agno) {
		this.agno = agno;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getNejemplares() {
		return this.nejemplares;
	}

	public void setNejemplares(Integer nejemplares) {
		this.nejemplares = nejemplares;
	}

	public Integer getNpaginas() {
		return this.npaginas;
	}

	public void setNpaginas(Integer npaginas) {
		this.npaginas = npaginas;
	}

	public Set getPrestamos() {
		return this.prestamos;
	}

	public void setPrestamos(Set prestamos) {
		this.prestamos = prestamos;
	}

}
