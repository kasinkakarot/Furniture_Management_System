package furniture_management;

import java.io.Serializable;

public class Furniture implements Serializable {
    private String ID;
    private String Description;
    private String Type;
    private double Price;
    private double DiscountPrice;
    private double vatPercentage;
    private boolean isImported;

    public Furniture(String ID, String description, String type, double price, double discountPrice, double vatPercentage, boolean isImported) {
        this.ID = ID;
        Description = description;
        Type = type;
        Price = price;
        DiscountPrice = discountPrice;
        this.vatPercentage = vatPercentage;
        this.isImported = isImported;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public double getDiscountPrice() {
        return DiscountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        DiscountPrice = discountPrice;
    }

    public double getVatPercentage() {
        return vatPercentage;
    }

    public void setVatPercentage(double vatPercentage) {
        this.vatPercentage = vatPercentage;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }

    public double getBillAmount() {

        double Discount = Price * DiscountPrice/100;
        double PriceAfterDiscount = Price - Discount;
        double vat = PriceAfterDiscount * vatPercentage/100;
        return PriceAfterDiscount + vat;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "ID='" + ID + '\'' +
                ", Description='" + Description + '\'' +
                ", Type='" + Type + '\'' +
                ", Price=" + Price +
                ", DiscountPrice=" + DiscountPrice +
                ", vatPercentage=" + vatPercentage +
                ", isImported=" + isImported +
                '}';
    }
}
