package com.natera;

import java.util.Objects;

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

    public MyEdge reverse(){
        return new MyEdge(to, from);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyEdge edge = (MyEdge) o;
        return Objects.equals(from, edge.from) &&
                Objects.equals(to, edge.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    @Override
    public String toString() {
        return "MyEdge{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}
