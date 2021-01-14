package proiectpwtj.demo.model;

public class PriceCategory {

    private int priceCategoryId;
    private String name;
    private Double discount;


    public PriceCategory(){}
    public PriceCategory(int priceCategoryId, String name, Double discount) {
        this.priceCategoryId = priceCategoryId;
        this.name = name;
        this.discount = discount;
    }

    public int getPriceCategoryId() {
        return priceCategoryId;
    }

    public void setPriceCategoryId(int priceCategoryId) {
        this.priceCategoryId = priceCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
