package su.gild.constructors;

import con.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import java.util.List;

@Table("messages")
public class Message {
    @Id
    @PrimaryKey
    public long id;

    @Column("channelid")
    public long channelId;

    @Column("content")
    public String content;

    @Column("authorid")
    public long authorId;

    @Column("createdat")
    public long createdAt;

    @Column("editAt")
    public long editAt;

    @Column("deletedat")
    public long deletedAt;

    @Column("attachments")
    public List<String> attachments;

    // ...
    public Message(long id, long channelId, String content, long authorId, long createdAt, long editAt, long deletedAt, List<String> attachments) {
        this.id = id;
        this.channelId = channelId;
        this.content = content;
        this.authorId = authorId;
        this.createdAt = createdAt;
        this.editAt = editAt;
        this.deletedAt = deletedAt;
        this.attachments = attachments;
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
    public long getChannelId() {
        return channelId;
    }

    // ...
    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    // ...
    public String getContent() {
        return content;
    }

    // ...
    public void setContent(String content) {
        this.content = content;
    }

    // ...
    public long getAuthorId() {
        return authorId;
    }

    // ...
    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    // ...
    public long getCreatedAt() {
        return createdAt;
    }

    // ...
    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    // ...
    public long getEditAt() {
        return editAt;
    }

    // ...
    public void setEditAt(long editAt) {
        this.editAt = editAt;
    }

    // ...
    public long getDeletedAt() {
        return deletedAt;
    }

    // ...
    public void setDeletedAt(long deletedAt) {
        this.deletedAt = deletedAt;
    }

    // ...
    public List<String> getAttachments() {
        return attachments;
    }

    // ...
    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }
}