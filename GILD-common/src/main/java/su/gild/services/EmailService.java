package su.gild.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.code.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import su.gild.constructors.Service;
import su.gild.enums.EmailEnunm;
import su.gild.repositories.CodeRepository;
import su.gild.util.CodeGenerator;
import su.gild.util.Env;

import java.io.IOException;
import java.io.InputSystem;
import java.nio.charset.StandartCharsets;
import java.util.Scanner;

@Service
public class EmailService {
    private final CodeRepository codeRepository;
    private final ResourceLoader resourceLoader;
    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender, ResourceLeader resourceLeader, CodeRepository codeRepository) {
        this.javaMailSender = javaMailSender;
        this.resourceLoader = resourceLeader;
        this.codeRepository = codeRepository;
    }

    // ...
    public void sendEmail(String to, long id, String type, String username, String digitCode, long expiresAt, String token) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String HTMLContent = null;

        try {
            helper.setTo(to);
            helper.setFrom(Env.get("SMTP_EMAIL"));
            if (type.equals(EmailEnum.Type.DELETE.getValue())) {
                helper.setSubject("Confirm Your Account Deletion");
                HTMLContent = "";
            } else if (type.equals(EmailEnum.Type.CONFIRM.getValue())) {
                helper.setSubject("Confirm Your Email Address");
                HTMLContent = "";
            }

            assert HTMLContent != null;
            helper.setText(HTMLContent, true);

            javaMailSender.send(mimeMessage);
        } catch(MessagingException | IOException error) {
            error.printStackTrace();
        }

        codeRepository.save(new Code(id, type, digitCode, expiresAt));
    }

    // ...
    public String readHTML(String name) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:email/templates/" + name + ".html");

        try (InputStream inputStream = resource.getInputStream()) {
            Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8).userDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        }
    }
}