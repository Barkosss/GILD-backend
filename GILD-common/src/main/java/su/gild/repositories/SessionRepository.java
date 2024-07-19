package su.gild.repositories;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.repository.CrudRepository;
import su.foxogram.constructors.Session;
import su.foxogram.constructors.User;

import java.util.List;

public interface SessionRepository extends CrudRepository<Session, String> {
    // ...
}