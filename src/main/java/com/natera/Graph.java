package com.natera;

import java.util.List;

public interface Graph {
    void addVertex(MyVertex vertex);
    void addVertex(MyVertex... vertex);
    void addEdge(MyEdge edge);
    void addEdge(MyEdge... edges);
    MyPath getPath(MyVertex from, MyVertex to);
}
