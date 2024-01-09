package com.boot.typography.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "order", schema = "typography")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Order implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "date_start")
    private LocalDateTime dateStart;

    @Column(name = "date_end")
    private LocalDateTime dateEnd;

    @Column(name = "employee")
    private Integer employeeId;

    @Column(name = "goods")
    private Integer goodsId;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "employee",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "employee"))
    private List<Employee> employees;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "goods",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "goods"))
    private List<Goods> goods;

    @ManyToMany
    @JoinTable(name = "order_to_customer",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<Customer> customers;

}
