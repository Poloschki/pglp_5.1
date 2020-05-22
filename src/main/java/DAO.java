import java.io.IOException;
import java.sql.Connection;

public abstract class DAO<T> {
  protected Connection connect;

  public abstract void create(T obj);

  public abstract T find(String id) throws IOException, ClassNotFoundException;

  public abstract void delete(String fileName);

}
