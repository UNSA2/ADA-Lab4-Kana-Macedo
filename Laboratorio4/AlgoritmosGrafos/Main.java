package AlgoritmosGrafos;

public class Main {
	public static void main(String[] args) {

		Graph<Integer> g = new Graph<Integer>();
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);

		g.addVertex(5);
		g.addVertex(6);
		g.addVertex(7);
		g.addVertex(8);

		g.addEdge(1, 5);
		g.addEdge(1, 6);
		g.addEdge(1, 7);
		g.addEdge(1, 8);

		g.addEdge(2, 5);
		g.addEdge(2, 6);
		g.addEdge(2, 7);
		g.addEdge(2, 8);

		g.addEdge(3, 5);
		g.addEdge(3, 6);
		g.addEdge(3, 7);
		g.addEdge(3, 8);

		g.addEdge(4, 5);
		g.addEdge(4, 6);
		g.addEdge(4, 7);
		g.addEdge(4, 8);

		System.out.println("Es bipartito ? (si)");
		System.out.println(g.esBipartito());

		System.out.println("\nEs bipartito ? (no)");
		g.addEdge(1, 2);
		System.out.println(g.esBipartito());

		System.out.println("\nEjemplo 1");

		Graph<Integer> test = new Graph<Integer>();
		Node<Integer> t0 = test.addNode(0);
		Node<Integer> t1 = test.addNode(1);
		Node<Integer> t2 = test.addNode(2);
		Node<Integer> t3 = test.addNode(3);
		Node<Integer> t4 = test.addNode(4);
		Node<Integer> t5 = test.addNode(5);
		Node<Integer> t6 = test.addNode(6);
		Node<Integer> t7 = test.addNode(7);
		Node<Integer> t8 = test.addNode(8);
		Node<Integer> t9 = test.addNode(9);

		test.LinkNodes(t0, t1);
		test.LinkNodes(t1, t2);
		test.LinkNodes(t1, t3);
		test.LinkNodes(t0, t4);
		test.LinkNodes(t4, t5);
		test.LinkNodes(t4, t3);
		test.LinkNodes(t3, t5);
		test.LinkNodes(t0, t6);
		test.LinkNodes(t6, t7);
		test.LinkNodes(t6, t8);
		test.LinkNodes(t2, t9);

		System.out.println("DFS " + test.DFS());
		System.out.println("BFS " + test.BFS());

		Graph<Integer> test0 = new Graph<Integer>();
		Graph<Integer> test1 = new Graph<Integer>();
		Graph<Integer> test2 = new Graph<Integer>();
		// Grafo de ramificaciones largas
		test0.addVertex(0);
		test0.addVertex(1);
		test0.addVertex(2);
		test0.addVertex(3);
		test0.addVertex(4);
		test0.addVertex(5);
		test0.addVertex(6);
		test0.addVertex(7);
		test0.addVertex(8);
		test0.addVertex(9);
		test0.addVertex(10);
		test0.addVertex(11);
		test0.addVertex(12);
		test0.addVertex(13);
		test0.addVertex(14);
		test0.addVertex(15);
		test0.addVertex(16);
		test0.addVertex(17);
		test0.addVertex(18);
		test0.addVertex(19);
		test0.addVertex(20);

		test0.addEdge(0, 1);
		test0.addEdge(1, 2);
		test0.addEdge(2, 3);
		test0.addEdge(3, 4);
		test0.addEdge(4, 5);
		test0.addEdge(5, 6);
		test0.addEdge(0, 7);
		test0.addEdge(7, 8);
		test0.addEdge(8, 9);
		test0.addEdge(10, 11);
		test0.addEdge(12, 13);
		test0.addEdge(13, 14);
		test0.addEdge(0, 15);
		test0.addEdge(15, 16);
		test0.addEdge(16, 17);
		test0.addEdge(17, 18);
		test0.addEdge(18, 19);
		test0.addEdge(19, 20);
		// Grafo arbol binario
		test1.addVertex(0);
		test1.addVertex(1);
		test1.addVertex(2);
		test1.addVertex(3);
		test1.addVertex(4);
		test1.addVertex(5);
		test1.addVertex(6);
		test1.addVertex(7);
		test1.addVertex(8);
		test1.addVertex(9);
		test1.addVertex(10);
		test1.addVertex(11);
		test1.addVertex(12);
		test1.addVertex(13);
		test1.addVertex(14);

		test1.addEdge(0, 1);
		test1.addEdge(1, 2);
		test1.addEdge(1, 3);
		test1.addEdge(2, 4);
		test1.addEdge(2, 5);
		test1.addEdge(3, 6);
		test1.addEdge(3, 7);
		test1.addEdge(0, 8);
		test1.addEdge(8, 9);
		test1.addEdge(9, 11);
		test1.addEdge(9, 12);
		test1.addEdge(8, 10);
		test1.addEdge(10, 13);
		test1.addEdge(10, 14);
		// Grafo fuertemente conexo
		test2.addVertex(0);
		test2.addVertex(1);
		test2.addVertex(2);
		test2.addVertex(3);
		test2.addVertex(4);
		test2.addVertex(5);
		test2.addVertex(6);

		test2.addEdge(0, 1);
		test2.addEdge(0, 2);
		test2.addEdge(0, 3);
		test2.addEdge(0, 4);
		test2.addEdge(0, 5);
		test2.addEdge(0, 6);
		test2.addEdge(1, 2);
		test2.addEdge(1, 3);
		test2.addEdge(1, 4);
		test2.addEdge(1, 5);
		test2.addEdge(1, 6);
		test2.addEdge(2, 3);
		test2.addEdge(2, 4);
		test2.addEdge(2, 5);
		test2.addEdge(2, 6);
		test2.addEdge(3, 4);
		test2.addEdge(3, 5);
		test2.addEdge(3, 6);
		test2.addEdge(4, 5);
		test2.addEdge(4, 6);
		test2.addEdge(5, 6);

		// Ejecución

//		System.out.println(test0.listNodes);

		System.out.println("\nRamificaciones largas");
		System.out.println("\nDFS :");
		System.out.println(test0.DFS());
		System.out.println("\nBFS :");
		System.out.println(test0.BFS());

		System.out.println("\nArbol binario");
		System.out.println("\nDFS :");
		System.out.println(test1.DFS());
		System.out.println("\nBFS :");
		System.out.println(test1.BFS());

		System.out.println("\nFuertemente Conexo");
		System.out.println("\nDFS :");
		System.out.println(test2.DFS());
		System.out.println("\nBFS :");
		System.out.println(test2.BFS());

	}
}
