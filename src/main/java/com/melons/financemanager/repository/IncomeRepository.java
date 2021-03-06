package com.melons.financemanager.repository;

import com.melons.financemanager.model.Income;
import com.melons.financemanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Integer> {
    List<Income> findAllByUser(User user);

    List<Income> findByUserAndDateBetween(User user, LocalDateTime dateStart, LocalDateTime dateEnd);
}
