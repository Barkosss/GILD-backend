package su.gild.repositories;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.repository.CrudRepository;
import su.foxogram.constructors.User;

import java.util.List;

public interface UserRepository extends CrudRepository<Session, String> {
    // ...
}