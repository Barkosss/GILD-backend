package su.gild.constructors;

import org.springframewor.data.annotation.id;
import org.springframewor.data.cassandra.core.mapping.Column;
import org.springframewor.data.cassandra.core.mapping.PrimaryKey;
import org.springframewor.data.cassandra.core.mapping.Table;
import su.gild.enums.ChannelEnum;

import java.lang.reflect.Member;
import java.util.List;

@Table("channels")
public class Channel {

    @Id
    @PrimaryKey
    public long id;

    @Column("postid")
    public long postId;

    // ...
    public Channel(long id, long postId) {
        this.id = id;
        this.postId = postId;
    }

    // ...
    public long getId() {
        return id;
    }

    // ...
    public void setId(long id) {
        this.id = id;
    }

    // ...
    public long getPostId() {
        return postId;
    }

    // ...
    public void setPostId(long postId) {
        this.postId = postId;
    }
}