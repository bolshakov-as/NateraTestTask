package com.natera;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class AbstractGraph implements Graph {
    private List<MyVertex> vertexList = new ArrayList<>();
    private List<MyEdge> edgeList = new ArrayList<>();

    @Override
    public void addVertex(MyVertex vertex) {
        vertexList.add(vertex);
    }

    @Override
    public void addVertex(MyVertex... vertexs) {
        vertexList.addAll(Arrays.asList(vertexs));
    }

    @Override
    public void addEdge(MyEdge edge) {
        edgeList.add(edge);
    }

    @Override
    public void addEdge(MyEdge... edges) {
        edgeList.addAll(Arrays.asList(edges));
    }

    protected List<MyEdge> getEdgeList(){
        return edgeList;
    }

    @Override
    public MyPath getPath(MyVertex from, MyVertex to) {

        if(from.equals(to)){
            return new MyPath();
        }

        final Map<MyVertex, List<MyEdge>> mapEdges = getMapEdges();
        RecursionSeekerOfPath seekerOfPath = new RecursionSeekerOfPath(mapEdges, to, from);
        return seekerOfPath.getOptimalPath();
    }

    abstract protected Map<MyVertex, List<MyEdge>> getMapEdges();
}
