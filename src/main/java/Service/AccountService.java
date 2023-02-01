package Service;

import Model.Account;
import DAO.AccountDAO;

import java.util.List;

public class AccountService {
    AccountDAO accountDAO;

    public AccountService(){
        accountDAO = new AccountDAO();
    }

    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    //actual logic under here:
    public List<Account> getAllAccounts(Account account){
        return accountDAO.getAllAccounts();
    }

    public Account addAccount(Account account){
        return accountDAO.insertAccount(account);
    }
}