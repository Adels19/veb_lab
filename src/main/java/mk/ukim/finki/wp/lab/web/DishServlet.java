//package mk.ukim.finki.wp.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.model.Chef;
//import mk.ukim.finki.wp.lab.service.ChefService;
//import mk.ukim.finki.wp.lab.service.DishService;
//import org.springframework.stereotype.Component;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name = "DishServlet", urlPatterns = "/dish")
//
//@Component
//public class DishServlet extends HttpServlet {
//
//    // zavisi od
//    private final DishService dishService;
//    private final ChefService chefService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public DishServlet(DishService dishService, ChefService chefService, SpringTemplateEngine springTemplateEngine) {
//        this.dishService = dishService;
//        this.chefService = chefService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//        String chefIdParam = req.getParameter("chefId");
//        Long chefId = Long.parseLong(chefIdParam);
//
//        Chef chef = chefService.findById(chefId);
//
//        var webApp = JakartaServletWebApplication.buildApplication(getServletContext());
//        var webExchange = webApp.buildExchange(req, resp);
//        WebContext context = new WebContext(webExchange);
//
//
//        context.setVariable("chefId", chef.getId());
//        context.setVariable("chefName", chef.getFirstName() + " " + chef.getLastName());
//        context.setVariable("dishes", dishService.listDishes());
//
//        springTemplateEngine.process("dishesList.html", context, resp.getWriter());
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        resp.sendRedirect("/listChefs");
//    }
//}
