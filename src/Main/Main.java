import Graph.*;
import Boruvki.*;

public class Main {
    public static void main(String[] arg) {
	AdjList list = new AdjList();

	list.readGraph();
	list.showGraph();
	System.out.println("\nremoved:\n");
	list.removeVertex(1);
	list.showGraph();

    }
}
