public interface HasDescription {

    void setDescriptions(HumanDescription...descriptions);

    HumanDescription[] getDescription();

    void deleteDescription(HumanDescription description);

    void deleteDescriptions(HumanDescription...descriptions);
}
