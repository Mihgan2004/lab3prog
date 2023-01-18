public class Action {

    private Verb verb;
    private String desc;

    public Action(Verb verb) {
        this.verb = verb;
    }

    public Action(Verb verb, String desc) {
        this.verb = verb;
        this.desc = desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setVerb(Verb verb) {
        this.verb = verb;
    }

    public String getAction(){
        if (desc == null){
            return verb.getName();
        }
        return verb.getName() + ": " + desc;
    }
}
