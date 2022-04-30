package MiniProjects.MiniProject1;

public class MiniProject1Demo {
    public static void main(String[] args) {
        IceCream iceCream = new Sprinkles(new HotFudge(new Vanilla(2)));
        System.out.println(iceCream.getDescription() + " $" + iceCream.cost());

        IceCream iceCream1 = new WhippedCream(new Caramel(new Chocolate(1)));
        System.out.println(iceCream1.getDescription() + " $" + iceCream1.cost());

        IceCream iceCream2 = new Caramel(new Caramel(new Chocolate(2)));
        System.out.println(iceCream2.getDescription() + " $" + iceCream2.cost());
    }
}
