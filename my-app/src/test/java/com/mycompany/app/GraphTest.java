package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GraphTest {

    @Test
    public void test() {
        var g = new Graph(10);
        g.addEdge(new Edge(0, 5, 10));
    }

    @Test
    public void addVertex() {
        var g = new Graph(5);
        var newVertex = g.addVertex();
        assertEquals((Integer) 5, newVertex);
        assertEquals(6, g.getNumVertices());
        assertTrue(g.getAdjList(5) != null);
    }

    @Test
    public void isEdge() {
        var g = new Graph(5);
        g.addEdge(new Edge(0, 1, 50));
        assertTrue(g.isEdge(0, 1));
        assertTrue(g.isEdge(1, 0));
        assertTrue(!g.isEdge(0, 2));
    }
}