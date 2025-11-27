package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Chef> chefs = new ArrayList<>();
    public static List<Dish> dishes = new ArrayList<>();

    @PostConstruct
    public void init() {
        dishes.add(new Dish("1", "Tavche Gravche", "Macedonian", 15));
        dishes.add(new Dish("2", "Burek", "Balkan", 10));
        dishes.add(new Dish("3", "Chevapi", "Balkan", 12));
        dishes.add(new Dish("4", "Ajvar", "Balkan", 8));
        dishes.add(new Dish("5", "Sarma", "Balkan", 14));

        chefs.add(new Chef(1L, "Petar", "Stojanovski", "Experienced Macedonian chef"));
        chefs.add(new Chef(2L, "Ana", "Nikoloska", "Specializes in traditional dishes"));
        chefs.add(new Chef(3L, "Marko", "Jovanovski", "Known for Balkan cuisine"));
        chefs.add(new Chef(4L, "Elena", "Petrovska", "Loves home-style cooking"));
        chefs.add(new Chef(5L, "Stefan", "Trajkovski", "Expert in regional flavors"));
    }
}
