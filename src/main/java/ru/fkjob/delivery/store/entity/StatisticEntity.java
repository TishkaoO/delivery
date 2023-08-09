package ru.fkjob.delivery.store.entity;

import javax.persistence.*;
import lombok.*;

import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "statistic")
public class StatisticEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statistic_id;

    @Column
    private int count;

    @ManyToOne
    @JoinColumn(name = "fk_dish_id")
    private DishEntity dishEntity;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatisticEntity that))
            return false;
        return getStatistic_id().equals(that.getStatistic_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatistic_id());
    }
}
