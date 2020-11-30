package account;

/**
 * Created by Ashkan Amiri
 * Date:  2020-11-29
 * Time:  12:22
 * Project: bankSystem
 * Copyright: MIT
 */
public enum AccountType {

    SAVING_ACCOUNT(1, "Saving account"),
    CURRENT_ACCOUNT(2, "Current account"),

    UNKNOWN(0, "Unknown");


    private Integer accountType;
    private String description;


    AccountType(Integer accountType, String description) {
        this.accountType = accountType;
        this.description = description;
    }

    public Integer getaccountType() {
        return accountType;
    }

    public String getDescription() {
        return description;
    }

    public static AccountType getAccountType(int code) {
        AccountType[] values = values();
        AccountType[] array = values;
        int length = values().length;
        for (int i = 0; i < length; i++) {
            AccountType value = array[i];
            if (value.getaccountType() == code)
                return value;

        }
        return AccountType.getAccountType(0);
    }
}
