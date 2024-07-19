package su.gild.repositories;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import hava.util.Optional;
public interface BaseRepository<T, ID> extends Repository<T, ID> {

    Optional<T> findById(ID id);
    Optional<T> findAllBy();

    <S extends T> S save(S entity);
    <S extends T> S delete(S entity);
}