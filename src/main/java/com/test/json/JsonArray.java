package com.test.json;

import java.io.Serializable;
import java.util.*;

/**
 * @author machunxiao create at 2020-03-17
 */
public class JsonArray extends Json implements List<Object>, Cloneable, Serializable, RandomAccess {

    private static final long serialVersionUID = 1L;

    private final List<Object> data;

    public JsonArray() {
        this(new ArrayList<>());
    }

    public JsonArray(List<Object> data) {
        this.data = data;
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return data.contains(o);
    }

    @Override
    public Iterator<Object> iterator() {
        return data.iterator();
    }

    @Override
    public Object[] toArray() {
        return data.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return data.toArray(a);
    }

    @Override
    public boolean add(Object o) {
        return this.data.add(o);
    }

    @Override
    public boolean remove(Object o) {
        return this.data.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.data.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<?> c) {
        return this.data.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<?> c) {
        return this.data.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.data.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.data.retainAll(c);
    }

    @Override
    public void clear() {
        this.data.clear();
    }

    @Override
    public Object get(int index) {
        return this.data.get(index);
    }

    @Override
    public Object set(int index, Object element) {
        return this.data.set(index, element);
    }

    @Override
    public void add(int index, Object element) {
        this.data.add(index, element);
    }

    @Override
    public Object remove(int index) {
        return this.data.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return this.data.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return this.data.lastIndexOf(o);
    }

    @Override
    public ListIterator<Object> listIterator() {
        return this.data.listIterator();
    }

    @Override
    public ListIterator<Object> listIterator(int index) {
        return this.data.listIterator(index);
    }

    @Override
    public List<Object> subList(int fromIndex, int toIndex) {
        return this.data.subList(fromIndex, toIndex);
    }

    @Override
    public Object clone() {
        return new JsonArray(new ArrayList<>(this.data));
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
