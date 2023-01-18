public enum HumanDescription {
    RICH("богатая"),
    NOBLE("знатная"),
    KNOWLEDGEABLE("необыкновенно", "много знающая"),
    UNDERSTANDING("необыкновенно", "много понимающая"),
    TIMID("робкая"),
    INDEFINITE("пансионски", "неопределенная"),
    CHARMING("очаровательная"),
    PLAYFULNESS("резвая"),
    NAIVETY("наивная"),
    SAD("иногда", "грустная"),
    THOUGHTFUL("иногда", "задумчивая"),
    SURPRISED("удивлённая"),
    INCREDULOUS("недоверчивая"),
    CRYING("плачущая"),
    RESTLESS("беспокойная")
    ;

    private String description;
    private String name;

    public String getName() {
        return name;
    }



    HumanDescription(String name){
        this.name = name;
    }

    public String getDescription() {
        return description;
    }


    HumanDescription(String description, String name){
        this.description = description;
        this.name = name;
    }

    public String getFullDescription(){
        if (description == null){
            return name;
        }
        return description + " " + name;
    }
}
