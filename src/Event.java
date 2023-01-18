import java.util.Objects;

public abstract class Event {
    private final String name;

    private String description = "";

    public Event(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Event(String name){
        this.name = name;
    }

    public void doAction(){
        System.out.println(name + " " + description + "совершило действие");
    }

    public void doAction(Human human){
        System.out.println(name + " " + description + "совершило действие с человеком " + human.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, description);
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(name, event.name) && Objects.equals(description, event.description);
    }
}
