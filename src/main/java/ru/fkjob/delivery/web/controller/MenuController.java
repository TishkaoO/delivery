package ru.fkjob.delivery.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.fkjob.delivery.web.dto.DishDTO;
import ru.fkjob.delivery.web.service.DishService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Api(tags = "меню с информацией по блюдам")
public class MenuController {
    private final DishService dishService;

    @Autowired
    public MenuController(@Qualifier("dishServiceImpl") DishService dishService) {
        this.dishService = dishService;
    }

    @ApiOperation("Список всех блюд с отображением постранично")
    @GetMapping("/menu-info/page/{pageNo}")
    public ResponseEntity<Page<DishDTO>> getDishPaginated(@PathVariable int pageNo) {
        int pageSize = 5;
        Page<DishDTO> page = dishService.getDishByPage(pageNo, pageSize);
        return ResponseEntity.ok(page);
    }
}
