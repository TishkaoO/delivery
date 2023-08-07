package ru.fkjob.delivery.web.dto.mapper;

import org.springframework.stereotype.Component;
import ru.fkjob.delivery.store.entity.DishEntity;
import ru.fkjob.delivery.web.dto.DishDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class DishMapperImpl implements DishMapper {

    @Override
    public DishDTO toDto(DishEntity entity) {
        return DishDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .build();
    }

    @Override
    public List<DishDTO> toDto(List<DishEntity> entity) {
        List<DishDTO> dtos = new ArrayList<>();
        for (DishEntity tmp : entity) {
            DishDTO dto = new DishDTO(tmp.getId(), tmp.getName(), tmp.getPrice());
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public DishEntity toEntity(DishDTO dto) {
        return DishEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .build();
    }
}
