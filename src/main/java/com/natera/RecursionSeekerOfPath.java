package com.natera;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class RecursionSeekerOfPath implements SeekerOfPath {
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
        
        return paths.stream()
                .min(Comparator.comparingInt(MyPath::getWeight))
                .orElse(null);
    }

    private void findNextStep(MyPath currentPath, MyVertex currentVertex){

        if(currentVertex.equals(goalVertex)){
            currentPath.setFinished(true);
            paths.add(currentPath);
            return;
        }

        List<MyEdge> myEdges = mapEdges.get(currentVertex);
        List<MyVertex> vertexList = currentPath.getVertexList();
        if(myEdges != null) {
            for (MyEdge myEdge : myEdges) {
                if (!vertexList.contains(myEdge.getTo())) {
                    MyPath newPath = MyPath.of(currentPath);
                    newPath.addEdge(myEdge);
                    newPath.addVertex(myEdge.getTo());
                    findNextStep(newPath, myEdge.getTo());
                }
            }
        }

    }
}
