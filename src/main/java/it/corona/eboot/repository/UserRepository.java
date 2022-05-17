package it.corona.eboot.repository;

import it.corona.eboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE u.status = 'ACTIVE'")
    List<User> findByStatus();

    @Query("SELECT u FROM User u JOIN Order o ON o.user = u WHERE o.amount = :amount")
    List<User> findByOrdersGreaterThan(@Param("amount") Double amount);


}
