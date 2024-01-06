package ru.fkjob.delivery.store.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dish", schema = "delivery")
public class DishEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_dish_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(name = "is_stock", nullable = false)
    private boolean isStock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_category_id")
    private CategoryEntity categoryEntity;

    @OneToOne(mappedBy = "dish", cascade = CascadeType.ALL)
    private ImageEntity image;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishEntity that = (DishEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
