package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.service.ChefService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ChefListServlet", urlPatterns = "/listChefs")
public class ChefListServlet extends HttpServlet {

    private final ChefService chefService;

    public ChefListServlet(ChefService chefService) {
        this.chefService = chefService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        List<Chef> chefs = chefService.listChefs();

        out.println("<html>");
        out.println("<head><title>Restaurant Chefs</title></head>");
        out.println("<body>");
        out.println("<h1>Welcome to Our Restaurant</h1>");
        out.println("<h2>Choose a chef:</h2>");
        out.println("<form action='/dish' method='POST'>");

        for (Chef chef : chefs) {
            out.printf(
                    "<input type='radio' name='chefId' value='%d'> Name: %s %s, Bio: %s<br/>",
                    chef.getId(), chef.getFirstName(), chef.getLastName(), chef.getBio()
            );
        }

        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
