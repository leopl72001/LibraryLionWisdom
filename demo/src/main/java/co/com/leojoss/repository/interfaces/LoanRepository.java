package co.com.leojoss.repository.interfaces;

import java.util.List;

import co.com.leojoss.model.Loan;
import co.com.leojoss.model.User;

public interface LoanRepository {
    Loan save(Loan loan);

    Loan findById(String id);

    List<Loan> findByUser(User user);
}
