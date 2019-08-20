package com.natera;

import java.util.List;

public interface Graph {
    void addVertex(MyVertex vertex);
    void addEdge(MyEdge edge);
    List<MyEdge> getPath(MyVertex from, MyVertex to);
}
