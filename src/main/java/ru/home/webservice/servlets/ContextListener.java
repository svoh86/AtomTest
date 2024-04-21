package ru.home.webservice.servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import ru.home.webservice.cache.Cache;

/**
 * @author Svistunov Mikhail
 * @version 1.0
 */
@WebListener
public class ContextListener implements ServletContextListener {
    private Cache cache;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        this.cache = new Cache();
        servletContext.setAttribute("cache", cache);
    }
}
