package su.gild.constructors;

import java.util.List;

public class BaseUser {
    public long id;
    public String username, avatar, accessToken;
    public List<String> flags;
    public long createdAt;

    public BaseUser(long id, String username, String avatar, String accessToken, long createdAt, List<String> flags) {
        this.id = id;
        this.username = username;
        this.avatar = avatar;
        this.accessToken = accessToken;
        this.createdAt = createdAt;
        this.flags = flags;
    }
}