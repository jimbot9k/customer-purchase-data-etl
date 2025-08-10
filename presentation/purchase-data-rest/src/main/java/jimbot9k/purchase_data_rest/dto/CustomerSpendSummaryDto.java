package jimbot9k.purchase_data_rest.dto;

import java.util.Date;

public class CustomerSpendSummaryDto {

    private String customerId;
    private String fullName;
    private String email;
    private double totalSpentAud;
    private Date firstPurchaseDate;
    private Date lastPurchaseDate;

    public CustomerSpendSummaryDto() {
    }

    public CustomerSpendSummaryDto(String customerId, String fullName, String email, double totalSpentAud, Date firstPurchaseDate, Date lastPurchaseDate) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.email = email;
        this.totalSpentAud = totalSpentAud;
        this.firstPurchaseDate = firstPurchaseDate;
        this.lastPurchaseDate = lastPurchaseDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTotalSpentAud() {
        return totalSpentAud;
    }

    public void setTotalSpentAud(double totalSpentAud) {
        this.totalSpentAud = totalSpentAud;
    }

    public Date getFirstPurchaseDate() {
        return firstPurchaseDate;
    }

    public void setFirstPurchaseDate(Date firstPurchaseDate) {
        this.firstPurchaseDate = firstPurchaseDate;
    }

    public Date getLastPurchaseDate() {
        return lastPurchaseDate;
    }

    public void setLastPurchaseDate(Date lastPurchaseDate) {
        this.lastPurchaseDate = lastPurchaseDate;
    }
}
