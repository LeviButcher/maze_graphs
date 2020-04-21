package com.mycompany.app;

public interface IGraph {
    boolean isEmpty();

    int vertexCount();

    int edgeCount();

    boolean edgeExists(int vertexA, int vertexB);

    boolean addVertex(int vertex);

    boolean insertEdge(int vertexA, int VertexB);

    boolean removeVertex(int vertex);

    boolean removeEdge(int vertexA, int VertexB);

    int retrieveVertex(int vertexA);
}