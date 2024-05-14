package fp.nobel;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Premios {
	void añadirPremio(Premio premio);
    Set<Premio> obtenerPremiosDeGenero(String genero);
    long calcularNumeroPremiadosMasJovenesDe(int edad);
    Map<String, Integer> calcularNumeroPremiosPorGenero();
    Map<Integer, List<Premio>> calcularPremiosPorEdad();
    Map<String, Double> calcularMediaEdadPorCategoria();
}