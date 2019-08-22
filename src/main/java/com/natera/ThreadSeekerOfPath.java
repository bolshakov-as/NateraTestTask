package com.natera;

import java.util.List;
import java.util.Map;

public class ThreadSeekerOfPath implements SeekerOfPath {

    private List<MyPath> paths;
    private Map<MyVertex, List<MyEdge>> mapEdges;
    private MyVertex startVertex;
    private MyVertex goalVertex;


    //    https://www.baeldung.com/java-executor-wait-for-threads
    @Override
    public MyPath getOptimalPath() {
        return null;
    }
}
