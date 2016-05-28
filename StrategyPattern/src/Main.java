public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.showCase();
    }

    public void showCase(){
        Customer customerC = new CCustomer();
        customerC.discount();
        customerC.setDiscountable(new MomenyDiscount());
        customerC.discount();
    }

    public class Customer {
        private String name ;
        private Discountable discountable;

        public Customer(String name, Discountable discountable){
            this.name = name;
            this.discountable = discountable;
        }

        public void setDiscountable(Discountable discountable) {
            this.discountable = discountable;
        }

        public void discount() {
            discountable.discount();
        }
    }

    public class ACustomer extends Customer {
        public ACustomer(){
            super("ACustomer", new MomenyDiscount());
        }
    }

    public class BCustomer extends Customer {
        public BCustomer(){
            super("BCustomer", new MomenyDiscount());
        }
    }

    public class CCustomer extends Customer{
        public CCustomer(){
            super("CCustomer", new BonusPointDiscount());
        }
    }

    public class DCustomer extends Customer{
        public DCustomer(){
            super("DCustomer", new BonusPointDiscount());
        }
    }

    public interface Discountable{
        void discount();
    }

    public class MomenyDiscount implements Discountable{
        @Override
        public void discount() {
            System.out.println("Money Discount");
        }
    }

    public class BonusPointDiscount implements Discountable{
        @Override
        public void discount() {
            System.out.println("Bonus Point Discount");
        }
    }
}

