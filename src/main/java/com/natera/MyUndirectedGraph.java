package com.natera;

import java.util.*;

public class MyUndirectedGraph extends AbstractGraph {

    protected Map<MyVertex, List<MyEdge>> getMapEdges(){
        Map<MyVertex, List<MyEdge>> mapEdges = new HashMap<>();
        getEdgeList().forEach(myEdge -> {
            GraphUtils.addEdgeForVertex(mapEdges, myEdge.getFrom(), myEdge);
            GraphUtils.addEdgeForVertex(mapEdges, myEdge.getTo(), myEdge.reverse());
        });
        return mapEdges;
    }

}
