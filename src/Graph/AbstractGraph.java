package Graph;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractGraph {

    abstract public void readGraph();

    abstract public void showGraph();

    abstract public boolean addVertex(int v);

    abstract public boolean addEdge(Edge e);

    abstract public boolean removeVertex(Vertex v);

    abstract public boolean removeEdge(Edge e);

    abstract public Vertex isExistV(int v);

    abstract public Edge isExistE(int v1, int v2);

    abstract public void clear();

    abstract public ArrayList < Integer > getVertexes();

    abstract public ArrayList < Edge > getEdges();


}
