package POS;

public class POSSystem {
    private Sale curSale;
    private ProductCatalog catalog;
    private final int initState = 0;
    private final int newSaleState = 0;
    private final int purchaseState = 1;
    private final int payingState = 2;
    private int curState = 0;

    public void startUp() {
        catalog = new ProductCatalog();//加载产品目录
    }

    public void makeNewSale() {
        curSale = new Sale();
    }

    public void enterItem(String id, int qty) {
        ProductDescription desc = catalog.getProductDesc(id);
        curSale.makeLineItem(desc, qty);
    }

    public void endPurchase() {
        curSale.beComplete();
    }

    public void makePayment(float cash) {
        curSale.makePayment(cash);
    }

    public void finishASale() {
        curSale.finishASale();
    }

    public void run() {
        startUp();
        coordinate();
    }

    public void coordinate() {
        while (true) {
            switch (curState) {
                case newSaleState:
                    UI.show("要开始一次新的销售吗？(y/n) ");
                    String option = UI.getReturn();
                    if (option.charAt(0) == 'y') {
                        makeNewSale();
                        UI.show("ID  名称 价格\n");
                        catalog.showCatalog();
                        curState = purchaseState;
                    }
                    break;
                case purchaseState:
                    UI.show("继续加购商品吗？(y/n) ");
                    while(UI.getReturn().charAt(0) == 'y') {
                        UI.show("请输入商品ID: ");
                        String ID = UI.getID();
                        UI.show("请输入商品数量: ");
                        int qty = UI.getqty();
                        enterItem(ID, qty);
                        UI.show("继续加购商品吗？(y/n) ");
                    }
                    endPurchase();
                    curState = payingState;
                    break;
                case payingState:
                    float tot = curSale.getTotal();
                    UI.show("应付款:", tot);
                    UI.show("实付额: ");
                    makePayment(UI.getCash());
                    UI.show("找零: ", curSale.getBalance());
                    finishASale();
                    UI.show("正在打印单据......\n");
                    curState = newSaleState;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        POSSystem pos = new POSSystem();
        pos.run();
    }

}

