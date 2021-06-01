package POS;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class ProductCatalog {
    private Map<String, ProductDescription> descriptions = new HashMap <String, ProductDescription>();

    public ProductDescription getProductDesc(String id) {
        return descriptions.get(id);
    }

    public ProductCatalog() {
        loadCatalog();
    }

    public void showCatalog() {
        for (Entry<String, ProductDescription> entry : descriptions.entrySet()) {
            UI.show(entry.getKey() + " ");
            ProductDescription description = entry.getValue();
            UI.show(description.getName() + " " + description.getPrice() + "\n");
        }
    }

    private void loadCatalog() {
        //加载商品信息项
        String id1 = new String("100");
        ProductDescription desc1
                = new ProductDescription(id1, "辣条", 1.5f);
        descriptions.put(id1, desc1);

        String id2 = new String("101");
        ProductDescription desc2
                = new ProductDescription(id2, "面包", 3.0f);
        descriptions.put(id2, desc2);

        String id3 = new String("102");
        ProductDescription desc3
                = new ProductDescription(id3, "雪碧", 3.0f);
        descriptions.put(id3, desc3);

        String id4 = new String("103");
        ProductDescription desc4
                = new ProductDescription(id4, "可乐", 2.5f);
        descriptions.put(id4, desc4);

        String id5 = new String("104");
        ProductDescription desc5
                = new ProductDescription(id5, "牛奶", 3.0f);
        descriptions.put(id5, desc5);

        String id6 = new String("105");
        ProductDescription desc6
                = new ProductDescription(id6, "花生", 2.0f);
        descriptions.put(id6, desc6);
    }

}
