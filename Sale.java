package POS;
import java.util.List;
import java.util.ArrayList;

public class Sale {
    private List<SaleLineItem> lineItems = new ArrayList<SaleLineItem>();
    private boolean isComplete = false;
    private Payment pay;

    public void makeLineItem(ProductDescription desc, int qty) {
        lineItems.add(new SaleLineItem( desc, qty));
    }
    public void beComplete(){
        isComplete = true;
    }
    public float getTotal(){
        float sumUp = 0;
        for(SaleLineItem sli:lineItems)   {
            sumUp +=sli.getSubtotal();
        }
        return sumUp;
    }

    public void finishASale(){
        Receipt receipt = new Receipt();
        receipt.print(this);
    }

    public  void makePayment(float cash){

        pay = new Payment(cash);
    }

    public float getBalance()     {
        return pay.getCash() - getTotal();
    }

    public List<SaleLineItem> getSaleLineItems() {
        return lineItems;
    }

    public Payment getPay() {
        return pay;
    }

}
