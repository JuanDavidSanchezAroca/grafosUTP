package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;
import modelo.Nodo;

public class Controlador {

	private List<Pair<Nodo, List<Nodo>>> grafo;

	public Controlador() {
		this.grafo = new ArrayList<Pair<Nodo, List<Nodo>>>();
	}

	public void agregar(Nodo n) {
		validarPreviaExistencia(n);
		List<Nodo> nuevoVertice = new ArrayList<>();
		Pair<Nodo, List<Nodo>> pair = new Pair<Nodo, List<Nodo>>(n, nuevoVertice);
		grafo.add(pair);
	}

	public void validarPreviaExistencia(Nodo n) {
		grafo.forEach(elemento -> {
			if (elemento.getKey().getNumero() == n.getNumero()) {
				throw new RuntimeException("El numero ingresado ya existe");
			}
		});
	}

	public void agregarArista(int origen, int destino, boolean direccional, int peso) {
		Nodo nodoOrigen = buscarNodo(origen);
		Nodo nodoDestino = buscarNodo(destino);

		if (direccional) {
			agregarNodo(nodoOrigen, nodoDestino, peso);
		} else {
			agregarNodo(nodoOrigen, nodoDestino, peso);
			agregarNodo(nodoDestino, nodoOrigen, peso);
		}

	}

	public void agregarNodo(Nodo origen, Nodo destino, int peso) {
		for (Pair<Nodo, List<Nodo>> pair : grafo) {
			if (pair.getKey().getNumero() == origen.getNumero()) {
				validarPreviaExistenciaLista(pair.getValue(), destino);
				destino.setPeso(peso);
				pair.getValue().add(destino);
			}
		}
	}

	public void validarPreviaExistenciaLista(List<Nodo> nodo, Nodo destino) {
		for (Nodo item : nodo) {
			if (item.getNumero() == destino.getNumero()) {
				throw new RuntimeException("Ya existe la arista");
			}
		}
	}

	public Nodo buscarNodo(int n) {
		for (Pair<Nodo, List<Nodo>> pair : grafo) {
			if (pair.getKey().getNumero() == n) {
				return pair.getKey();
			}
		}
		throw new RuntimeException("El nodo no existe");
	}

	public void eliminarArista(int origen, int destino, boolean direccional) {
		Nodo nodoOrigen = buscarNodo(origen);
		Nodo nodoDestino = buscarNodo(destino);

		if (direccional) {
			eliminarArista(nodoOrigen, nodoDestino);
		} else {
			eliminarArista(nodoOrigen, nodoDestino);
			eliminarArista(nodoDestino, nodoOrigen);
		}
	}

	public void eliminarVertice(int nodo) {
		Nodo aux = buscarNodo(nodo);
		for (int i = 0; i < grafo.size(); i++) {
			if (grafo.get(i).getKey().getNumero() == aux.getNumero()) {
				grafo.remove(i);
			}
		}

		for (Pair<Nodo, List<Nodo>> pair : grafo) {
			eliminarArista(pair.getKey(), aux);
		}
	}

	public void eliminarArista(Nodo origen, Nodo destino) {
		for (Pair<Nodo, List<Nodo>> pair : grafo) {
			if (pair.getKey().getNumero() == origen.getNumero()) {
				for (int i = 0; i < pair.getValue().size(); i++) {
					if (pair.getValue().get(i).getNumero() == destino.getNumero()) {
						pair.getValue().remove(i);
					}
				}
			}
		}
	}

	public void shortPathGra(int nodoOrigen, int nodoDestino) {
		int rest = nodoOrigen;
		List<Integer> visitados = new ArrayList<Integer>();
		while (rest != nodoDestino) {
			for (Pair<Nodo, List<Nodo>> pair : grafo) {
				if (pair.getKey().getNumero() == rest) {
					int minimo = Integer.MAX_VALUE;
					for (Nodo nodoAux : pair.getValue()) {
						if (nodoAux.getNumero() < minimo && !visitados.contains(nodoAux.getNumero())) {
							minimo = nodoAux.getPeso();
							rest = nodoAux.getNumero();
						}
					}
					visitados.add(rest);
					break;
				}
			}
		}
	}

	public List<Pair<Nodo, List<Nodo>>> getGrafo() {
		return grafo;
	}
}
