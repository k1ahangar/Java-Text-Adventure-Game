import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    static Student player;


    public static void main(String[] args) {
        // asking for user's name for customizing experience
        System.out.println("What is your name?");
        player = new Student(scanner.nextLine());
        System.out.println("Welcome Dear "+player.getName());

        // game dialog
        System.out.println("Here is PJAIT university and you are a Computer Science Student! ");
        System.out.println("your challenge is balancing between your normal life and university!");
        System.out.println("*-*-*-*-anytime you can write hint to receive instruction of game-*-*-*-*");
        // defining locations
        Location<Integer> cafeteria = new Location<>("Cafeteria", null);
        Location<Integer> onlineShop = new Location<>("SaturnStore", null);
        Location<Integer> examHall = new Location<>("Exam Hall", 10);
        Location<Integer> library = new Location<>("Library", null);
        Location<Integer> mainHall = new Location<>("MainHall", null);


      // defining directions from Main hall
        mainHall.addExit("west", library);
        mainHall.addExit("east", cafeteria);
        mainHall.addExit("north", onlineShop);
        mainHall.addExit("south", examHall);
//definition of exit from current location for coming back to main hall
        examHall.addExit("north", mainHall );
        onlineShop.addExit("south", mainHall);
        cafeteria.addExit("west", mainHall);
        library.addExit("east", mainHall);


// definition of studying equipments
        Equipment javaNote = new Equipment("JavaNote", 3,22);
        Equipment mathBook = new Equipment("MathBook", 10,48);
        Equipment physicsBook = new Equipment("PhysicsBook", 5,72);
        Equipment scienceBook = new Equipment("ScienceBook", 2,81);

// definition of exam pass
        Key examPass = new Key("Exam Pass", 0,10);

// definition of cafeteria items
        Booster coffeeDrink=new Booster("Coffee",10,1);
        Booster energyDrink=new Booster("Energy Drink",10,0.70);
        Booster water=new Booster("Water",10,0.50);
        Booster cake=new Booster("Cake",10,2.2);
        Booster tea=new Booster("Tea",10,1.5);

// definition of onlineShop items
        earning storeItem1 = new earning("iPhone16", 10,150);
        earning storeItem2 = new earning("screen protector", 3,10);
        earning storeItem3 = new earning("phoneCase", 1,3.20);
        earning storeItem4 = new earning("AppleWatch", 3,50.5);
        earning storeItem5 = new earning("lensProtector", 4,3.50);

//adding defined item to cafeteria
        cafeteria.addItem(energyDrink);
        cafeteria.addItem(coffeeDrink);
        cafeteria.addItem(cake);
        cafeteria.addItem(tea);
        cafeteria.addItem(water);

//adding defined item to library
        library.addItem(javaNote);
        library.addItem(mathBook);
        library.addItem(physicsBook);
        library.addItem(scienceBook);
        library.addItem(examPass);
//adding defined item to onlineShop
        onlineShop.addItem(storeItem1);
        onlineShop.addItem(storeItem2);
        onlineShop.addItem(storeItem3);
        onlineShop.addItem(storeItem4);
        onlineShop.addItem(storeItem5);

//definition of characters
        Bufet bufet = new Bufet("University Bufet", 0);
        Exam exam = new Exam("Math Exam", 10);

        //adding defined characters tto where belongs
        cafeteria.addCharacter(bufet);
        examHall.addCharacter(exam);

// setting current location when player starting game
        player.setCurrentLocation(mainHall);
        player.getCurrentLocation().describe();
       // skipping white space, user actions, managing undefined actions
        while (true) {
            System.out.print("\n> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Thanks for playing!");
                break;
            } else if (input.equalsIgnoreCase("look")) {
                player.getCurrentLocation().describe();
            } else if (input.equalsIgnoreCase("inventory")) {
                player.desInventory();
            } else if (input.startsWith("pickup ")) {
                String itemName = input.substring(7).trim();
                pickUpItem(itemName);
            } else if (input.startsWith("use ")) {
                String itemName = input.substring(4).trim();
                player.useItem(itemName);
            } else if (input.startsWith("move ")) {
                String direction = input.substring(5).trim();
                player.move(direction);
            }else if(input.startsWith("do ")) {
                String direction = input.substring(5).trim();
                player.move(direction);
            }else if (input.startsWith("sell ")) {
                String itemName = input.substring(5).trim();
                sellItem(itemName);
            } else if (input.startsWith("buy ")) {
                String itemName = input.substring(4).trim();
                buyItem(itemName);
            }else if (input.equalsIgnoreCase("DoExam")) {
                doExam();
            } else if (input.equalsIgnoreCase("CheckExp") ){
                player.printExp();
            }else if (input.equalsIgnoreCase("hint") ){
               hint();
            } else {
                System.out.println("Unknown rule.");
                hint();
            }
        }
    }

