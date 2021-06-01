package POS;

public class SaleLineItem {
    private int qty;
    private ProductDescription pd;

    public SaleLineItem(ProductDescription desc, int qty) {
        this.qty = qty;
        this.pd = desc;
    }

    public float getSubtotal() {
        return qty * pd.getPrice();
    }

    public int getQty() {
        return qty;
    }

    public ProductDescription getPd() {
        return pd;
    }

}
