
// definition of generic class with two value V and B
public abstract class Items<V,B> {
    protected V value;
    protected B power;;
    protected String name;
    public Items(String name,B power,V value ) {
      this.value = value;
      this.power=power;
      this.name=name;
    }

    public B getPower() {
        return power;
    }

    public V getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
    public void printMsg(){

    }


}
// definition of inner class for equipments which is library Items
class Equipment extends Items<Integer,Integer>{
    public Equipment(String name,int power,int exp) {
        super(name,power,exp);

    }

    @Override
    public Integer getValue() {
        return super.getValue();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public Integer getPower() {
        return super.getPower();
    }

    public void printMsg(){
        System.out.println("you obtained "+getName()+" "+"with this "+getPower()+" power and "+" "+getPower()+" EXP Points!");
        Main.player.addExp(getPower());
    }
}

// definition of inner class for Boosters which user spend money to buy them.
class Booster extends Items<Double,Integer>{
//power will be int and expense will be double which is currency in game
    public Booster(String name,int power,double expense) {
        super(name,power,expense);

    }

    @Override
    public Double getValue() {
        return super.getValue();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public Integer getPower() {
        return super.getPower();
    }

    public void spend(){
        System.out.println("you obtained "+getPower()+" "+"with "+getName()+"and cost "+getValue()+" USD!");
    }
}
// definition of inner class for item in shop which user by selling them will earn money by them
class earning extends Items<Double,Integer>{
    public earning(String name,int power,double dollars) {
        super(name,power,dollars);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public Integer getPower() {
        return super.getPower();
    }
    @Override
    public Double getValue() {
        return super.getValue();
    }

    public void earn(){
        System.out.println("you earned: "+getValue()+" dollars by selling "+getName()+" and "+" "+getPower()+" experience because of psychological activity!");
    }


}
// definition of inner class for exam pass
class Key extends Items<Integer,Integer>{
    public Key(String keyName, int power,int exp) {
        super(keyName, power, exp);
    }

    @Override
    public Integer getValue() {
        return super.getValue();
    }

    @Override
    public String getName() {
        return super.getName();
    }
    public int getExp() {
        return super.getPower();
    }

    public void use(){
        System.out.println("you obtained "+getName()+" Passing Card by this: "+ getExp()+ " Point");
    }
}



