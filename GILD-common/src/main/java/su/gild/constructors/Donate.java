package su.gild.constructors;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/*

DESCRIPTION

*/

@Table("donates")
public class Donate {

    @Id
    @PrimaryKey
    public long id;

    @Column("content")
    public String content;

    @Column("senduserid")
    public long sendUserId;

    @Column("recipientuserid")
    public long recipientUserId;

    @Column("amount")
    public long amount;

    @Column("timestamp")
    public long timestamp;

    // ...
    public Donate(long id, String content, long sendUserId, long recipientUserId, long amount, long timestamp) {
        this.id = id;
        this.content = content;
        this.sendUserId = sendUserId;
        this.recipientUserId = recipientUserId;
        this.amount = amount;
        this.timestamp = timestamp;
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
    public String getContent() {
        return content;
    }

    // ...
    public void setContent(String content) {
        this.content = content;
    }

    // ...
    public long getSendUserId() {
        return sendUserId;
    }

    // ...
    public void setSendUserId(long sendUserId) {
        this.sendUserId = sendUserId;
    }

    // ...
    public long getRecipientUserId() {
        return recipientUserId;
    }

    // ...
    public void setRecipientUserId(long recipientUserId) {
        this.recipientUserId = recipientUserId;
    }

    // ...
    public long getAmount() {
        return amount;
    }

    // ...
    public void setAmount(long amount) {
        this.amount = amount;
    }

    // ...
    public long getTimestamp() {
        return timestamp;
    }

    // ...
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}