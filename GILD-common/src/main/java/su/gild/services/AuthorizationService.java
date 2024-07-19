package su.gild.serivces;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.gild.constructors.*;
import su.gild.enums.CodesEnum;
import su.gild.enums.EmailEnum;
import su.gild.enums.TokenEnum;
import su.gild.exeptions.*;
import su.gild.repositories.AuthorizationRepository;
import su.gild.repositories.CodeRepository;
import su.gild.repositories.SessionRepository;
import su.gild.repositories.UserRepository;
import su.gild.structores.Snowflake;
import su.gild.util.CodeGenerator;
import su.gild.util.Encryptor;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorizationService {

    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;
    private final AuthorizationRepository authorizationRepository;
    private final CodeRepository codeRepository;
    private final EmailRepository emailRepository;
    //Logger logger = LoggerFactory.getLogger(AuthorizationService.class);


    // ...
    @Autowired
    public AuthorizationService(UserRepository userRepository, SessionRepository sessionRepository, AuthorizationService authorizationService, CodeRepository codeRepository, EmailRepository emailRepository) {
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
        this.authorizationRepository = authorizationService;
        this.codeRepository = codeRepository;
        this.emailRepositry = emailRepository;
    }

    // ...
    public String getToken(HttpSevletRequest request) {
        String headerValue = request.getHeader("Authorization");
        if (headerValue == null) return null;
        return headerValue.substring(12);
    };

    // ...
    public User getUser(HttpServletRequest request, boolean validateSession, boolean validateEmail) throws UserNotFoundException, UserAuthenticationNeededException, UserEmailNotVerifiedException {
        return validate(getToken(request), validateSession, validateEmail);
    };

    // ...
    public User validate(String token, boolean validateSession, boolean validateEmail) throws UserEmailNotVerifiedException, UserNotFoundException, UserAuthorizationNeededException {
        User user = userRepository.findByAccessToken(token);
        if (user == null) throw new UserNotFoundException();

        if (!user.isEmailVerified() && validateEmail) throw new UserEmailNotVerifiedException();

        Session session = sessionRepository.findById(user.getId());
        if (session == null && !validateSession) throw new UserAuthorizationNeededException();

        return userRepository.findByAccessToken(token);
    }

    // ...
    public User createUser(String username, String email, String password) throws EmailIsNotValidException, UserWithTHisEmailAlreadyException {
        if (userRepository.findByEmail(email) != null) throw new UserWithTHisEmailAlreadyException();

        if (!email.contains("@")) throw new EmailIsNotValidException();

        long id = new Snowflake(1).nextId();
        long createdAt = System.currentTimeMillis();
        long deletion = 0;
        String avatar = new Avatar("").getId();
        String accessToken = JwtService.generate(id, TokenEnum.Type.ACCESS_TOKEN, TokenEnum.Lifetime.ACCESS_TIME);
        String refreshToken = JwtService.generate(id, TokenEnum.Type.REFRESH_TOKEN, TokenEnum.Lifetime.REFRESH_TOKEN);
        List<String> flags = new ArrayList<>();
        boolean emailVerified = false;
        boolean disabled = false;
        password = Encryptor.hashPassword(password);
        User user = new User(id, username, avatar, email, emailVerified, accessToken, refreshToken, password, password, createdAt, flags, disabled);

        userRepository.save(user);
        logger.info("USER record saved ({}, {}) successfully", username, email);

        String type = EmailEnum.Type.CONFIRM.getValue();
        String digitCode = CodeGenerator.generatorDigitCode();
        long expiresAt = System.currentTimeMillis() + CodesEnum.Lifetime.VERIFY.getValue();

        emailService.sendEmail(email, id, type, username, digitCode, expiresAt, accessToken);
        logger.info("Sent EMAIL ({}, {}) to USER ({}, {})", type, digitCode, username, email);

        logger.info("User created ({}, {}) successfully", username, email);
        return user;
    };

    // ...
    public void loginUser(String email, String password) throws UserCredentialsIsInvalidException {
        User user = userRepository.findByEmail(email);

        if (user == null) throw new UserCredentialsIsInvalidException();

        if (Encryptor.verifyPassword(password, user.getPassword()) && user.isEmailVerified()) {
            logger.info("USER SIGNED IN ({}, {}) successfully", user.getId(), email);
        } else {
            throw new UserCredentialsIsInvalidException();
        }
    };

    // ...
    public void verifyEmail(User user, String pathCode) throws CodeIsInvalidException {
        Code code = codeRepository.findByValue(pathCode);

        if (code == null) {
            throw new CodeIsInvalidException();
        }

        user.setEmailVerified(true);
        userRepository.save(user);
        logger.info("USER record update ({}, {}) SET emailverify to TRUE", user.getId(), user.getEmail());
        codeRepository.delete(code);
        logger.info("CODE record deleted ({}, {}) successfully", user.getId(), user.getEmail());

        long id = user.getId();
        String accesToken = user.getAccessToken();
        long createdAt = user.getCreatedAt();
        long expitesAt = createdAt + TokenEnum.Lifetime.REFRESH_TOKEN.getValue();

        sessionRepository.save(new Session(id, accesToken, createdAt, expitesAt));
        logger.info("SESSION created ({}, {}) successfully", user.getId(), user.getEmail());
        logger.info("EMAIL verified for USER ({}, {}) successfully", user.getId(), user.getEmail());
    };
}