//definition of pickup command add adding to collection
    private static void pickUpItem(String itemName) {
        List<Items<?,?>> items = player.getCurrentLocation().getItems();
        for (Items<?,?> item : items) {
            if (item.getName().equals(itemName)) {
                player.addItem(item);
                items.remove(item);
                return;
            }
        }
        System.out.println("No item named '" + itemName + "' found here.");
    }


// definition of selling item after adding to balance remove item from collection
    private static void sellItem(String itemName) {
        Iterator<Items<?,?>> it = player.getInventory().iterator();
        while (it.hasNext()) {
            Items<?,?> item = it.next();
            if (item.getName().equalsIgnoreCase(itemName) && item instanceof earning) {
                earning earnItem = (earning) item;
                player.addBalance(earnItem.getValue());
                player.addExp(earnItem.getPower());
                earnItem.earn();
                it.remove();
                return;
            }
        }
        System.out.println("You can't sell this or item not found.");
    }

    // definition of buy command after adding booster use spend to manage cost and remove item from available item in shop(cafeteria)
    private static void buyItem(String itemName) {
        for (Items<?,?> item : player.getCurrentLocation().getItems()) {
            if (item.getName().equalsIgnoreCase(itemName) && item instanceof Booster) {
                Booster booster = (Booster) item;
                if (player.getBalance() >= booster.getValue()) {
                    player.reduceBalance(booster.getValue());
                    player.addItem(booster);
                    booster.spend();
                    player.getCurrentLocation().getItems().remove(item);
                } else {
                    System.out.println("Not enough balance to buy " + booster.getName());
                }
                return;
            }
        }
        System.out.println("Booster not found here.");
    }
    private static void doExam() {
        // control if user is in exam hall
        if (!player.getCurrentLocation().getName().equalsIgnoreCase("Exam Hall")) {
            System.out.println("You must be in the Exam Hall to take the exam!");
            return;
        }

        for (Character<?, ?> character : player.getCurrentLocation().getCharacters()) {
            if (character instanceof Exam) {
                Exam exam = (Exam) character;
                exam.use();

                if (player.getExp() >= exam.power()) {
                    System.out.println("Congratulations! You passed the " + exam.character_name() + "!");
                    player.addExp(10);//reward for compeleting task
                } else {
                    System.out.println("Not enough experience. You failed the exam.");
                    player.reduceExp(3);
                }
                return;
            }
        }

        System.out.println("There is no exam available here.");
    }
    private static void hint() {
        System.out.println("look: For check what is available in room \n" +
                "inventory: To check what do you have in your bag pack \n" +
                "pickup (+ item name):(E.G pickup MathBook) please write name of item as is printed for you\n" +
                "use (+itemName):(E.G use MathBook)after picking up to obtain mentioned item values you must to use that\n" +
                "Buy: is after you pick up something in buffet then you can use Buy+ (item name) E.G buy cake" +
                "sell: is after you pick up something in store then you can use sell+ (item name) E.G sell Screen Protector" +
                "move (+direction u want):(e.g move west)\n" +
                "DoExam: only in exam hall\n" +
                "CheckExp: to check how much experience you have\n" +
                "quit: for you to quit the Game!");
    }



}
