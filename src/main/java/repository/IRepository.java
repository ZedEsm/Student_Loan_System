package repository;

public interface IRepository<E> {
    void save(E e);

    void update(E e);
}
