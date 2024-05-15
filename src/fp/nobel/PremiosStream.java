package fp.nobel;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
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
		this.premios.add(premio);
	}

	@Override
	public Set<Premio> obtenerPremiosDeGenero(String genero) {
		return premios.stream()
				.filter(x -> x.genero().equals(genero))
				.collect(Collectors.toSet());
	}

	@Override
	public long calcularNumeroPremiadosMasJovenesDe(int edad) {
		return premios.stream()
				.filter(x -> x.edadPremiado() < edad)
				.count();
	}

	@Override
	public Map<String, Long> calcularNumeroPremiosPorGenero() {
	    return premios.stream()
	            .collect(Collectors.groupingBy(p -> p.genero().name(), Collectors.counting()));
	}

	@Override
	public Map<Integer, List<Premio>> calcularPremiosPorEdad() {
		return premios.stream()
				.collect(Collectors.groupingBy(Premio::edadPremiado));
	}

	@Override
	public Map<String, Double> calcularMediaEdadPorCategoria() {
		return premios.stream()
	            .collect(Collectors.groupingBy(Premio::categoria,
	                    Collectors.averagingInt(Premio::edadPremiado)));
	}

}
