public interface CanDoAction {
    void doAction(Action action);
    default void doActions(Action ...actions){
        for (Action action: actions){
            doAction(action);
        }
    }
}
