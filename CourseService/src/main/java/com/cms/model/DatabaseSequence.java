package com.cms.model;

import java.io.Serializable;

public class DatabaseSequence implements Serializable {

    private String id;
    private long seq;

    public DatabaseSequence() {
    }

    public DatabaseSequence(String id, long seq) {
        this.id = id;
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatabaseSequence that = (DatabaseSequence) o;
        return seq == that.seq &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seq);
    }

    @Override
    public String toString() {
        return "DatabaseSequence{" +
                "id='" + id + '\'' +
                ", seq=" + seq +
                '}';
    }
}
