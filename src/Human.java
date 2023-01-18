import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Human implements CanDoAction, HasDescription{
    private String name;

    private HumanDescription[] description;

    @Override
    public HumanDescription[] getDescription() {
        return description;
    }
    @Override
    public void setDescriptions(HumanDescription...descriptions) {
        for (HumanDescription description : descriptions)
            System.out.println("Человек " + name + " получил характеристику: " + description.getFullDescription());
        this.description = descriptions;
    }
    @Override
    public void deleteDescription(HumanDescription description){
        List<HumanDescription> newDesc = new ArrayList<>();
        for (HumanDescription myDesc: this.description){
            if (!Objects.equals(myDesc, description)){
                newDesc.add(myDesc);
            }
        }
        System.out.println("Человек " + name + " потерял характеристику: " + description.getFullDescription());
        this.description = newDesc.toArray(new HumanDescription[0]);
    }

    @Override
    public void deleteDescriptions(HumanDescription... descriptions) {
        for (HumanDescription desc : descriptions){
            deleteDescription(desc);
        }
    }

    Human(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNameAndDescription(){
        StringBuilder res = new StringBuilder();
        for (HumanDescription desc : description){
            res.append(desc.getFullDescription()).append(" ");
        }
        res.append(name);
        return res.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void doAction(Action action){
        System.out.println("Человек " + this.name + " совершил действие " + action.getAction());
    }


    public void speak(Human human){
        System.out.println(name + " говорит с " + human.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name) && Arrays.equals(description, human.description);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(description);
        return result;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", description=" + Arrays.toString(description) +
                '}';
    }
}
