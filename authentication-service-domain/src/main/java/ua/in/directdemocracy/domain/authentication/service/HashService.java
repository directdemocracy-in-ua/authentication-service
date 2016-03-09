package ua.in.directdemocracy.domain.authentication.service;

public interface HashService {

    String createHash(String login, String password);
}
