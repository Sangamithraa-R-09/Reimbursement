package com.reimbursement.project.repository;

import com.reimbursement.project.entity.Enum.ExpenseStatus;
import com.reimbursement.project.entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses,Long> {
    List<Expenses> findByExpenseStatus(ExpenseStatus expenseStatus);

    @Query(value= "SELECT expenses.expense_status, COUNT(*) as ExpensesStatusCount FROM expenses GROUP BY expenses.expense_status", nativeQuery = true)
    List<Map<String,Object>> getExpensesStatusCount();

    Expenses save(Expenses expenses);

   // List<Expenses> saveAll(List<Expenses> expensesList);

    Optional<Expenses> findById(Long id);
}
