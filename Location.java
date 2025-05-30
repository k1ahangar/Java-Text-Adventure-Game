import java.util.*;

public class Location<L> {
    private String name;
    private L requirement;
    // Map to store exits with direction names as keys and corresponding locations as values(collection)
    private Map<String, Location<L>> exits = new HashMap<>();
    private List<Character<?, ?>> characters = new ArrayList<>();
    private List<Items<?,?>> items = new ArrayList<>();

    public Location(String name, L requirement) {
        this.name = name;
        this.requirement = requirement;
    }

    public String getName() {
        return name;
    }
//defining user movements in locations
    public void addExit(String direction, Location<L> location) {
        exits.put(direction, location);
    }

    public Location<L> getExit(String direction) {
        return exits.get(direction);
    }
// loading generic class of character for adding them to location
    public void addCharacter(Character<?, ?> character) {
        characters.add(character);
    }
//loading item class for adding items to Item classes for locations
    public void addItem(Items<?,?> item) {
        items.add(item);
    }

    public List<Character<?, ?>> getCharacters() {
        return characters;
    }

    public List<Items<?,?>> getItems() {
        return items;
    }

    public Map<String, Location<L>> getExits() {
        return exits;
    }

   public boolean checkRequirement(Student player) {
       if (requirement == null) {
           return true;
       }
       for (Items<?, ?> item : player.getInventory()) {
           if (item instanceof Key) {
             return true;
           }

       }

       return false;
   }




//  describing location for player when moves between locations.
    public void describe() {
        System.out.println("You are in: " + name);
        System.out.print("Items here: ");
        items.forEach(i -> System.out.print(i.getName() + ", "));
        System.out.println();

        System.out.print("Characters here: ");
        characters.forEach(c -> System.out.print(c.character_name() + ", "));
        System.out.println();

        System.out.print("Exits: ");
        exits.forEach((dir, loc) -> System.out.print(dir + " (" + loc.getName() + "), "));
        System.out.println();
    }
}
