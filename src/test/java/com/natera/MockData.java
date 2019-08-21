package com.natera;

public class MockData {
    public static final MyVertex VERTEX_0 = new MyVertex(0);
    public static final MyVertex VERTEX_1 = new MyVertex(1);
    public static final MyVertex VERTEX_2 = new MyVertex(2);
    public static final MyVertex VERTEX_3 = new MyVertex(3);
    public static final MyVertex VERTEX_4 = new MyVertex(4);
    public static final MyVertex VERTEX_5 = new MyVertex(5);
    public static final MyVertex VERTEX_6 = new MyVertex(6);
    public static final MyVertex VERTEX_7 = new MyVertex(7);

    public static final MyEdge EDGE_0_1 = new MyEdge(VERTEX_0, VERTEX_1);
    public static final MyEdge EDGE_1_2 = new MyEdge(VERTEX_1, VERTEX_2);
    public static final MyEdge EDGE_1_5 = new MyEdge(VERTEX_1, VERTEX_5);
    public static final MyEdge EDGE_2_3 = new MyEdge(VERTEX_2, VERTEX_3);
    public static final MyEdge EDGE_3_7 = new MyEdge(VERTEX_3, VERTEX_7);
    public static final MyEdge EDGE_5_4 = new MyEdge(VERTEX_5, VERTEX_4);
    public static final MyEdge EDGE_4_6 = new MyEdge(VERTEX_4, VERTEX_6);
    public static final MyEdge EDGE_7_6 = new MyEdge(VERTEX_7, VERTEX_6);
}
