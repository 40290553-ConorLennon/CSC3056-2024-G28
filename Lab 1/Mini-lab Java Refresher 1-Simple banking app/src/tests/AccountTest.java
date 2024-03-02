package tests;
import model.Account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Author: Conor Lennon and Benjamin Millis
 * This was done by both of us together with IntelliJs code with me plugin.
 */
public class AccountTest {

    public static void testConstructor() throws ParseException {
        String testAccountNumber = "1234-5678";
        String testUsernameOfAccountHolder = "jeff@gmail.com";
        String testAccountType = "Standard"; // "Standard" or "Saving"
        Date testAccountOpeningDate = new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019");
        Account testAccount = new Account(testAccountNumber, testUsernameOfAccountHolder, testAccountType, testAccountOpeningDate);

        assert testAccount.getAccount_number() == testAccountNumber;
        assert testAccount.getUsername_of_account_holder() == testUsernameOfAccountHolder;
        assert testAccount.getAccount_type() == testAccountType;
        assert testAccount.getAccount_opening_date() == testAccountOpeningDate;
    }

    public static void testSetters() throws ParseException {
        String testAccountNumber = "1234-5678";
        String testUsernameOfAccountHolder = "jeff@gmail.com";
        String testAccountType = "Standard"; // "Standard" or "Saving"
        Date testAccountOpeningDate = new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019");

        Account testAccount = new Account("test", "test", "test",
                new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2022"));

        testAccount.setAccount_number(testAccountNumber);
        testAccount.setUsername_of_account_holder(testUsernameOfAccountHolder);
        testAccount.setAccount_type(testAccountType);
        testAccount.setAccount_opening_date(testAccountOpeningDate);

        assert testAccount.getAccount_number() == testAccountNumber;
        assert testAccount.getUsername_of_account_holder() == testUsernameOfAccountHolder;
        assert testAccount.getAccount_type() == testAccountType;
        assert testAccount.getAccount_opening_date() == testAccountOpeningDate;
    }

    public static void main(String[] args) throws ParseException {
        testConstructor();
        testSetters();
    }

}
