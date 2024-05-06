package fp.nobel;

import java.util.Objects;

public record Premio(Integer año, String categoria, String nombre, String apellidos, Genero genero, Integer añoNacimiento, Integer edadPremiado) {

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, año, categoria, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Premio other = (Premio) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(año, other.año)
				&& Objects.equals(categoria, other.categoria) && Objects.equals(nombre, other.nombre);
	}
}
