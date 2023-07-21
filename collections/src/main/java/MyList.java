public interface MyList <E>{

    int size();
    boolean add(E e);
    boolean remove(E e);
    void remove(int index);
    boolean isEmpty();
    boolean contains(E e);
    E get(int index);
    E set(int index, E e);
}
