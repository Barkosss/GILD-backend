package su.gild.constructors;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;

/*

DESCRIPTION

*/

@Table("users")
public class User extends BaseUser {

    @Id
    @PrimaryKey
    public long id;

    @Column("username")
    public String username;

    @Column("avatar")
    public String avatar;

    @Column("email")
    private String email;

    @Column("emailverified")
    private boolean emailVerified;

    @Column("accesstoken")
    private String accessToken;

    @Column("refreshtoken")
    private String refreshToken;

    @Column("password")
    private String password;

    @Column("createdat")
    private long createdAt;

    @Column("disabledaccount")
    private boolean disabledAccount;

    @Column("flags")
    public List<String> flags;

    @Column("isdarktheme")
    public boolean isDarkTheme;

    @Column("subscriptions")
    // Information about active subscriptions
    public List<Subscriptions> subscriptions;


    // Create User Object
    public User(long id, String username, String avatar, String email, boolean emailVerified, String password, String accessToken, String refreshToken, long createdAt, boolean disabledAccount, List<String> flags, boolean isDarkTheme) {
        super(id, username, avatar, accessToken, createdAt, flags);
        this.email = email;
        this.emailVerified = emailVerified;
        this.password = password;
        this.refreshToken = refreshToken;
        this.disabledAccount = disabledAccount;
        this.isDarkTheme = isDarkTheme;
    }

    // Set id
    public void setId(long id) {
        this.id = id;
    }

    // Get id
    public long getId() {
        return id;
    }

    // Set username
    public void setUsername(String username) {
        this.username = username;
    }

    // Get username
    public String getUsername() {
        return username;
    }

    // Set avatar
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    // Get avatar
    public String getAvatar() {
        return avatar;
    }

    // Set email
    public void setEmail(String email) {
        this.email = email;
    }

    // Get email
    public String getEmail() {
        return email;
    }

    // Set email verified
    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    // Get email verified
    public boolean isEmailVerified() {
        return emailVerified;
    }

    // Set password
    public void setPassword(String password) {
        this.password = password;
    }

    // Get password
    public String getPassword() {
        return password;
    }

    // Set access token
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    // Get access token
    public String getAccessToken() {
        return accessToken;
    }

    // Set refresh token
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    // Get refresh token
    public String getRefreshToken() {
        return refreshToken;
    }

    // Set createdAt
    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    // Get created
    public long getCreatedAt() {
        return createdAt;
    }

    // Set status disable account
    public void setDisabledAccount(boolean disabledAccount) {
        this.disabledAccount = disabledAccount;
    }

    // Get status disable account
    public boolean isDisabledAccount() {
        return disabledAccount;
    }

    // Set flags
    public void setFlags(List<String> flags) {
        this.flags = flags;
    }

    // Get flags
    public List<String> getFlags() {
        return flags;
    }

    // Set dark theme
    public void setDarkTheme(boolean darkTheme) {
        this.isDarkTheme = darkTheme;
    }

    // Get status dark theme
    public boolean isDarkTheme() {
        return isDarkTheme;
    }

    // Set the subscriptions
    public void setSubscriptions(List<Subscriptions> subscriptions) {
        this.subscriptions = subscriptions;
    }

    // Get list of subscriptions
    public List<Subscriptions> getSubscriptions() {
        return subscriptions;
    }
}