package com.boot.typography.repository;

import com.boot.typography.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Modifying
    @Query(nativeQuery = true, value = """
            delete from typography.customer c
            where c.id = :id
            """)
    void deleteById(@Param("id") Integer id);

}
