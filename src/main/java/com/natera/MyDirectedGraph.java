package com.natera;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class MyDirectedGraph implements Graph {

    private List<MyVertex> vertexList = new ArrayList<>();
    private List<MyEdge> edgeList = new ArrayList<>();

    @Override
    public void addVertex(MyVertex vertex) {
        vertexList.add(vertex);
    }

    @Override
    public void addEdge(MyEdge edge) {
        edgeList.add(edge);
    }

    @Override
    public List<MyEdge> getPath(MyVertex from, MyVertex to) {

        int[][] matrixWeight = getMatrixWeight();




        return Collections.emptyList();
    }

    private int[][] getMatrixWeight(){
        int[][] matrix = new int[vertexList.size()][vertexList.size()];

        edgeList.forEach(myEdge -> {
            int indFrom = vertexList.indexOf(myEdge.getFrom());
            int indTo = vertexList.indexOf(myEdge.getTo());
            matrix[indFrom][indTo] = 1;
            matrix[indTo][indFrom] = 1;
        });

        return matrix;
    }

}
