package kz.zhanbolat.array;

public class Application {

    public static void main(String[] args) {
        DynamicDoubleArray unlimitedArray = new DynamicDoubleArray();
        unlimitedArray.add(1.0d);
        System.out.println(unlimitedArray);
        unlimitedArray.add(20d);
        System.out.println(unlimitedArray);
        unlimitedArray.remove(0);
        System.out.println(unlimitedArray);

        DynamicDoubleArray limitedArray = new DynamicDoubleArray(1);
        limitedArray.add(2.0d);
        System.out.println(limitedArray);
        limitedArray.add(3.0d);
        limitedArray.remove(0);
        System.out.println(limitedArray);
    }
}
