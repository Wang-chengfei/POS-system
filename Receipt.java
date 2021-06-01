package POS;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipt {
    private String str;
    private Date date = new Date(System.currentTimeMillis());
    private SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");

    public void print(Sale sale){
        transToString(sale);
        writeToTxt();
    }

    private void transToString(Sale sale) {
        List<SaleLineItem> lineItems = sale.getSaleLineItems();
        str = "红旗连锁5111分店\n<欢迎光临>\n\n";
        str += formatter.format(date);
        str += "\nID  名称 单价 数量 价格\n";
        for(SaleLineItem sli:lineItems)   {
            str += sli.getPd().getID() + "  " + sli.getPd().getName() + "  "
                    + sli.getPd().getPrice() + "  " + sli.getQty() + "  " +
                    sli.getPd().getPrice() * sli.getQty() + "\n";
        }
        str += "\n应付款: " + sale.getTotal() + "\n";
        str += "实付款: " + sale.getPay().getCash() + "\n";
        str += "找零:" + sale.getBalance() + "\n";
    }

    private void writeToTxt() {
        String filePath = "C:\\Users\\cd\\Desktop\\" + formatter.format(date) + ".txt";
        FileWriter fileWriter = null;
        try {
        fileWriter  = new FileWriter(filePath);
        fileWriter.write(str);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
