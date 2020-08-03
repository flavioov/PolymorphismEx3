package Entities;

public class ImportedProduct extends Product {
    private Double customFee;

    public ImportedProduct(String name, Double price, Double customFee) {
        super(name, price);
        this.customFee = customFee;
    }

    @Override
    public String priceTag() {
        return getName() + " $ " + String.format("%.2f", getPrice() + customFee) +
                " (custom fee: $ " + customFee + ")";
    }
}
