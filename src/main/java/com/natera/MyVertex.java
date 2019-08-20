package com.natera;

import java.util.Objects;

public class MyVertex {
    private long id;

    public MyVertex(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyVertex myVertex = (MyVertex) o;
        return id == myVertex.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MyVertex{" +
                "id=" + id +
                '}';
    }
}
