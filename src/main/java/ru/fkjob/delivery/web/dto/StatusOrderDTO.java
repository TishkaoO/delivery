package ru.fkjob.delivery.web.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatusOrderDTO {
    private Long id;
    private String name;
}
