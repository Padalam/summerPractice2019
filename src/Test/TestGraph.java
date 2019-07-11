package Test;

import Graph.*;
import Boruvki.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class TestGraph {

	private AbstractGraph gr = new AdjList();
	private int size;
	private ArrayList<Edge> edg;
	
	
	@Test
	public void testAddVertex()
	{
		ArrayList<Integer> vrtx = gr.getVertexes();
		size = vrtx.size();
		
		
		gr.addVertex(6);
		
		
		vrtx = gr.getVertexes();
		int currSize = vrtx.size();
		assertTrue(vrtx.contains(6));
		assertTrue(currSize==size+1);
	}
	
	
	@Test
	public void testRemoveVertex()
	{
		gr.removeVertex(1);
		ArrayList<Integer> vrtx = gr.getVertexes();
		
		assertFalse(vrtx.contains(1));		
	}
	
	@Test
	public void testAddEdge()
	{

		gr.addEdge(new Edge(1,2,4));
		edg = gr.getEdges();
		
		assertTrue(edg.contains(new Edge(1,2,4)));
		assertFalse(edg.contains(new Edge(1,2,3)));
	}
	
	@Test
	public void testRemoveEdge()
	{
		gr.removeEdge(new Edge (1,2,4));
		edg = gr.getEdges();
		
		assertFalse(edg.contains(new Edge(1,2,4)));
	}
}
