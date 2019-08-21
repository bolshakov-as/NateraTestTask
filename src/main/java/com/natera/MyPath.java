package com.natera;

import java.util.ArrayList;
import java.util.List;

public class MyPath {

    private List<MyEdge> edges = new ArrayList<>();
    private List<MyVertex> vertexList = new ArrayList<>();
    private boolean finished;

    public static MyPath of(MyPath path){
        MyPath newPath = new MyPath();
        newPath.edges.addAll(path.edges);
        newPath.vertexList.addAll(path.vertexList);
        newPath.finished = path.finished;
        return newPath;
    }

    public void addEdge(MyEdge edge){
        edges.add(edge);
    }

    public void addVertex(MyVertex vertex){
        vertexList.add(vertex);
    }

    public boolean containsVertex(MyVertex vertex){
        return vertexList.contains(vertex);
    }

    public List<MyEdge> getEdges() {
        return edges;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public List<MyVertex> getVertexList(){
        return new ArrayList<>(vertexList);
    }

    public int getWeight(){
        return edges.size();
    }

    @Override
    public String toString() {
        return "MyPath{" +
                "edges=" + edges +
                ", vertexList=" + vertexList +
                ", finished=" + finished +
                '}';
    }
}
