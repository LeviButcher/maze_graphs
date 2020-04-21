package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VertexGraphTest {

    @Test
    public void can_retrieve_vertex() {
        var x = new VertexGraph();
        var v = new Vertex(5);
        x.addVertex(v);
        var y = x.retrieveVertex(5);
        assertEquals(v.id, y.get().id);
    }

    @Test
    public void retrieve_none_when_not_in_graph() {
        var x = new VertexGraph();
        assertTrue(x.retrieveVertex(5).isEmpty());
    }

    @Test
    public void insert_can_not_add_duplicate() {
        var x = new VertexGraph();
        var v = new Vertex(5);
        x.addVertex(v);
        assertFalse(x.addVertex(v));
    }
}