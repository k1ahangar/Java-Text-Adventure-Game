public abstract class Character<N,V> {
    protected V power;
    protected N character_name;
    public Character(N name, V value ) {
        this.character_name = name;
        this.power = value;
    }
    public V power() { return power; }
    public N character_name() { return character_name; }
    abstract void interact(Student student);

}
class Exam extends Character<String,Integer> {
    public Exam(String name, int power) {
        super(name, power);
    }

    @Override
    public Integer power() {
        return super.power();
    }
    public String character_name() {
        return super.character_name();
    }

    public void use(){
        System.out.println("You are in "+character_name() +" you need at least "+ power());
    }
    public void interact(Student student) {}
}
class Bufet extends Character<String,Integer> {
    public Bufet(String name, int power) {
        super(name, power);
    }

    @Override
    public Integer power() {
        return super.power();
    }
    public String character_name() {
        return super.character_name();
    }

    public void use(){
        System.out.println("You are in "+character_name() +" you need at least "+ power());
    }
    public void interact(Student student) {}
}


