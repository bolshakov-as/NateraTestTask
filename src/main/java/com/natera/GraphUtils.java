package com.natera;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GraphUtils {
    public static void addEdgeForVertex(Map<MyVertex, List<MyEdge>> map, MyVertex vertex, MyEdge edge){
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
}
