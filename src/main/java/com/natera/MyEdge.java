package com.natera;

public class MyEdge {
    private MyVertex from;
    private MyVertex to;

    public MyEdge(MyVertex from, MyVertex to) {
        this.from = from;
        this.to = to;
    }

    public MyVertex getFrom() {
        return from;
    }

    public MyVertex getTo() {
        return to;
    }
}
