package com.natera;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MyUndirectedGraphTest {
    @Test
    public void testDirectGraph(){

        MyVertex vertex0 = new MyVertex(0);
        MyVertex vertex1 = new MyVertex(1);
        MyVertex vertex2 = new MyVertex(2);
        MyVertex vertex3 = new MyVertex(3);
        MyVertex vertex4 = new MyVertex(4);
        MyVertex vertex5 = new MyVertex(5);
        MyVertex vertex6 = new MyVertex(6);
        MyVertex vertex7 = new MyVertex(7);

        MyEdge edge0_1 = new MyEdge(vertex0, vertex1);
        MyEdge edge1_2 = new MyEdge(vertex1, vertex2);
        MyEdge edge1_5 = new MyEdge(vertex1, vertex5);
        MyEdge edge2_3 = new MyEdge(vertex2, vertex3);
        MyEdge edge3_7 = new MyEdge(vertex3, vertex7);
        MyEdge edge5_4 = new MyEdge(vertex5, vertex4);
        MyEdge edge4_6 = new MyEdge(vertex4, vertex6);
        MyEdge edge7_6 = new MyEdge(vertex7, vertex6);

        Graph graph = new MyUndirectedGraph();
        graph.addVertex(vertex0);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);
        graph.addVertex(vertex6);
        graph.addVertex(vertex7);

        graph.addEdge(edge0_1);
        graph.addEdge(edge1_2);
        graph.addEdge(edge1_5);
        graph.addEdge(edge2_3);
        graph.addEdge(edge3_7);
        graph.addEdge(edge5_4);
        graph.addEdge(edge4_6);
        graph.addEdge(edge7_6);

        MyPath path = graph.getPath(vertex0, vertex6);
        System.out.println(path);

        /*List<MyEdge> path = graph.getPath(vertex0, vertex6);

        Assert.assertEquals(4, path.size());
        Assert.assertEquals(edge0_1, path.get(0));
        Assert.assertEquals(edge1_5, path.get(1));
        Assert.assertEquals(edge5_4, path.get(2));
        Assert.assertEquals(edge4_6, path.get(3));*/

    }
}