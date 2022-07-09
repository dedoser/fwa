package edu.school21.cinema.listeners;

import edu.school21.cinema.config.WebAppConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FwaContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("applicationContext",
                new AnnotationConfigApplicationContext(WebAppConfiguration.class));
    }
}
