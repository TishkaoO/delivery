package ru.fkjob.delivery.rest.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDto {

    private Long id;

    private String name;

    private Double price;
}
