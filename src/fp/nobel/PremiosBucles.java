package fp.nobel;

import java.util.ArrayList;
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
	public Map<String, Long> calcularNumeroPremiosPorGenero() {
		Map<String, Long> res = new HashMap<String, Long>();
		
		for (Premio p: premios) {
			String genero = p.genero().name();
			if(!res.containsKey(genero)) {
				res.put(genero, (long) 0);
			}
			res.put(genero, res.get(genero) + 1);
		}
		
		return res;
	}

	@Override
	public Map<Integer, List<Premio>> calcularPremiosPorEdad() {
		Map<Integer, List<Premio>> res = new HashMap<Integer, List<Premio>>();
		
		for (Premio p: premios) {
			Integer edad = p.edadPremiado();
			if(!res.containsKey(edad)) {
				res.put(edad, new ArrayList<Premio>());
			}
			res.get(edad).add(p);
		}
		
		return res;
	}

	@Override
	public Map<String, Double> calcularMediaEdadPorCategoria() {
		Map<String, List<Integer>> edadesPorCategoria = new HashMap<String, List<Integer>>();
		for (Premio p: premios) {
			String cat = p.categoria();
			
			if (!edadesPorCategoria.containsKey(cat)) {
				edadesPorCategoria.put(cat, new ArrayList<Integer>());
			}
			edadesPorCategoria.get(cat).add(p.edadPremiado());
		}
		
		Map<String, Double> res = new HashMap<String, Double>();
		for (Map.Entry<String, List<Integer>> entry : edadesPorCategoria.entrySet()) {
	        String categoria = entry.getKey();
	        List<Integer> edades = entry.getValue();
	        double mediaEdad = 0.0;
	        for (int edad : edades) {
	            mediaEdad += edad;
	        }
	        mediaEdad /= edades.size();
	        res.put(categoria, mediaEdad);
	    }
		return res;
	}
}