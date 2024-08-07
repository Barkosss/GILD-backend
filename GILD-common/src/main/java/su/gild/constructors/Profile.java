package su.gild.constructors;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;

/*

DESCRIPTION

*/

@Table("profiles")
public class Profile {

    @Id
    @PrimaryKey
    // Profile's id
    public long id;

    @Column("userid")
    // Member's id
    public long userId;

    @Column("information")
    public String information;

    @Column("quote")
    public String quote;

    @Column("createdat")
    public long createdAt;

    @Column("levels")
    public List<Level> levels;

    @Column("tags")
    public List<String> tags;

    // ...
    public Profile(long id, long userId, String information, String quote, long createdAt, List<String> tags) {
        this.id = id;
        this.userId = userId;
        this.information = information;
        this.quote = quote;
        this.createdAt = createdAt;
        this.tags = tags;
    }

    // ...
    public void setId(long id) {
        this.id = id;
    }

    // ...
    public long getId() {
        return id;
    }

    // ...
    public void setUserId(long userId) {
        this.userId = userId;
    }

    // ...
    public long getUserId() {
        return userId;
    }

    // ...
    public void setInformation(String information) {
        this.information = information;
    }

    // ...
    public String getInformation() {
        return information;
    }

    // ...
    public void setQuote(String quote) {
        this.quote = quote;
    }

    // ...
    public String getQuote() {
        return quote;
    }

    // ...
    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    // ...
    public long getCreatedAt() {
        return createdAt;
    }

    // ...
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    // ...
    public List<String> getTags() {
        return tags;
    }
}