package controller;

import model.Account;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LoginController {
    private static final String ACCOUNTS_CSV = "src/data/accounts.csv";

    public static boolean authenticate(String username, String password) {
        List<Account> accounts = loadAccounts();

        for (Account acc : accounts) {
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private static List<Account> loadAccounts() {
        List<Account> accounts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ACCOUNTS_CSV))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    accounts.add(new Account(parts[0].trim(), parts[1].trim()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }
}
