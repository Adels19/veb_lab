package mk.ukim.finki.wp.lab.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = "/chefDetails")
public class ChefDetailsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // citam parametri
        String chefId = req.getParameter("chefId");
        String dishId = req.getParameter("dishId");

        // ako nema, da prensaocam
        if (chefId == null || chefId.trim().isEmpty() || dishId == null || dishId.trim().isEmpty()) {
            resp.sendRedirect("/dish" + (chefId != null ? "?chefId=" + chefId : ""));
            return;
        }

        // else
        chain.doFilter(request, response);
    }

}
