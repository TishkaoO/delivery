package ru.fkjob.delivery.rest.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.fkjob.delivery.rest.dto.category.CategoryDto;
import ru.fkjob.delivery.rest.dto.category.CategoryInfoDto;
import ru.fkjob.delivery.rest.dto.dish.DishDto;
import ru.fkjob.delivery.rest.dto.dish.DishInfoDto;
import ru.fkjob.delivery.rest.service.CategoryService;
import ru.fkjob.delivery.rest.service.DishService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/menu-info")
@Api(tags = "меню с информацией по блюдам")
@RequiredArgsConstructor
public class MenuController {

    private final DishService dishService;
    private final CategoryService categoryService;

    @GetMapping("/dish/page/{pageNo}")
    @Operation(summary = "Список всех блюд с отображением постранично")
    public Page<DishDto> getDishPaginated(@PathVariable(name = "pageNo") int pageNo) {
        int pageSize = 5;
        return dishService.getDishByPage(pageNo, pageSize);
    }

    @GetMapping("category/dish/{id}")
    @Operation(summary = "Получить информацию по блюду")
    public DishInfoDto getDishById(@PathVariable(name = "id") Long id) {
        return dishService.getDishEntityById(id);
    }

    @PostMapping("/category/dish/create")
    @Operation(summary = "создать новое блюдо")
    public DishInfoDto getDishById(@RequestBody DishInfoDto dishInfoDto) {
        return dishService.save(dishInfoDto);
    }

    @GetMapping("/category/dish")
    @Operation(summary = "Получить информацию по блюду по названию")
    public DishDto getDishByName(@RequestParam(name = "name") String name) {
      return dishService.getDishByName(name);
    }

    @DeleteMapping("/category/dish")
    @Operation(summary = "Удалить блюдо")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void getDishByName(@RequestParam(name = "dishId") Long dishId) {
       dishService.deleteDishEntityById(dishId);
    }

    @PutMapping("/category/dish/{id}")
    @Operation(summary = "редактировать блюдо")
    public Long updateDish(@PathVariable(name = "id") Long dishId, @RequestBody DishInfoDto dto) {
       return dishService.updateDish(dishId, dto);
    }

    @GetMapping("/category")
    @Operation(summary = "Получить все категории")
    public List<CategoryDto> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/category/{id}")
    @Operation(summary = "Получить информацию по категории")
    public CategoryInfoDto getCategoryById(@PathVariable(name = "id") Long id) {
        return categoryService.getCategoryById(id);
    }

}
