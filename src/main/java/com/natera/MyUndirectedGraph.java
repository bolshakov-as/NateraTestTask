package com.natera;

import java.util.*;

public class MyUndirectedGraph implements Graph {
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
    public MyPath getPath(MyVertex from, MyVertex to) {

        if(from.equals(to)){
            return new MyPath();
        }

        final Map<MyVertex, List<MyEdge>> mapEdges = getMapEdges();
        RecursionSeekerOfPath seekerOfPath = new RecursionSeekerOfPath(mapEdges, to, from);
        return seekerOfPath.getOptimalPath();
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

    private Map<MyVertex, List<MyEdge>> getMapEdges(){
        Map<MyVertex, List<MyEdge>> mapEdges = new HashMap<>();
        edgeList.forEach(myEdge -> {
            addEdgeForVertex(mapEdges, myEdge.getFrom(), myEdge);
            addEdgeForVertex(mapEdges, myEdge.getTo(), myEdge.reverse());
        });
        return mapEdges;
    }

    private void addEdgeForVertex(Map<MyVertex, List<MyEdge>> map, MyVertex vertex, MyEdge edge){
        List<MyEdge> myEdges = map.get(vertex);
        if(myEdges == null){
            List<MyEdge> newEdgeList = new ArrayList<>();
            newEdgeList.add(edge);
            map.put(vertex, newEdgeList);
        }
        else {
            myEdges.add(edge);
        }
    }

    private static class RecursionSeekerOfPath{
        private List<MyPath> paths;
        private Map<MyVertex, List<MyEdge>> mapEdges;
        private MyVertex startVertex;
        private MyVertex goalVertex;

        public RecursionSeekerOfPath(Map<MyVertex, List<MyEdge>> mapEdges, MyVertex goalVertex, MyVertex startVertex) {
            this.mapEdges = mapEdges;
            this.goalVertex = goalVertex;
            this.startVertex = startVertex;
        }

        public MyPath getOptimalPath(){

            paths = new ArrayList<>();

            MyPath path = new MyPath();
            path.addVertex(startVertex);
            findNextStep(path, startVertex);

            System.out.println("Number of paths: " + paths.size());

            return paths.isEmpty() ? null : paths.get(0);
        }

        private void findNextStep(MyPath currentPath, MyVertex currentVertex){

            if(currentVertex.equals(goalVertex)){
                currentPath.setFinished(true);
                return;
            }

            List<MyEdge> myEdges = mapEdges.get(currentVertex);
            boolean firstCross = true;
            for (MyEdge myEdge : myEdges) {
                //TODO error with working the same object after finish
                if(!currentPath.containsVertex(myEdge.getTo())){
                    if(firstCross){ //continue path
                        currentPath.addEdge(myEdge);
                        currentPath.addVertex(myEdge.getTo());
                        findNextStep(currentPath, myEdge.getTo());
                        firstCross = false;
                    }
                    else {//create new path
                        MyPath newPath = MyPath.of(currentPath);
                        paths.add(newPath);
                        newPath.addEdge(myEdge);
                        newPath.addVertex(myEdge.getTo());
                        findNextStep(newPath, myEdge.getTo());
                    }
                }
            }

        }

    }

}
