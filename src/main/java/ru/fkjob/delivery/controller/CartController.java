package ru.fkjob.delivery.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fkjob.delivery.dto.cart.CartDishInfoDto;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cart")
@Api(tags = "Для работы c корзиной")
@RequiredArgsConstructor
public class CartController {

    @GetMapping
    public List<CartDishInfoDto> summary() {
        return new ArrayList<>();
    }
}
