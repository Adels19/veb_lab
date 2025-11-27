package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.DishRepository;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class DishServiceImpl implements DishService {

    // treba da zavisi od DishRepository
    private final DishRepository dishRepository;

    private static final AtomicLong counter = new AtomicLong(1);

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> listDishes() {
        return dishRepository.findAll();
    }

    @Override
    public Dish findByDishId(String dishId) {
        return dishRepository.findByDishId(dishId);
    }

    @Override
    public Dish findById(Long id) {
        return dishRepository.findById(id).orElse(null);
    }

    @Override
    public Dish create(String dishId, String name, String cuisine, int preparationTime){
        Long newId = counter.getAndIncrement();
        Dish dish = new Dish(dishId, name, cuisine, preparationTime, newId);
        return dishRepository.save(dish);
    }

    @Override
    public Dish update(Long id, String dishId, String name, String cuisine, int preparationTime) {
        Dish existingDish = dishRepository.findById(id).orElse(null);
        if(existingDish != null){
            existingDish.setDishId(dishId);
            existingDish.setName(name);
            existingDish.setCuisine(cuisine);
            existingDish.setPreparationTime(preparationTime);
            return dishRepository.save(existingDish);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        dishRepository.deleteById(id);
    }

}