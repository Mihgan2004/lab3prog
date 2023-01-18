import org.w3c.dom.ls.LSOutput;

public enum Season {
    WINTER ("Зима"),
    SUMMER("Лето"),
    SPRING("Весна"),
    AUTUMN("Осень");

    private final String seasonName;

    Season(String seasonName){
        this.seasonName = seasonName;
    }
    public void start(){
        System.out.println("Сезон " + this.seasonName + " начался.");
    }
}
