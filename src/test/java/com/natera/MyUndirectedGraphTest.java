package com.natera;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MyUndirectedGraphTest {
    @Test
    public void testUndirectedGraph(){

        Graph graph = new MyUndirectedGraph();
        graph.addVertex(MockData.VERTEX_0, MockData.VERTEX_1, MockData.VERTEX_2,
                MockData.VERTEX_3, MockData.VERTEX_4, MockData.VERTEX_5, MockData.VERTEX_6, MockData.VERTEX_7);
        graph.addEdge(MockData.EDGE_0_1, MockData.EDGE_1_2, MockData.EDGE_1_5,
                MockData.EDGE_2_3, MockData.EDGE_3_7, MockData.EDGE_5_4, MockData.EDGE_4_6, MockData.EDGE_7_6);

        MyPath path = graph.getPath(MockData.VERTEX_0, MockData.VERTEX_6);
        List<MyEdge> edges = path.getEdges();

        Assert.assertEquals(4, edges.size());
        Assert.assertEquals(MockData.EDGE_0_1, edges.get(0));
        Assert.assertEquals(MockData.EDGE_1_5, edges.get(1));
        Assert.assertEquals(MockData.EDGE_5_4, edges.get(2));
        Assert.assertEquals(MockData.EDGE_4_6, edges.get(3));

    }

    @Test
    public void testUndirectedGraphWithReverse(){

        Graph graph = new MyUndirectedGraph();
        graph.addVertex(MockData.VERTEX_0, MockData.VERTEX_1, MockData.VERTEX_2,
                MockData.VERTEX_3, MockData.VERTEX_4, MockData.VERTEX_5, MockData.VERTEX_6, MockData.VERTEX_7);
        graph.addEdge(MockData.EDGE_0_1, MockData.EDGE_1_2, MockData.EDGE_1_5,
                MockData.EDGE_2_3, MockData.EDGE_3_7, MockData.EDGE_5_4, MockData.EDGE_4_6, MockData.EDGE_7_6.reverse());

        MyPath path = graph.getPath(MockData.VERTEX_0, MockData.VERTEX_6);
        List<MyEdge> edges = path.getEdges();

        Assert.assertEquals(4, edges.size());
        Assert.assertEquals(MockData.EDGE_0_1, edges.get(0));
        Assert.assertEquals(MockData.EDGE_1_5, edges.get(1));
        Assert.assertEquals(MockData.EDGE_5_4, edges.get(2));
        Assert.assertEquals(MockData.EDGE_4_6, edges.get(3));

    }

    @Test
    public void testUndirectedGraphWithoutPath(){

        Graph graph = new MyUndirectedGraph();
        graph.addVertex(MockData.VERTEX_0, MockData.VERTEX_1, MockData.VERTEX_2,
                MockData.VERTEX_3, MockData.VERTEX_4, MockData.VERTEX_5, MockData.VERTEX_6, MockData.VERTEX_7);
        graph.addEdge(MockData.EDGE_0_1, MockData.EDGE_1_2, MockData.EDGE_1_5,
                MockData.EDGE_2_3, MockData.EDGE_3_7, MockData.EDGE_5_4);

        MyPath path = graph.getPath(MockData.VERTEX_0, MockData.VERTEX_6);
        Assert.assertNull(path);

    }
}