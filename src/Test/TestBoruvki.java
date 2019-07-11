package Test;

import Graph.*;
import Boruvki.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestBoruvki {
	private AbstractGraph graph = new AdjList();
	private Boruvki alg;
	private ArrayList<String> logs = new ArrayList<String>();
	@Test
	public void testBoruvkiNullInp()
	{
		alg = new Boruvki(null);
		assertNull(alg.boruvki(logs));
		
	}
	
	@Test
	public void testBoruvkiBadGraph()
	{

		graph.addEdge(new Edge(1,2,3));
		graph.addEdge(new Edge(2,3,4));
		graph.addEdge(new Edge(6,7,8));
		
		alg = new Boruvki(graph);
		assertNull(alg.boruvki(logs));
	}
	
	@Test
	public void testBoruvkiGoodGraph()
	{
		graph.addEdge(new Edge(1,2,3));
		graph.addEdge(new Edge(2,3,4));
		alg = new Boruvki(graph);
		assertNotNull(alg.boruvki(logs));
	}
	
	@Test
	public void testBoruvkiAnswer()
	{
		graph = new AdjList();
		graph.addEdge(new Edge(1,2,7));
		graph.addEdge(new Edge(1,4,4));
		
		graph.addEdge(new Edge(2,3,11));
		graph.addEdge(new Edge(2,5,10));
		graph.addEdge(new Edge(2,4,9));
		
		graph.addEdge(new Edge(3,5,5));
		
		
		graph.addEdge(new Edge(4,5,15));
		graph.addEdge(new Edge(4,6,6));
		
		graph.addEdge(new Edge(5,6,12));
		graph.addEdge(new Edge(5,7,8));
		
		graph.addEdge(new Edge(6,7,13));

		alg = new Boruvki(graph);
		ArrayList<AbstractGraph> steps = alg.boruvki(logs);
		ArrayList<Edge> answer = steps.get(3).getEdges();
		
		assertTrue(answer.size()==6);
		assertTrue(answer.contains(new Edge(2,5,10)));
		assertTrue(answer.contains(new Edge(1,4,4)));
		assertFalse(answer.contains(new Edge(4,5,15)));
		assertFalse(answer.contains(new Edge(5,6,12)));
	}
	

	
	
	
}
