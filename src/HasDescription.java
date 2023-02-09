public interface HasDescription {

    void setDescriptions(HumanDescription...descriptions) throws DescriptionHasAlreadyBeenException;

    HumanDescription[] getDescription();

    void deleteDescription(HumanDescription description);

    void deleteDescriptions(HumanDescription...descriptions);
}
