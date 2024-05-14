package fp.nobel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class PremiosBucles implements Premios {
	private Set<Premio> premios;
	
	public PremiosBucles() {
		this.premios = new HashSet<Premio>();
	}
	
	public PremiosBucles(Stream<Premio> premiosBucles) {
        this.premios = new HashSet<>();
        premiosBucles.forEach(premios::add);
    }

	@Override
	public void añadirPremio(Premio premio) {
		this.premios.add(premio);
	}

	@Override
	public Set<Premio> obtenerPremiosDeGenero(String genero) {
		Set<Premio> res = new HashSet<Premio>();
		
		for(Premio p: premios) {
			if (p.genero().equals(genero)) {
				res.add(p);
			}
		}
		return res;
	}

	@Override
	public long calcularNumeroPremiadosMasJovenesDe(int edad) {
		int res = 0;
		
		for (Premio p: premios) {
			if (p.edadPremiado() < edad)
				res++;
		}
		return res;
	}

	@Override
	public Map<String, Integer> calcularNumeroPremiosPorGenero() {
		Map<String, Integer> res = new HashMap<String, Integer>();
		
		for (Premio p: premios) {
			String genero = p.genero().name();
			if(!res.containsKey(genero)) {
				res.put(genero, 0);
			}
			res.put(genero, res.get(genero) + 1);
		}
		
		return res;
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
