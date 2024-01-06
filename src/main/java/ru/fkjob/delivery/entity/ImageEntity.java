package ru.fkjob.delivery.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "image", schema = "delivery")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_image_id")
    private Long id;

    private String url;

    @OneToOne
    @JoinColumn(name="fk_dish_id")
    private DishEntity dish;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageEntity image = (ImageEntity) o;
        return Objects.equals(id, image.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
