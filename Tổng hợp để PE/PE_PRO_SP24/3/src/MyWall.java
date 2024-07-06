
import java.util.Collections;
import java.util.List;

public class MyWall implements IWall{

    @Override
    public int f1(List<Wall> t) {
         int minArea = Integer.MAX_VALUE;
         for(int i = 0 ; i < t.size(); i++){
             if(squareNumber(t.get(i).getPlace().length()) && t.get(i).getPlace().length() > 1 && t.get(i).getArea() < minArea){
                 minArea = t.get(i).getArea();
             }
         }
         return minArea;
    }

    @Override
    public void f2(List<Wall> t) {
         Collections.swap(t, 3, 5);
    }

    @Override
    public void f3(List<Wall> t) {
         int minAreas = Integer.MAX_VALUE;
         int indexAreas = 0;
         for(int i = 0; i < t.size(); i++){
             if(t.get(i).getArea() < minAreas){
                 minAreas = t.get(i).getArea();
                 indexAreas = i;
             }
         }
        Wall firstIndex = t.get(indexAreas);
        t.set(0, firstIndex);
    }

    private boolean squareNumber(int length) {
        int sqrt = (int)Math.sqrt(length);
        return sqrt * sqrt == length;
    }



}