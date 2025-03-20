package co.com.leojoss.utils;

import java.util.ArrayList;
import java.util.List;

import co.com.leojoss.model.Loan;
import co.com.leojoss.model.User;
import co.com.leojoss.repository.interfaces.LoanRepository;

public class LoanRepositoryImpl implements LoanRepository {
    private List<Loan> loans = new ArrayList<>();

    @Override
    public Loan save(Loan loan) {
        loans.add(loan);
        return loan;
    }

    @Override
    public Loan findById(String id) {
        for (Loan loan : loans) {
            if (loan.getUser().getId().equals(id)) {
                return loan;
            }
        }
        return null;

    }

    @Override
    public List<Loan> findByUser(User user) {
        List<Loan> userLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getUser().equals(user)) {
                userLoans.add(loan);
            }
        }
        return userLoans;
    }

}
