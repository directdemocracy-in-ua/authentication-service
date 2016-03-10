package ua.in.directdemocracy.instructucture.authentication.hash;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import ua.in.directdemocracy.domain.authentication.service.HashService;

public class JCEHashService implements HashService {
    
    private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");
    
    public JCEHashService() {
        createDigest();
    }
    
    @Override
    public String fromString(String value) {
        MessageDigest digest = createDigest();
        digest.update(UTF8_CHARSET.encode(value));
        byte[] hash = digest.digest();
        return Base64.getEncoder().encodeToString(hash);
    }

    private MessageDigest createDigest() {
        try {
            return MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
