package ru.fkjob.delivery.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.fkjob.delivery.dto.category.CategoryDto;
import ru.fkjob.delivery.dto.dish.DishDto;
import ru.fkjob.delivery.dto.category.CategoryInfoDto;
import ru.fkjob.delivery.dto.dish.DishInfoDto;
import ru.fkjob.delivery.dto.image.ImageDishDto;
import ru.fkjob.delivery.service.CategoryService;
import ru.fkjob.delivery.service.DishService;
import ru.fkjob.delivery.service.impl.ImageDishServiceImpl;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/menu-info")
@Api(tags = "меню с информацией по блюдам")
@RequiredArgsConstructor
public class MenuController {
    private final DishService dishService;
    private final CategoryService categoryService;
    private final ImageDishServiceImpl imageDishService;

    @GetMapping("/dishes")
    @Operation(summary = "Список всех блюд")
    public List<DishDto> getDishes() {
        return dishService.getDishList();
    }

    @GetMapping("category/dish/{id}")
    @Operation(summary = "Получить информацию по блюду")
    public DishInfoDto getDishById(@ApiParam("индентификатор блюда") @PathVariable(name = "id") final Long id) {
        return dishService.getDishEntityById(id);
    }

    @PostMapping("/category/dish/create")
    @Operation(summary = "создать новое блюдо")
    public DishInfoDto getDishById(@Valid @RequestBody DishInfoDto dishInfoDto, @RequestParam(name = "categoryId") final Long categoryId) {
        return dishService.save(dishInfoDto, categoryId);
    }

    @GetMapping("/category/dish")
    @Operation(summary = "Получить информацию по блюду по названию")
    public List<DishDto> getDishByName(@RequestParam(name = "name") final String name) {
        return dishService.getDishByName(name);
    }

    @DeleteMapping("/category/dish")
    @Operation(summary = "Удалить блюдо")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void getDishByName(@RequestParam(name = "dishId") final Long dishId) {
        dishService.deleteDishEntityById(dishId);
    }

    @PutMapping(value = "/category/{dishId}/dish")
    @Operation(summary = "редактировать блюдо")
    public Long updateDish(@PathVariable(name = "dishId") final Long dishId, @Valid @RequestBody final DishInfoDto dto) {
        return dishService.updateDish(dishId, dto);
    }

    @GetMapping("/category")
    @Operation(summary = "Получить все категории")
    public List<CategoryDto> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/category/{id}")
    @Operation(summary = "Получить информацию по категории")
    public CategoryInfoDto getCategoryById(@PathVariable(name = "id") final Long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/categoryes-dish")
    @Operation(summary = "Список всех категорий с блюдами")
    public List<CategoryInfoDto> getCategoryDishes() {
        return categoryService.getAllCategoryDishes();
    }

    @GetMapping("/dishes-isStock")
    @Operation(summary = "Список всех блюд")
    public List<DishDto> getDishesByIsStock() {
        return dishService.getDishByIsStock();
    }

    @GetMapping(value = "/{dishId}/image")
    @Operation(summary = "Получение фотографии блюда")
    public String deleteImage(@PathVariable("dishId") final Long dishId) {
      return imageDishService.getImageByDishId(dishId).getUrl();
    }

}
