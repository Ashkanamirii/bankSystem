package account;

/**
 * Created by Ashkan Amiri, Jacaranda Perez, Iryna Gnatenko och Salem Koldzo
 * Date:  2020-11-29
 * Time:  12:22
 * Project: bankSystem
 * Copyright: MIT
 */
public enum AccountTypeEnum {

    SAVING_ACCOUNT(1, "Saving account"),
    CURRENT_ACCOUNT(2, "Current account"),
    DEPOSIT(3, "1: Make a deposit"),
    WITHDRAW(4, "2: Withdraw"),
    TRANSFER(5, "3: Make a transfer"),
    HISTORY(6, "4: Check your transactions' history"),
    CHECK_BALANCE(7, "5: Check your balance"),
    UPDATE_INFO(8, "6: Update your personal information"),
    LOGOUT(9, "0: Log out"),


    UNKNOWN(0, "Unknown");


    private final int accountType;
    private final String description;

    AccountTypeEnum(Integer accountType, String description) {
        this.accountType = accountType;
        this.description = description;
    }

    public int getAccountType() {
        return accountType;
    }

    public String getDescription() {
        return description;
    }

    public static AccountTypeEnum getAccountType(int code) {
        AccountTypeEnum[] values = values();
        AccountTypeEnum[] array = values;
        int length = values().length;
        for (int i = 0; i < length; i++) {
            AccountTypeEnum value = array[i];
            if (value.getAccountType() == code)
                return value;
        }
        return AccountTypeEnum.getAccountType(0);
    }
}