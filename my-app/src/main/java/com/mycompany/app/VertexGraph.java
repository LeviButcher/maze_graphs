package com.mycompany.app;

import java.util.ArrayList;
import java.util.Optional;

public class VertexGraph {
    ArrayList<Vertex> vertices;

    public VertexGraph() {
        vertices = new ArrayList<>();
    }

    public boolean addVertex(Vertex v) {
        if (retrieveVertex(v.id).isEmpty())
            return vertices.add(v);
        return false;
    }

    public boolean isConnected(Vertex v, Vertex b) {
        return false;
    }

    public boolean deleteVertex(Vertex v) {
        return false;
    }

    public Optional<Vertex> retrieveVertex(int id) {
        return vertices.stream().filter(x -> x.id == id).findFirst();
    }
}