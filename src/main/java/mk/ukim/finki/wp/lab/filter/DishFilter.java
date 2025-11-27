package mk.ukim.finki.wp.lab.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebInitParam;

import java.io.IOException;

// za direktno url otvaranje
@WebFilter(urlPatterns = {"/dish"})
public class DishFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // proverka na parametar
        String chefId = req.getParameter("chefId");

        if (chefId == null || chefId.trim().isEmpty()) {
            resp.sendRedirect("/listChefs");
            return;
        }

        // Ako e vo red, prodolzi
        chain.doFilter(request, response);
    }
}
