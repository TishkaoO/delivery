package ru.fkjob.delivery.rest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fkjob.delivery.rest.dto.DishDto;
import ru.fkjob.delivery.rest.service.DishService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/menu-info")
@Api(tags = "меню с информацией по блюдам")
public class MenuController {
    private final DishService dishService;

    @Autowired
    public MenuController(@Qualifier("dishServiceImpl") DishService dishService) {
        this.dishService = dishService;
    }

    @ApiOperation("Список всех блюд с отображением постранично")
    @GetMapping("/dish/page/{pageNo}")
    public ResponseEntity<Page<DishDto>> getDishPaginated(@PathVariable int pageNo) {
        int pageSize = 5;
        Page<DishDto> page = dishService.getDishByPage(pageNo, pageSize);
        return ResponseEntity.ok(page);
    }
}
