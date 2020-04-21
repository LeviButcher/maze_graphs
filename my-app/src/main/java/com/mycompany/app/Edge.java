package com.mycompany.app;

public class Edge {
    private Integer v, w;
    private int weight;

    public Edge(Integer first, Integer second, int edgeWeight) {
        v = first;
        w = second;
        weight = edgeWeight;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}