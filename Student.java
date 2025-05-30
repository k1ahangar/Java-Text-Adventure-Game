import java.util.*;

public class Student {
    // definition of collection in array list.
    private List<Items<?,?>> inventory = new ArrayList<>();
    private Location<?> currentLocation;
    private String name;
    // default balance is 100USD
    private double balance=100;
    private int exp;

    public Student(String name) {
        this.name = name;

    }
    public String getName() {
        return name;
    }
// for managing user action for selling item which is adding balance
    public void addBalance(double amt) {
        this.balance+=amt;
        System.out.println("you just earned"+amt+"your balance now is "+balance+" $ ");
    }
    // for managing user action for buying items which is reducing balance
    public void reduceBalance(double amt) {
        if(balance>=amt){
            balance-=amt;
            System.out.println("you paid "+amt+" $ "+"your balance now is"+balance);
        }else{
            System.out.println("Not enough Balance!");
        }
    }
    public void exam(int exp){
        if(exp>=this.exp){
            System.out.println("Congratulations! You passed exam"+exp);
        }else if(exp<this.exp){
            System.out.println("Not enough Experience! you failed exam");
        }

    }
    public double getBalance() {
        return balance;
    }

    public void addExp(int experience) {
        exp+=experience;
    }
    public void reduceExp(int experience) {
        exp-=experience;
    }
    public int getExp() {
        return this.exp;
    }
    public void printExp(){
        System.out.println("You have "+exp+" experience");
    }
    public void setCurrentLocation(Location<?> location) {
        this.currentLocation = location;
    }

    public Location<?> getCurrentLocation() {
        return currentLocation;
    }
// adding item to collection (inventory)
    public void addItem(Items<?,?> item) {
        inventory.add(item);
        System.out.println("You picked up: " + item.getName());
    }
// reading inventory value
    public List<Items<?,?>> getInventory() {
        return inventory;
    }
// describing inventory for check what user have in bag pack
    public void desInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
            return;
        }

        System.out.println("Your inventory:");
        for (Items<?,?> item : inventory) {
            System.out.println("-*-" + item.getName()+"-*-");
        }
    }
//definition of  using item Method
    public void useItem(String name) {
        for (Items<?,?> item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                item.printMsg();
                return;
            }
        }
        System.out.println("No such item in inventory.");
    }
// definition of move method
    public void move(String direction) {
        Location<?> next = currentLocation.getExit(direction);
        if (next == null) {
            System.out.println("You can't go that way.");
            return;
        }

        if (next.checkRequirement(this)) {
            currentLocation = next;
            System.out.println("You moved to: " + next.getName());
            currentLocation.describe();


        } else {
            System.out.println("You do not meet the requirement to enter Please Check if you have Exam Pass!" + next.getName());
        }
    }


}
