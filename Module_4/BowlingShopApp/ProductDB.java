package Module_4.BowlingShopApp;

public class ProductDB {
    
	public static GenericQueue<Product> getProducts(String code) {

        GenericQueue<Product> balls = new GenericQueue<Product>();


        if (code.equalsIgnoreCase("b")) {
            for (int i = 1; i <= 5; i++) {
                Ball ball = new Ball();
                ball.setCode("B" + i);
                ball.setDescription("Bowling Ball " + i);
                ball.setPrice(50.0 * i);
                ball.setColor("Color" + i);
                balls.enqueue(ball);
            }
        } else if (code.equalsIgnoreCase("s")) {
            for (int i = 1; i <= 5; i++) {
                Shoe shoe = new Shoe();
                shoe.setCode("S" + i);
                shoe.setDescription("Bowling Shoe " + i);
                shoe.setPrice(30.0 * i);
                shoe.setSize(5 + i);
                balls.enqueue(shoe);
            }
        } else if (code.equalsIgnoreCase("a")) {
            for (int i = 1; i <= 3; i++) {
                Bag bag = new Bag();
                bag.setCode("A" + i);
                bag.setDescription("Bowling Bag " + i);
                bag.setPrice(20.0 * i);
                bag.setType("Type" + i);
                balls.enqueue(bag);
            }
        }

        return balls;
    }

}
