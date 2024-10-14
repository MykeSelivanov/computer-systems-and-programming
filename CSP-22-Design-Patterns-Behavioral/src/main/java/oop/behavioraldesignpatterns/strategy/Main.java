package oop.behavioraldesignpatterns.strategy;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("Book", 10);
        Item item2 = new Item("Cup", 7);

        cart.addItem(item1);
        cart.addItem(item2);

        // pay with Paypal
        cart.pay(new PaypalStrategy("myemail@example.com", "mypassword"));

        // pay with credit card
        cart.pay(new CreditCardStrategy("Name Lastname", "1234 5678 9012 3456", "714", "12/27"));
    }
}
