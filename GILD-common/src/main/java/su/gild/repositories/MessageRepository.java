package su.gild.repositories;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import su.gild.constructors.Channel;
import su.gild.constructors.Message;
import su.gild.constructors.User;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {

    @AllowFiltering
    @Query("SELECT * FROM messages WHERE channelid = ?0 AND timestamp > ?1 LIMIT ?2 ALLOW FILTERING")
    List<Messages> findAll(long channelid, long timestamp, int limit);

    @AllowFiltering
    Message findByContent(String content);

    @AllowFiltering
    List<message> findAllByContent(String content);

    @AllowFiltering
    Message findByChannelId(String channelId);

    @AllowFiltering
    List<Message> findAllByChannelId(String channelId);

    @AllowFiltering
    @Query("SELECT * FROM messages WHERE channelid = ?0 AND id = ?1 ALLOW FILTERING")
    Message findByChannelIdAndId(long channelId, long id);

    @Override
    void delete(Message message);
}