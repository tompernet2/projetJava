package sio.autoecoleprojet.repositories;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RepositoryInterface<T,ID>
{
    void create(T t) throws SQLException;
    void update(T t) throws SQLException;
    void delete(T t);
    T get(ID id);
    ArrayList<T> getAll() throws SQLException;

}
