package AlgoritmosGrafos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph<E> {
	ArrayList<Node<E>> listNodes = new ArrayList<Node<E>>();

	public Graph() {
	}

	public Node<E> addNode(E e) {
		Node<E> node = new Node<E>(e);
		listNodes.add(node);
		return node;
	}

	public void addVertex(E e) {
		Node<E> node = new Node<E>(e);
		listNodes.add(node);
	}

	public void LinkNodes(Node<E> node1, Node<E> node2) {
		node1.AddVecino(node2);
		node2.AddVecino(node1);
	}

	public void addEdge(E nodo1, E nodo2) {
		Node<E> n1 = null;
		for (Node<E> node : listNodes) {
			if (node.value.equals(nodo1)) {
				n1 = node;
			}
		}

		Node<E> n2 = null;
		for (Node<E> node : listNodes) {
			if (node.value.equals(nodo2)) {
				n2 = node;
			}
		}
		LinkNodes(n1, n2);
	}

	public ArrayList<E> DFS() {
		return DFS(listNodes.get(0));
	}

	public ArrayList<E> DFS(Node<E> nodoInicial) {
		ArrayList<E> visited = new ArrayList<E>();
		Stack<Stack<Node<E>>> stackNodesAnteriores = new Stack<Stack<Node<E>>>();
		Stack<Node<E>> stack = new Stack<Node<E>>();
		for (Node<E> n : nodoInicial.vecinos) {
			stack.push(n);
		}
		visited.add(nodoInicial.value);
		stackNodesAnteriores.push(stack);

		while (!stackNodesAnteriores.isEmpty()) {
			if (stackNodesAnteriores.peek().isEmpty()) {
				stackNodesAnteriores.pop();
			} else if (!visited.contains(stackNodesAnteriores.peek().peek().value)) {
				Stack<Node<E>> stackVecinos = stackNodesAnteriores.peek();
				visited.add(stackVecinos.peek().value);
				Stack<Node<E>> stack2 = new Stack<Node<E>>();

				for (Node<E> n : stackVecinos.peek().vecinos) {
					stack2.push(n);
				}
				stackVecinos.pop();
				stackNodesAnteriores.push(stack2);
			} else {
				stackNodesAnteriores.peek().pop();
			}
		}
		return visited;
	}

	public ArrayList<E> DFS2(Node<E> nodoInicial) {
		ArrayList<E> visited = new ArrayList<E>();
		Stack<Node<E>> stackNodesAnteriores = new Stack<Node<E>>();
		stackNodesAnteriores.push(nodoInicial);
		while (!stackNodesAnteriores.isEmpty()) {
			Node<E> nodoActual = stackNodesAnteriores.pop();
			if (!visited.contains(nodoActual.value)) {
				visited.add(nodoActual.value);
				for (Node<E> n : nodoActual.vecinos) {
					if (!visited.contains(n)) {
						stackNodesAnteriores.push(n);
					}
				}
			}
		}
		return visited;
	}

	public ArrayList<E> BFS() {
		return BFS(listNodes.get(0));
	}

	public ArrayList<E> BFS(Node<E> nodoInicial) {
		LinkedList<Node<E>> queue = new LinkedList<Node<E>>();
		ArrayList<E> visited = new ArrayList<E>();

		queue.add(nodoInicial);
		visited.add(nodoInicial.value);

		while (!queue.isEmpty()) {
			for (Node<E> vecino : queue.poll().vecinos) {
				if (!visited.contains(vecino)) {
					visited.add(vecino.value);
					queue.add(vecino);
				}
			}
		}
		return visited;
	}

	public boolean Bipartito(Node<E> nodoInicial) {
		LinkedList<Node<E>> queue = new LinkedList<Node<E>>();
		boolean[] visited = new boolean[this.listNodes.size()];
		boolean[] colors = new boolean[this.listNodes.size()];

		queue.add(nodoInicial);
		visited[0] = true;

		while (!queue.isEmpty()) {
			for (Node<E> vecino : queue.poll().vecinos) {
				int i = 0;
				for (; i < listNodes.size(); i++) {
					if (listNodes.get(i).value.equals(vecino.value)) {
//						break
					}
				}
//        		if(!visited.contains(vecino)) {
//        			visited.add(vecino.value);
//        			queue.add(vecino);
//        		}
			}
		}
		return false;
	}

	public boolean B() {
		return B(listNodes.get(0));
	}

	public boolean B(Node<E> nodoInicial) {
		LinkedList<Node<E>> queue = new LinkedList<Node<E>>();
		ArrayList<E> visited = new ArrayList<E>();
		boolean[] colors = new boolean[this.listNodes.size()];

		queue.add(nodoInicial);
		visited.add(nodoInicial.value);
		colors[0] = true;

		boolean par = false;
		int nivelCantPar = 1;
		int nivelCantImpar = 0;

		while (!queue.isEmpty()) {
			for (Node<E> vecino : queue.poll().vecinos) {
				if (!visited.contains(vecino)) {
					visited.add(vecino.value);
					queue.add(vecino);
					if (par) {
						nivelCantPar++;
					} else {
						nivelCantImpar++;
					}
					colors[visited.size() - 1] = par;
				} else {
					if (par != colors[visited.indexOf(vecino)]) {
						return false;
					}
				}
			}
			if (!par) {
				nivelCantPar--;
				if (nivelCantPar == 0) {
					par = !par;
				}
			} else {
				nivelCantImpar--;
				if (nivelCantImpar == 0) {
					par = !par;
				}
			}
		}
		return true;
	}

	public boolean esBipartito() {
		return esBipartito(listNodes.get(0));
	}

	public boolean esBipartito(Node<E> nodoInicial) {
		LinkedList<Node<E>> colaNivelActual = new LinkedList<Node<E>>();
		LinkedList<Node<E>> colaNivelSiguiente = new LinkedList<Node<E>>();

		boolean par = false;
		ArrayList<E> visited = new ArrayList<E>();
		boolean[] colors = new boolean[this.listNodes.size()];

		colaNivelActual.add(nodoInicial);
		visited.add(nodoInicial.value);
		colors[0] = true;
		while (!(colaNivelActual.isEmpty() && colaNivelSiguiente.isEmpty())) {
			for (Node<E> vecino : colaNivelActual.poll().vecinos) {
				if (!visited.contains(vecino)) {
					visited.add(vecino.value);
					colaNivelSiguiente.add(vecino);
					colors[visited.size() - 1] = par;
				} else {
					if (par != colors[visited.indexOf(vecino)]) {
						return false;
					}
				}
			}
			if (colaNivelActual.isEmpty()) {
				par = !par;
				LinkedList<Node<E>> temp = colaNivelActual;
				colaNivelActual = colaNivelSiguiente;
				colaNivelSiguiente = temp;
			}
		}
		return true;
	}
}
