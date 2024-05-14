package fp.nobel;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class PremiosStream implements Premios {
	private Set<Premio> premios;
	
	public PremiosStream() {
		this.premios = new HashSet<Premio>();
	}
	
	public PremiosStream(Stream<Premio> premiosStream) {
        this.premios = new HashSet<>();
        premiosStream.forEach(premios::add);
    }

	@Override
	public void añadirPremio(Premio premio) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<Premio> obtenerPremiosDeGenero(String genero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long calcularNumeroPremiadosMasJovenesDe(int edad) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Integer> calcularNumeroPremiosPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, List<Premio>> calcularPremiosPorEdad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> calcularMediaEdadPorCategoria() {
		// TODO Auto-generated method stub
		return null;
	}

}
