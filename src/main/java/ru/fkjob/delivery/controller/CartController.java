package ru.fkjob.delivery.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.fkjob.delivery.dto.cart.CartDishInfoDto;
import ru.fkjob.delivery.service.CartService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cart")
@Api(tags = "Для работы c корзиной")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PatchMapping("/delete")
    public List<CartDishInfoDto> updateItemsById(@RequestParam(value = "dishIds") List<Long> dishIds) {
        return new ArrayList<>();
    }

    @DeleteMapping("/delete")
    public void deleteDishFromCart(@RequestParam(value = "dishId")Long dishId, @RequestParam(value = "cartId")Long cartId) {
        cartService.deleteDishFromCart(dishId, cartId);
    }

}
