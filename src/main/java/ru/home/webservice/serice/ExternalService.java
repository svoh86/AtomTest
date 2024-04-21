package ru.home.webservice.serice;

import java.io.IOException;

/**
 * @author Svistunov Mikhail
 * @version 1.0
 */
public interface ExternalService {
    String getContent(String... args) throws IOException;
}
