package com.mycompany.app;

import java.util.List;

public class Vertex {
    public List<Vertex> edges;
    public int id;

    public Vertex(int identifier) {
        id = identifier;
    }
}

public class Edge {
    public Vertex a;
    public Vertex b;

    public Edge() {

    }
}