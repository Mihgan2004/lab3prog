import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Human implements CanDoAction, HasDescription{

    static public class Fio {
        private String name;
        private String surname;

        public Fio(String name, String surname) throws IncorrectNameException{
            if (name == null || name.equals("") || name.matches("[-+]?\\d+")) throw new IncorrectNameException("Имя заданно неверно!");
            this.name = name;
            this.surname = surname;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Fio info = (Fio) o;
            return Objects.equals(name, info.name) && Objects.equals(surname, info.surname);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, surname);
        }
    }

    private final Fio fio;

    private HumanDescription[] description;

    @Override
    public HumanDescription[] getDescription() {
        return description;
    }
    @Override
    public void setDescriptions(HumanDescription...descriptions) throws DescriptionHasAlreadyBeenException{
        List<HumanDescription> list =  new ArrayList<>(
                Arrays.asList(
                        (this.description == null ? new HumanDescription[0] : this.description)
                )
        );

        for (HumanDescription description : descriptions) {
            if (list.contains(description)) throw new DescriptionHasAlreadyBeenException("Данная характеристика уже присутствуют у человека");
            System.out.println("Человек " + fio.name + " " + fio.surname + " получил характеристику: " + description.getFullDescription());
            list.add(description);
        }
        this.description = list.toArray(new HumanDescription[0]);

    }
    @Override
    public void deleteDescription(HumanDescription description){
        List<HumanDescription> newDesc = new ArrayList<>();
        for (HumanDescription myDesc: this.description){
            if (!Objects.equals(myDesc, description)){
                newDesc.add(myDesc);
            }
        }
        System.out.println("Человек " + fio.name + " " + fio.surname + " потерял характеристику: " + description.getFullDescription());
        this.description = newDesc.toArray(new HumanDescription[0]);
    }

    @Override
    public void deleteDescriptions(HumanDescription... descriptions) {
        for (HumanDescription desc : descriptions){
            deleteDescription(desc);
        }
    }

    Human(String name, String surname) throws IncorrectNameException{
        this.fio = new Fio(name, surname);
    }

    public String getName() {
        return fio.name + " " + fio.surname;
    }

    public String getNameAndDescription(){

        class Info {
            Fio fio;
            HumanDescription[] description;

            public Info(Fio fio, HumanDescription[] humanDescriptions){
                this.fio = fio;
                this.description = humanDescriptions;
            }

            public String get(){
                StringBuilder res = new StringBuilder();
                for (HumanDescription desc : description){
                    res.append(desc.getFullDescription()).append(" ");
                }
                res.append(Human.this.fio.name);
                return res.toString();
            }
        }

        Info info = new Info(fio, description);
        return info.get();
    }



    @Override
    public void doAction(Action action){
        System.out.println("Человек " + fio.name + " " + fio.surname + " совершил действие " + action.getAction());
    }


    public void speak(Human human){
        System.out.println(fio.name + " " + fio.surname + " говорит с " + human.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(fio.name + " " + fio.surname, human.fio.name + " " + human.fio.surname) && Arrays.equals(description, human.description);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(fio.name + " " + fio.surname);
        result = 31 * result + Arrays.hashCode(description);
        return result;
    }

    @Override
    public String toString() {
        return "Human{" +
                "info=" + fio +
                ", description=" + Arrays.toString(description) +
                '}';
    }
}
