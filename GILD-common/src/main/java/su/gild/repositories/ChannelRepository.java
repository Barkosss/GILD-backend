package su.gild.repository;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.repository.CrudRepository;
import su.gild.constructors.Channel;
import su.gild.constructors.Member;

import java.util.List;

public interface ChannelRepository extends CrudRepository<Channel, Long> {

    @AllowFiltering
    Channel findById(long id);

    @AllowFiltering
    Member findByName(String name);

    @AllowFiltering
    List<Member> findAllByName(String name);

    @Override
    void delete(Channel channel);
}