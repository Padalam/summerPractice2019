package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Представление в виде списка смежности
public class AdjList extends AbstractGraph {

    private ArrayList < Vertex > adjList = new ArrayList < Vertex > ();

    // кривовато
    public void readGraph() {
        Integer v1 = 0, v2 = 0, weight = 0;

        Scanner scan = new Scanner(System.in).useDelimiter("\\s");

        while (scan.hasNextInt()) {
            if (scan.hasNextInt())
                v1 = scan.nextInt();
            if (scan.hasNextInt())
                v2 = scan.nextInt();
            if (scan.hasNextInt())
                weight = scan.nextInt();

            addEdge(new Edge(v1, v2, weight));
        }
    }

    public void showGraph() {

        for (Vertex vert: adjList) {
            System.out.println("vertex: " + vert.v);
            for (Integer neighbour: vert.edge.keySet()) {
                System.out.println("[neighbour: " + neighbour + ", edge: " + vert.edge.get(neighbour) + "]");
            }
        }
    }

    @Override
    public boolean addVertex(int v) {
        if (adjList.contains(new Vertex(v))) return false;

        adjList.add(new Vertex(v));
        return true;
    }

    @Override
    public boolean addEdge(Edge e) {

        if (!adjList.contains(new Vertex(e.v1))) {
            addVertex(e.v1);
        }


	if (!adjList.contains(new Vertex(e.v2))) {
	    addVertex(e.v2);
	}

        if (adjList.get(adjList.indexOf(new Vertex(e.v1))).edge.containsKey(e.v2)) return false;


        adjList.get(adjList.indexOf(new Vertex(e.v1))).edge.put(e.v2, e.weight);
        adjList.get(adjList.indexOf(new Vertex(e.v2))).edge.put(e.v1, e.weight);

        return true;
    }

    @Override
    public boolean removeVertex(int v) {
	Vertex toRemove = new Vertex(v);
        if (!adjList.contains(toRemove))
	{
		return false;
	}

	for (Integer vert : adjList.get(adjList.indexOf(toRemove)).edge.keySet())
	{
		adjList.get(adjList.indexOf(new Vertex(vert.intValue()))).edge.remove(toRemove.v);
	}

        adjList.remove(toRemove);
        return true;
    }

    @Override
    public boolean removeEdge(Edge e) {
	removeVertex(e.v1);
	removeVertex(e.v2);

        return true;
    }

    @Override
    public Vertex isExistV(int v) {
        return adjList.get(adjList.indexOf(new Vertex(v)));
    }

    @Override
    public Edge isExistE(int v1, int v2) {
        if (isExistV(v1) != null && isExistV(v2) != null) {
            Integer i = adjList.get(adjList.indexOf(new Vertex(v1))).edge.get(v2);

            return i == null ? null : new Edge(v1, v2, i.intValue());
        }
        return null;
    }


    @Override
    public void clear() {
        adjList = new ArrayList < Vertex > ();
    }

    @Override
    public ArrayList < Integer > getVertexes() {
        ArrayList < Integer > verts = new ArrayList < Integer > ();

        for (Vertex vert: adjList) {
            verts.add(vert.v);
        }

        return verts;
    }

    @Override
    public ArrayList < Edge > getEdges() {
        ArrayList < Edge > edges = new ArrayList < Edge > ();

        for (Vertex vert: adjList) {
            for (Map.Entry edge: vert.edge.entrySet()) {
                Edge isDuple = new Edge((int) edge.getKey(), vert.v, (int) edge.getValue());

                if (!edges.contains(isDuple)) {
                    edges.add(new Edge(vert.v, (int) edge.getKey(), (int) edge.getValue()));
                }
            }
        }

        return edges;

    }
}
