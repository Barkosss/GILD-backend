import su.gild.repositories;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import su.gild.constructors.Member;
import su.gild.constructors.Message;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> {

    @AllowFiltering
    @Query("SELECT * FROM members WHERE channelid = ?0 AND id = ?1 ALLOW FILTERING")
    Member findByChannelIdAndId(long channelId, long id);

    @AllowFiltering
    Member findByAccessToken(String accessToken);

    @AllowFiltering
    List<Member> findAllByAccessToken(String accessToken);

    @AllowFiltering
    Member findByChannelId(String channelId);

    @AllowFiltering
    List<Member> findAllByChannelId(String channelId);

    @Override
    void delete(Member member);
}