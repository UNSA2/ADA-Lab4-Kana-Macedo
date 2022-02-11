package AlgoritmosGrafos;
import java.util.ArrayList;

public class Node<E> {
	E value;
	ArrayList<Node<E>> vecinos = new ArrayList<Node<E>>();
	public Node(E e){
		this.value = e;
	}
	public void AddVecino(Node<E> e){
		vecinos.add(e);
	}
	public boolean equals(Object o) {
		return value.equals(o);
	}
}