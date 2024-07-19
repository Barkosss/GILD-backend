package su.gild.constructors;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;

/*

DESCRIPTION

*/

@Table("levels")
public class Level {

    @Id
    @PrimaryKey
    public long id;

    @Column("name")
    public String name;

    @Column("description")
    public String description;

    @Column("cover")
    public String cover;

    @Column("price")
    public long price;

    @Column("enabledirectmessage")
    // Is sending a message to yandex.direct activated
    public boolean enableDirectMessage;

    @Column("directmessage")
    // Message to Direct
    public String directMessage;

    @Column("discordroles")
    // Discord Roles IDs
    public List<Long> discordRoles;

    @Column("discordrequire")
    // Is integration with Discord mandatory
    public boolean discordRequire;

    @Column("telegramchats")
    // Telegram Chats IDs
    public List<String> telegramChats;

    @Column("telegramrequire")
    // Is integration with Telegram mandatory
    public boolean telegramRequire;

    
    public Level(long id, String name, String description, String cover, long price, boolean enableDirectMessage, String directMessage, List<Long> discordRoles, boolean discordRequire, List<String> telegramChats, boolean telegramRequire) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cover = cover;
        this.price = price;
        this.enableDirectMessage = enableDirectMessage;
        this.directMessage = directMessage;
        this.discordRoles = discordRoles;
        this.discordRequire = discordRequire;
        this.telegramChats = telegramChats;
        this.telegramRequire = telegramRequire;
    };



    // Set the Level ID
    public void setId(long id) {
        this.id = id;
    }

    // Get the Level ID
    public long getId() {
        return id;
    }

    // Set the Level Name
    public void setName(String name) {
        this.name = name;
    }

    // Get the Level Name
    public String getName() {
        return name;
    }

    // Set the Level Description
    public void setDescription(String description) {
        this.description = description;
    }

    // Get the Level Description
    public String getDescription() {
        return description;
    }

    // Set the Level Cover
    public void setCover(String cover) {
        this.cover = cover;
    }

    // Get the Level Cover
    public String getCover() {
        return cover;
    }

    // Set the Level Price
    public void setPrice(long price) {
        this.price = price;
    }

    // Get the Level Price
    public long getPrice() {
        return price;
    }

    // Set the Level Status Direct Message
    public void setEnableDirectMessage(boolean enableDirectMessage) {
        this.enableDirectMessage = enableDirectMessage;
    }

    // Get the Level Status Direct Message
    public boolean isEnableDirectMessage() {
        return enableDirectMessage;
    }

    // Set the Level Text for Direct Message
    public void setDirectMessage(String directMessage) {
        this.directMessage = directMessage;
    }

    // Get the Level Text for Direct Message
    public String getDirectMessage() {
        return directMessage;
    }

    // Set the Level List of Discord Roles
    public void setDiscordRoles(List<Long> discordRoles) {
        this.discordRoles = discordRoles;
    }

    // Get the Level List of Telegram Chats
    public List<Long> getDiscordRoles() {
        return discordRoles;
    }

    // Set the Level List of Telegram Chats
    public void setTelegramChats(List<String> telegramChats) {
        this.telegramChats = telegramChats;
    }

    // Get the Level List of Telegram Chats
    public List<String> getTelegramChats() {
        return telegramChats;
    }
}