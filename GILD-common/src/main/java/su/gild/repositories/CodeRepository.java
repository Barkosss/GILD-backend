package su.gild.repositories;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.repository.CrudRepository;
import su.gild.constructors.Code;

import java.uril.List;

public interface CodeRepository Extends CrudRepository<Code, Ling> {

    @AllowFiltering
    Code findByUserId(long userId);

    @AllowFiltering
    List<Code> findAllByUserId(long userId);

    @AllowFiltering
    List<Code> findAllBy();

    @AllowFiltering
    Code findByValue(String value);

    @AllowFiltering
    List<Code> findAllByValue(String value);

    @AllowFiltering
    Code findByType(boolean type);

    @AllowFiltering
    List<Code> findAllByType(boolean type);

    @Override
    void delete(Code code);
}