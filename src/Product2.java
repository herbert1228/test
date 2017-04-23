public class Product2{
    double price;

    public Product2() {

    }

    public void setPrice(double aPrice){
        price = aPrice;
    }
    public double getPrice(){
        return price;
    }
    public Product2(double price){
        setPrice(price);
    }
    public static double averagePrice(Product2[] products){
        double total = 0;
        for(Product2 product : products){
            total += product.getPrice();
        }
        System.out.println(total);
        return total/products.length;
    }
    public static void main(String[] args){
        Product2[] products = {new Product2(10),
                                new DiscountedProduct(5,25),
                                    new TenDolLarProduct()};
        System.out.println(averagePrice(products));
    }
}

class DiscountedProduct extends Product2{
    private double discountPercentage;
    public void setDiscountPercentage(double aDiscountPercentage){
        discountPercentage = aDiscountPercentage;
    }
    public double getDiscountPercentage(){
        return discountPercentage;
    }
    public DiscountedProduct(double price, double discountPercentage){
        super(price);
        setDiscountPercentage(discountPercentage);
    }

    @Override
    public double getPrice(){
        return price*(1-discountPercentage/100);
    }
}

class TenDolLarProduct extends Product2{
    public TenDolLarProduct() {
        super();
    }

    @Override
    public double getPrice(){
        return 10;
    }
}