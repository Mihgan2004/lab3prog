public enum Verb {
    LAUGH("хохотать"),
    PRICK("колоть"),
    MARRY("женится"),
    REALIZE("озонать"),
    TRAVEL("поехать"),
    LEAVE("покинуть"),
    SHOW("выказать"),
    DISCOVER("обнаружить"),
    DIDNTRECOGNIZE("не узнать"),
    DONTALLOW("не позволять")
    ;

    private String name;

    Verb(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
