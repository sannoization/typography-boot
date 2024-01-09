package com.boot.typography.repository;

import com.boot.typography.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Modifying
    @Query(nativeQuery = true, value = """
            delete from typography."order" o
            where o.id = :id
            """)
    void deleteById(@Param("id") Integer id);

}
