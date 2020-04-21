package com.mycompany.app;

import java.util.TreeMap;
import java.util.Vector;

public class Graph {
    private int numVertices;
    private int numEdges;

    private Vector<TreeMap<Integer, Integer>> adjList;

    public Graph(int n) {
        numVertices = n;
        numEdges = 0;
        adjList = new Vector<TreeMap<Integer, Integer>>();
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new TreeMap<Integer, Integer>());
        }
    }

    public int getNumVertices() {
        return numVertices;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public int getEdgeWeight(Integer v, Integer w) {
        return adjList.get(v).get(w);
    }

    public void addEdge(Integer v, Integer w, int wgt) {
        adjList.get(v).put(w, wgt);
        adjList.get(w).put(v, wgt);
        numEdges++;
    }

    public void addEdge(Edge e) {
        var v = e.getV();
        var w = e.getW();
        int weight = e.getWeight();
        addEdge(v, w, weight);
    }

    public void removeEdge(Edge e) {
        var v = e.getV();
        var w = e.getW();
        adjList.get(v).remove(w);
        adjList.get(w).remove(v);
        numEdges--;
    }

    public Edge findEdge(Integer v, Integer w) {
        int wgt = adjList.get(v).get(w);
        return new Edge(v, w, wgt);
    }

    TreeMap<Integer, Integer> getAdjList(Integer v) {
        return adjList.get(v);
    }

    public Integer addVertex() {
        adjList.add(new TreeMap<Integer, Integer>());
        return numVertices++;
    }

    public boolean isEdge(Integer v, Integer w) {
        if (v < 0 || w < 0 || v >= numVertices || w >= numVertices)
            return false;
        return adjList.get(v).containsKey(w) || adjList.get(w).containsKey(v);
    }
}