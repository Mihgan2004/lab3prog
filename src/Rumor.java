public class Rumor extends Event {

    public Rumor(String name) {
        super(name);
    }

    @Override
    public void doAction() {
        System.out.println("Слух \"" + super.getName() + "\" донёсся.");
    }

    @Override
    public void doAction(Human human) {
        System.out.println("Слух \"" + super.getName() + "\" донёсся до " + human.getName());
    }
}
