package com.boot.typography.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@Table(name = "goods", schema = "typography")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Goods {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "good_name")
    private String name;

    @Column(name = "good_cost")
    private Integer cost;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "material")
    private String material;

    @Column(name = "good_options")
    private String options;

}
