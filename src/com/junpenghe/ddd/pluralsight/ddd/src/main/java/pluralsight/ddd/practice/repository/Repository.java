package pluralsight.ddd.practice.repository;

/**
 * @author Junpeng He
 */
public interface Repository<T> {

    T getById(String id);

    int save(T t);

}
