
import java.util.List;

public class MyBox implements IBox {

    @Override
    public void f1(List<Box> list) {
        for (Box box : list) {
            if (box.getCode().charAt(0) == 'K') {
                box.setPrice(box.getPrice() * 1.1);
            }
        }
    }
    // đếm phần tử lớn hơn price X
    @Override
    public int f2(List<Box> list, double d) {
        int count = 0;
        for (Box box : list) {
            if (box.getPrice() > d) {
                count++;
            }
        }

        return count;
    }

    @Override
    // xóa object tiếp theo của object có minPrice, nếu là Object cuối cùng thì ko xóa 
    public void f3(List<Box> list) {
        int minIndex = 0;
        double minPrice = list.get(0).getPrice();

        for (int i = 0; i < list.size(); i++) {
            double currentPrice = list.get(i).getPrice();
            if (currentPrice < minPrice) {
                minPrice = currentPrice;
                minIndex = i;
            }

        }

        if (minIndex < list.size() - 1) {

            list.remove(minIndex + 1);

        }

    }
}
