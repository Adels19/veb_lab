package mk.ukim.finki.wp.lab.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Dish {
    private String dishId;
    private String name;
    private String cuisine;
    private int preparationTime;

    //dodavam
    private Long id;
    private static Long counter = 0L;

    public Dish(String dishId, String name, String cuisine, int preparationTime) {
        this.dishId = dishId;
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;
        this.id = ++counter;    // zgolemuvam counter i go dodeluvam kako unikatno id
    }

    public Dish(String dishId, String name, String cuisine, int preparationTime, Long newId) {
        this.dishId = dishId;
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;
        this.id = ++counter;
        this.id = newId;
    }

}