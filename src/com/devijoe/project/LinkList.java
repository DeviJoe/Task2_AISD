package com.devijoe.project;

import java.util.*;
import java.util.function.Consumer;

public class LinkList<T> {

    private transient int size = 0;
    //первый элемент
    private transient LinkedNode<T> first;
    //последний элемент
    private transient LinkedNode<T> last;

    /**
     * Пустой конструктор
     */
    public LinkList() {
    }

    /**
     * Присоединяет первый элемент
     * @param t значение
     */
    private void linkFirst(T t) {
        final LinkedNode<T> k = this.first;
        final LinkedNode<T> node = new LinkedNode<>(t, null, k);
        this.first = node;
        if (k==null) {
            last = node;
        } else {
            k.setPrev(node);
        }
        size++;
    }

    /**
     * Присоединяет последний элемент
     * @param t
     */
    private void linkLast(T t) {
        final LinkedNode<T> k = this.last;
        final LinkedNode<T> node = new LinkedNode<>(t, k, null);
        this.last = node;
        if (k==null) {
            first = node;
        } else {
            k.setNext(node);
        }
        size++;
    }


    /**
     * Получение кол-ва элементов списка
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * Проверка списка на пустоту
     * @return
     */
    public boolean isEmpty() {
        if (size==0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Проверка на содержание объекта в списке
     * @param o
     * @return
     */
    public boolean contains(Object o) {

        if (o==null) {
            for (LinkedNode<T> t = first; t!=null; t = t.getNext()) {
                if (t.getValue()==null) {
                    return true;
                }
            }
        } else {
            for (LinkedNode<T> t = first; t!=null; t = t.getNext()) {
                if (t.getValue().equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Приведение листа к массиву
     * @return
     */
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i=0;
        for (LinkedNode<T> t = first; t != null; t = t.getNext()) {
            array[i] = t.getValue();
            i++;
        }
        return array;
    }

    /**
     * Добавление элемента к массиву в конец
     * @param t
     */
    public void add(T t) {
        linkLast(t);
    }

    /**
     * Удаление элемента
     * @param o
     * @return
     */
    public boolean remove(Object o) {
        if (!contains(o)) {
            return false;
        } else {
            if (o==null) {
                for (LinkedNode<T> t = first; t!=null; t = t.getNext()) {
                    if (t.getValue()==null) {
                        t.getPrev().setPrev(t.getNext());
                        return true;
                    }
                }
            } else {
                for (LinkedNode<T> t = first; t!=null; t = t.getNext()) {
                    if (t.getValue().equals(o)) {
                        t.getPrev().setPrev(t.getNext());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Очистка листа
     */
    public void clear() {
        first.setNext(null);
        last.setValue(null);
        last.setValue(null);
        last.setPrev(null);
        size=0;
    }

    /**
     * Получение элемента по индексу
     * @param index индекс
     * @return
     */
    public Object get(int index) {
        int counter = 0;
        LinkedNode<T> t = first;
        try {
            while (counter!=index) {
                t = t.getNext();
                counter++;
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return t.getValue();
    }

    /**
     *
     * @param index
     * @param
     */
    public void add(int index, T element) throws Exception {
        if (index > size && index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        LinkedNode<T> t = first;
         do {
            t = t.getNext();
            counter++;
        } while (counter!=index);
        t.setNext(new LinkedNode(element, t, t.getNext()));
    }

    /**
     * Удаление элемента по индексу
     * @param index
     */
    public void remove(int index) {
        if (index > size && index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        LinkedNode<T> t = first;
        while (counter!=index) {
            t = t.getNext();
            counter++;
        }
        t.setPrev(t.getNext());
    }

    /**
     * Нахождение 1 индекса объекта
     * @param o
     * @return
     */
    public int indexOf(Object o) {
        int count=0;
        if (contains(o)) {
            if (o==null) {
                for (LinkedNode<T> t = first; t!=null; t = t.getNext()) {
                    if (t.getValue()==null) {
                        return count;
                    } else count++;
                }
            } else {
                for (LinkedNode<T> t = first; t!=null; t = t.getNext()) {
                    if (t.getValue().equals(o)) {
                        return count;
                    } else count++;
                }
            }
        }
        return -1;
    }

    /**
     * Создание доп.связного листа
     * @param fromIndex
     * @param toIndex
     * @return
     */
    public LinkList subList(int fromIndex, int toIndex) {
        LinkList<T> list = new LinkList<>();
        for (LinkedNode<T> t = first; t!=null; t=t.getNext()) {
            list.add((T) get(fromIndex));
        }
        return list;
    }

    /**
     * Перебор всех элементов
     * @param action
     */
    public void forEach(Consumer action) {
        for (LinkedNode<T> t = first; t!=null; t=t.getNext()) {
            action.accept(t);
        }
    }
}
