package account;

/**
 * Created by Ashkan Amiri, Jacaranda Perez, Iryna Gnatenko och Salem Koldzo
 * Date:  2020-11-29
 * Time:  12:22
 * Project: bankSystem
 * Copyright: MIT
 */
public enum AccountType {

    SAVING_ACCOUNT(1, "Saving account"),
    CURRENT_ACCOUNT(2, "Current account"),

    UNKNOWN(0, "Unknown");


    private final int accountType;
    private final String description;

    AccountType(Integer accountType, String description) {
        this.accountType = accountType;
        this.description = description;
    }

    public int getAccountType() {
        return accountType;
    }


    public static AccountType getAccountType(int code) {
        AccountType[] values = values();
        AccountType[] array = values;
        int length = values().length;
        for (int i = 0; i < length; i++) {
            AccountType value = array[i];
            if (value.getAccountType() == code)
                return value;
        }
        return AccountType.getAccountType(0);
    }

    @Override
    public String toString() {
        return
                "accountType=" + accountType +
                ", description='" + description + '\'' +
                '}';
    }
}
