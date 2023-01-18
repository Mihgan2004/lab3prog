public class Main {
    public static void main(String[] args) {

        Season summer = Season.SUMMER;
        summer.start();

        Human afan = new Human("Афанасий Иванович");
        Place otrad = new Place("Отрадное");

        afan.doAction(new Action(Verb.TRAVEL, "в " + otrad.getName()));
        Period.go("2 недели");
        afan.doAction(new Action(Verb.LEAVE, "из " +  otrad.getName()));

        Period.go("4 месяца");

        Season winter = Season.WINTER;
        winter.start();

        Human krasavica = new Human("Красавица");
        krasavica.setDescriptions(HumanDescription.RICH, HumanDescription.NOBLE);

        Human nastya = new Human("Настасья Филипповна");

        Event rumor = new Rumor(afan.getName() + " женится на " + krasavica.getNameAndDescription());
        rumor.doAction(nastya);

        nastya.doAction(new Action(Verb.SHOW, "необыкновенную решимость."));
        nastya.doAction(new Action(Verb.DISCOVER, "самый неожиданный характер."));

        Place domik = new Place("деревенский домик");
        nastya.doAction(new Action(Verb.LEAVE, domik.getName()));

        Place saintP = new Place("Петербург");
        nastya.doAction(new Action(Verb.TRAVEL, "в " + saintP.getName()));

        afan.speak(nastya);

        afan.doActions(new Action(Verb.REALIZE, "нужно изменить слог"),
                new Action(Verb.REALIZE, "нужно изменить диапозон голоса"),
                new Action(Verb.REALIZE, "нужно изменить тему разговора"),
                new Action(Verb.REALIZE, "нужно изменить логику"));

        afan.doAction(new Action(Verb.DIDNTRECOGNIZE, nastya.getName()));

        nastya.setDescriptions(HumanDescription.KNOWLEDGEABLE, HumanDescription.UNDERSTANDING);

        nastya.deleteDescriptions(HumanDescription.TIMID,
                HumanDescription.INDEFINITE,
                HumanDescription.CHARMING,
                HumanDescription.PLAYFULNESS,
                HumanDescription.NAIVETY,
                HumanDescription.SAD,
                HumanDescription.THOUGHTFUL,
                HumanDescription.SURPRISED,
                HumanDescription.INCREDULOUS,
                HumanDescription.CRYING,
                HumanDescription.RESTLESS
        );

        nastya.doAction(new Action(Verb.LAUGH));
        nastya.doAction(new Action(Verb.PRICK, afan.getName() + " ядовитейшими сарказмами"));

        Condition.make(afan.getName() + " сейчас же женится", nastya.getName() + " будет всё равно");
        nastya.doAction(new Action(Verb.DONTALLOW, "брак для " + afan.getName()));
        Condition.make(nastya.getName() + " хочется", "так быть и должно");

    }
}