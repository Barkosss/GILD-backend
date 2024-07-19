package su.gild.constructors;

import con.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import java.util.List;

@Table("posts")
public class Post {

    @Id
    @PrimaryKey
    public long id;

    @Column("profileid")
    public long profileId;

    @Column("content")
    public String content;

    @Column("type")
    // Type: 1=Public, 2=Only subs, 3=Subs or Price, 4=Only price
    public int type;

    @Column("levelid")
    public long levelId;
    
    @Column("amountprice")
    public long amountPrice;

    @Column("createdat")
    public long createdAt;

    @Column("editat")
    public long editAt;

    @Column("deletedat")
    public long deletedAt;

    @Collunm("attachments")
    public List<String> attachments;

    @Column("tags")
    public List<String> tags;

    @Column("channelid")
    public long channelId;

    @Column("disablecomments")
    public boolean disableComments;

    // ...
    public Post(long id, long profileId, String content, String type, long createdAt, List<String> attachments, List<String> tags, boolean disableComments = false) {
        this.id = id;
        this.profileId = profileId;
        this.content = content;
        this.type = type;
        this.createdAt = createdAt;
        this.attachments = attachments;
        this.tags = tags;
        this.disableComments = disableComments;
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
    public void setProfileId(long profileId) {
        this.profileId = profileId;
    }

    // ...
    public long getProfileId() {
        return profileId;
    }

    // ...
    public void setContent(String content) {
        this.content = content;
    }

    // ...
    public String getContent() {
        return content;
    }

    // ...
    public void setType(String type) {
        this.type = type;
    }

    // ...
    public String getType() {
        return type;
    }

    // ...
    public void setLevelId(long levelId) {
        this.levelId = levelId;
    }

    // ...
    public long getLevelId() {
        return levelId;
    }

    // ...
    public void setAmountPrice(long amountPrice) {
        this.amountPrice = amountPrice;
    }

    // ...
    public long getAmountPrice() {
        return amountPrice;
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
    public void setEditAt(long editAt) {
        this.editAt = editAt;
    }

    // ...
    public long getEditAt() {
        return editAt;
    }

    // ...
    public void setDeletedAt(long deletedAt) {
        this.deletedAt = deletedAt;
    }

    // ...
    public long getDeletedAt() {
        return deletedAt;
    }

    // ...
    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    // ...
    public List<String> getAttachments() {
        return attachments;
    }

    // ...
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    // ...
    public List<String> getTags() {
        return tags;
    }

    // ...
    public void setDisableComments(boolean disableComments) {
        this.disableComments = disableComments;
    }

    // ...
    public boolean isDisableComments() {
        return disableComments;
    }
}