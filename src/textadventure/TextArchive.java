package textadventure;

/**
 *
 * @author Melgaard, Tobias
 */
class TextArchive {

    private static String heroName;

    private static final String introText = " "
            + "had spent many years as squire for the noble king Cappi, before he was knighted and earned the title: Sir Hero.\n"
            + "But during the time he was away, his sibling plotted an evil scheme, to kill their father and Sir Hero and inherit the family castle!\n"
            + "Sir Hero as a noble knight cannot stand idly by while his father is murdered! So Sir Hero traveled to his fathers castle to save him.\n"
            + "But his sibling had already arrived and taken their father captive. Sir Hero must enter the castle to free his father!";

    private static final String room1IntroText
            = "You now find yourself to be in the entré.\n"
            + "Towards west you see some stairs, leading down to the cellar. Right now you see nothing there but darkness.\n"
            + "To the north, there is a door. \n"
            + "You remember it to open onto the hallway, but it has been years since you last visited so you are not quite sure.\n"
            + "To the east, you see the door to the kitchen. Next to the door you see a big painting.";
    private static final String room2IntroTextWithLight
            = "You have reached the end of the stairs. The room seems cold and abandoned. "
            + "Well it is. On the floor you see a dead rat. At first sight, there is no sign of cause of death.\n"
            + "At the end of the room you see a desk. On the desk you see a wooden box.";
    private static final String room2IntroTextNoLight
            = "You were not able to see anything going down the stairs and tripped.\n"
            + "Luckily you were not harmed, but you are surrounded by complete darkness! \n"
            + "It seems like the smartest thing is to crawl back up the stairs.";
    private static final String room3IntroText
            = "You have entered the kitchen and it looks exactly the same from when you were a kid.\n"
            + "The room is well lit by a lot of lanterns around the kitchen and you instantly spot the big pile of dirty dishes. You wonder where all the maids went?\n"
            + "Besides that, there is just tons of kitchen drawers.";
    private static final String room4IntroTextDeactivated
            = "You are now in the hallway.\n"
            + "There is doors in every direction. Over in the corner you see a knights armor on display. It belongs to your dad.";
    private static final String room4IntroTextActivated
            = "As you enter the room you are shocked. The armor you saw in the corner now stands before the northen door."
            + "He is blocking the door and looks ready to fight!"
            + "The other doors are not blocked though";
    private static final String room4IntroTextDefeated
            = "Your fathers armor is lying scattered on the floor, you hope it will not rise again"
            + "There is doors in every direction.";
    private static final String room5IntroText
            = "find yourself in a bar. You do not recall ever seeing this room before. It must be newly renovated.\n"
            + "As you look around, you see nothing but empty chairs and small roundtables. In the bar you see a lot of alcohol. Or a lot of empty bottles that used to contain alcohol.\n"
            + "Over the bar you see an old banner hanging. In the opposite side of the room you see a door.";
    private static final String room6IntroText
            = "You enter the room and to your big regret it is an old dusty library filled with tons of high shelves filled with books.\n"
            + "In the middle of the room there is a little table, with piles of books and papers on it"
            + "next to it stands a pedistal with a giant book on it.";
    private static final String room7IntroText
            = "You enter the room and see your father tied up on his throne. He seems to be unconscious.\n"
            + "From behind the chair you see a shadow. Your sister walks forward, grinning.\n"
            + "Sir Hero: \"Hello, Mr. Badguy! Surprised to see me?\"\n"
            + "Mr. Badguy: \"Hello, Sir Hero! No I am not. You always were predictable.\" \n"
            + "Sir Hero: \"Unlike you, Big sister! I never thought you would kidnap your own father and threaten to kill him!\"\n"
            + "Mr. Badguy: \"It is unfair! I am the oldest. I am the rightful heir to this castle!\" \n"
            + "Sir Hero: \"True, but I am a man, and you know the rules! Besides.. I put dibs on the castle many years ago!\"\n"
            + "Mr. Badguy: \"This castle belongs to me! You will need to pry it from my dead hand!\"\n"
            + "Sir Hero: \"I will do what I must.\" ";

    public static String inputAction(int roomID, String userInput, World gameWorld) {

        String action;
        String object;

        try {
            String[] command = userInput.split(" ");
            if (command.length != 2) {
                throw new IllegalArgumentException();
            }
            action = command[0];
            object = command[1];
        } catch (Exception IllegalArgumentException) {
            return "You must write 2 words";
        }

        if (roomID == 1) {

            switch (action) {
                case "move":
                case "walk":
                case "go":

                    switch (object) {
                        case "north":

                            if (gameWorld.sir.getInventoryArray().contains(gameWorld.darkness)) {
                                gameWorld.setHeroPosition(4);
                                return getRoom4IntroText(gameWorld.getRoom4KnightActivated());
                            } else {
                                return "The door is locked find the key!";
                            }

                        case "east":

                            gameWorld.setHeroPosition(3);
                            return getRoom3IntroText();

                        case "south":

                            return "You cant leave the castle, your code of honor compels you too stay!";

                        case "west":

                            gameWorld.setHeroPosition(2);
                            return getRoom2IntroText(gameWorld);

                        default:
                            return "No such direction";
                    }

                case "fight":

                    return "There is nothing to fight";

                case "use":

                    return "You cant do that";

                case "search":
                case "look":

                    if (object.equals("painting")) {

                        return "It depicts you and your sibling when you were kids, majestically riding your horses! You spend some time reminiscing about the good ol' times.";

                    } else {
                        return "You cant do that";
                    }

                case "take":
                case "loot":
                case "get":

                    return "You cant do that";

                default:

                    return "You cant do that";

            }

        }
        if (roomID == 2) {

            switch (action) {
                case "move":
                case "walk":
                case "go":

                    switch (object) {
                        case "north":

                            return "You cant do that";

                        case "east":

                            gameWorld.setHeroPosition(1);
                            return getRoom1IntroText();

                        case "south":

                            return "You cant do that";

                        case "west":

                            return "You cant do that";

                        default:
                            return "No such direction";
                    }

                case "fight":

                    return "There is nothing to fight";

                case "use":

                    if (gameWorld.sir.getInventoryArray().contains(gameWorld.lantern)) {
                        switch (object) {
                            case "rat":

                                if (gameWorld.sir.getInventoryArray().contains(gameWorld.knife)) {
                                    return "You cut the rat open and guts spill all over. You have no idea why you just did that or what you hoped to achieve! You leave it on the floor.";
                                } else {
                                    return "You see nothing interesting.";
                                }

                            case "desk":
                                return "You cant do that";

                            case "box":
                            case "woodenbox":
                                if (gameWorld.basement.getArrayList().contains(gameWorld.throne)) {

                                    gameWorld.basement.removeItem(gameWorld.throne);
                                    gameWorld.sir.getInventoryArray().add(gameWorld.throne);
                                    return "Inside the box, there is an old key. You put it in your inventory.";
                                } else {
                                    return "You already did that";
                                }

                            default:
                                return "You cant do that";
                        }

                    } else {
                        gameWorld.sir.setHeroAlive(false);
                        return "You walk blindly around the cellar looking for something useful. In the darkness you trip over a dead rat and falls towards a big mirror on the wall.\n"
                                + "It smashes against your head, which brings you 7 years of bad luck and your ultimate demise. You bleed out.";
                    }

                case "search":
                case "look":

                    if (gameWorld.sir.getInventoryArray().contains(gameWorld.lantern)) {
                        switch (object) {

                            case "desk":
                                return "Besides from the wooden box, there is not any things of interest. Just old parchment, gold and dust.";

                            case "box":
                            case "woodenbox":
                                if (gameWorld.basement.getArrayList().contains(gameWorld.darkness)) {

                                    gameWorld.basement.removeItem(gameWorld.darkness);
                                    gameWorld.sir.getInventoryArray().add(gameWorld.darkness);
                                    return "Inside the box, there is an old key. You put it in your inventory.";
                                } else {
                                    return "You already did that";
                                }

                            default:
                                return "You cant do that";
                        }

                    } else {
                        gameWorld.sir.setHeroAlive(false);
                        return "You walk blindly around the cellar looking for something useful. In the darkness you trip over a dead rat and falls towards a big mirror on the wall.\n"
                                + "It smashes against your head, which brings you 7 years of bad luck and your ultimate demise. You bleed out.";
                    }

                case "take":
                case "loot":
                case "get":

                    if (gameWorld.sir.getInventoryArray().contains(gameWorld.lantern)) {

                        switch (object) {
                            case "rat":

                                if (gameWorld.sir.getInventoryArray().contains(gameWorld.knife)) {
                                    return "You cut the rat open and guts spill all over. You have no idea why you just did that or what you hoped to achieve! You leave it on the floor.";
                                } else {
                                    return "You see nothing interesting.";
                                }
                        }

                    } else {
                        gameWorld.sir.setHeroAlive(false);
                        return "You walk blindly around the cellar looking for something useful. In the darkness you trip over a dead rat and falls towards a big mirror on the wall.\n"
                                + "It smashes against your head, which brings you 7 years of bad luck and your ultimate demise. You bleed out.";
                    }

                default:

                    return "You cant do that";

            }

        }
        if (roomID == 3) {

            switch (action) {
                case "move":
                case "walk":
                case "go":

                    switch (object) {
                        case "north":

                            return "You cant do that";

                        case "east":

                            return "You cant do that";

                        case "south":

                            return "You cant do that";

                        case "west":

                            gameWorld.setHeroPosition(1);
                            return getRoom1IntroText();

                        default:
                            return "No such direction";

                    }

                case "fight":

                    return "There is nothing to fight";

                case "use":

                    return "You cant do that";

                case "search":
                case "look":

                    switch (object) {

                        case ("drawers"):
                        case ("drawer"):

                            gameWorld.setRoom3DrawersSearched(true);
                            return "You start looking in the drawers. Most of them only contain silverware, but in one of them you find a knife.";

                        case ("dishes"):

                            return "You never learned to do the dishes. Leave them be!";

                        default:

                            return "You cant do that";

                    }

                case "take":
                case "loot":
                case "get":

                    switch (object) {

                        case "lantern":
                            if (gameWorld.kitchen.getArrayList().contains(gameWorld.lantern)) {

                                gameWorld.kitchen.removeItem(gameWorld.lantern);
                                gameWorld.sir.getInventoryArray().add(gameWorld.lantern);
                                return "Good idea! This lantern can light up the cellar.";
                            } else {
                                return "You already took a lantern";
                            }

                        case "silver":
                        case "silverware":
                            if (gameWorld.getRoom3DrawersSearched()) {
                                return "You are not fighting a werewolf, so leave it be!";
                            } else {
                                return "You cant do that";
                            }
                        case "knife":
                            if (gameWorld.getRoom3DrawersSearched() && gameWorld.kitchen.getArrayList().contains(gameWorld.knife)) {

                                gameWorld.kitchen.removeItem(gameWorld.knife);
                                gameWorld.sir.getInventoryArray().add(gameWorld.knife);
                                return "You take the knife. You can never have enough weapons, so you put it in your inventory. It has a strength point of 1!";
                            } else {
                                return "You cant do that";
                            }

                    }

                default:

                    return "You cant do that";

            }

        }
        if (roomID == 4) {

            switch (action) {
                case "move":
                case "walk":
                case "go":

                    switch (object) {
                        case "north":
                            if (gameWorld.getRoom4KnightActivated().equals("activated")) {
                                return "You cant get past the knight, you must defeat him!";
                            }
                            else if (gameWorld.sir.getInventoryArray().contains(gameWorld.throne)) {
                                gameWorld.setHeroPosition(7);
                                return room7IntroText;                            
                            } else {
                                return "The door is locked! It opens to the throneroom and the chances are that your father is held captive in there. "
                                        + "You need to find a way in!";
                            }

                        case "east":

                            gameWorld.setRoom4KnightActivated("activated");
                            gameWorld.setHeroPosition(5);
                            return room5IntroText;

                        case "south":

                            gameWorld.setHeroPosition(1);
                            return room1IntroText;

                        case "west":

                            return "The door is locked. It leads over to the old part of the castle. \n"
                                    + "You remember, your father telling you that there was nothing but darkness over there.\n"
                                    + "You are kind of relieved, actually.";

                        default:
                            return "No such direction";

                    }

                case "fight":

                    switch (gameWorld.getRoom4KnightActivated()) {

                        case "deactivated":

                            return "There is nothing to fight";

                        case "activated":

                            int livingArmorStrength;

                            if (gameWorld.hallway.getArrayList().contains(gameWorld.sword)) {
                                livingArmorStrength = 4;
                            } else {
                                livingArmorStrength = 2;
                            }

                            if (gameWorld.sir.getHeroStrenght() <= livingArmorStrength) {
                                gameWorld.sir.setHeroAlive(false);
                                return "You try to fight the living armor, but it is too fast and too strong for you."
                                        + "You are pummeled to death";
                            } else if (gameWorld.sir.getHeroStrenght() >= livingArmorStrength) {
                                gameWorld.setRoom4KnightActivated("defeated");
                                return "It lashes out against you, but you dodge quickly, and tackles it afterwards. The armor falls apart and now lies in a big pile of rusty metal!";

                            }

                        case "defeated":

                            return "You have already defeated the living armor!";

                    }

                case "use":

                    return "You cant do that";

                case "search":
                case "look":

                    switch (object) {
                        case "knight":
                        case "armor":
                        case "knightsarmor":

                            if (gameWorld.hallway.getArrayList().contains(gameWorld.sword)) {
                                return "The old armor belongs to your father.\n"
                                        + "He wore it in the Century Wars. Next to the armor you see his old sword. \n"
                                        + "With this he has slain more than a thousand soldiers. According to him anyways.";
                            } else {
                                return "The old armor belongs to your father.\n"
                                        + "He wore it in the Century Wars. \n"
                                        + "With this he has slain more than a thousand soldiers. According to him anyways.";
                            }
                    }

                case "take":
                case "loot":
                case "get":

                    switch (object) {
                        case "knight":
                        case "armor":
                        case "knightsarmor":

                            return "You do not fit the armor, so it will not do you any good.";

                        case "sword":
                            if (!gameWorld.getRoom4KnightActivated().equals("activated")) {
                                if (gameWorld.hallway.getArrayList().contains(gameWorld.sword)) {

                                    gameWorld.hallway.removeItem(gameWorld.sword);
                                    gameWorld.sir.getInventoryArray().add(gameWorld.sword);
                                    return "You took his sword! It is a bit heavy, but its a powerful sword. You gained 2 Strength Points!";
                                } else {
                                    return "You already took your fathers sword.";
                                }
                            } else {
                                if (gameWorld.hallway.getArrayList().contains(gameWorld.sword)) {

                                    return "You cant take that, the knight has it!";
                                } else {
                                    return "You already took your fathers sword.";
                                }
                            }
                    }

                default:

                    return "You cant do that";

            }

        }
        if (roomID == 5) {

            switch (action) {
                case "move":
                case "walk":
                case "go":

                    switch (object) {
                        case "north":

                            return "You cant do that";

                        case "east":

                            gameWorld.setHeroPosition(6);
                            return getRoom6IntroText();

                        case "south":

                            return "You cant do that";

                        case "west":

                            gameWorld.setHeroPosition(4);
                            return getRoom4IntroText(gameWorld.getRoom4KnightActivated());

                        default:
                            return "No such direction";

                    }

                case "fight":

                    return "There is nothing to fight";

                case "use":

                    switch (object) {
                        case "alcohol":
                        case "booze":
                        case "bottles":
                        case "bottle":

                            return "You do not want to poison yourself with that. You can not be sure what is inside the bottles!";

                        default:
                            return "You cant do that";

                    }

                case "search":
                case "look":

                    switch (object) {

                        case "table":
                        case "tables":
                            return "You find nothing but gold coins.";

                        case "bar":
                            return "A lot of half empty bottles of alcohol and dust. But surprisingly little else.";

                        case "banner":
                            return "You recognize the banner. It used to hang in your room. It is the Banner of King Cappi. The man that knighted you after years of squi... \n"
                                    + "Wait a minute. This room does look familiar. Your father rebuilt your old room into a bar!? \n"
                                    + "You decide to save him anyways. You are a noble knight after all.";

                    }
                case "take":
                case "loot":
                case "get":

                    switch (object) {
                        case "alcohol":
                        case "booze":
                        case "bottles":
                        case "bottle":

                            return "You do not want to poison yourself with that. You can not be sure what is inside the bottles!";

                        case "gold":
                        case "coins":
                        case "coin":
                        case "money":

                            return "You have no need for gold";

                        default:
                            return "You cant do that";
                    }

                default:

                    return "You cant do that";

            }

        }
        if (roomID == 6) {

            switch (action) {
                case "move":
                case "walk":
                case "go":

                    switch (object) {
                        case "north":

                            return "You cant do that";

                        case "east":

                            return "You cant do that";

                        case "south":

                            return "You cant do that";

                        case "west":

                            gameWorld.setHeroPosition(5);
                            return getRoom5IntroText();

                        default:
                            return "No such direction";

                    }

                case "fight":

                    return "There is nothing to fight";

                case "use":

                    return "You cant do that";

                case "search":
                case "look":

                    switch (object) {

                        case "shelf":
                        case "shelves":
                            if (gameWorld.sir.getHeroStrenght() >= 4) {
                                gameWorld.sir.setHeroAlive(false);
                                return "You go through all the rows of the shelves. One of them is stuck and you try to pry it free. \n"
                                        + "With your strength you pull it out with one big pull.\n"
                                        + "The book is in your hand and you read the cover. \"Traps 101\" it says. All of a sudden you see the shelves tilting towards you.\n"
                                        + "You try to hold back the big rows of shelves, but even you are not strong enough! \n"
                                        + "Before you know it, you are forced to the floor and squished between the floor and the shelves.\n"
                                        + "You never liked books very much...";
                            } else {
                                return "You go through all the rows of the shelves. One of them is stuck and you try to pry it out, but with no luck. \n"
                                        + "It is probably not interesting anyways.";
                            }
                        case "pedistal":
                        case "table":
                            return "You look at the giant book which is on the pedistal next to the table.\n"
                                    + "It must have at least 2000 pages in it. The cover reads \"Magic for dummies: Get fit!\".\n"
                                    + "On the table you see a little key under a book. That must be the key to the throneroom!";

                    }

                case "take":
                case "loot":
                case "get":

                    switch (object) {

                        case "book":
                        case "giantbook":

                            if (gameWorld.sir.getInventoryArray().contains(gameWorld.spellbook)) {
                                return "You have already taken the spellbook!";
                            } else {
                                gameWorld.library.getArrayList().remove(gameWorld.spellbook);
                                gameWorld.sir.addItem(gameWorld.spellbook);
                                return "You look into the book and you get this tingling feeling in your arms. You keep reading and in a split second your arms grows twice their normal size!\n"
                                        + "You gain 3 Strength Points!";
                            }

                        case "key":
                            gameWorld.library.getArrayList().remove(gameWorld.throne);
                            gameWorld.sir.addItem(gameWorld.throne);
                            return "You pick up the key to the throneroom";
                        default:
                            return "You cant do that";

                    }

                default:

                    return "You cant do that";

            }

        }
        if (roomID == 7) {

            switch (action) {
                case "move":
                case "walk":
                case "go":

                    switch (object) {
                        case "north":

                            return "You cant do that";

                        case "east":

                            return "You cant do that";

                        case "south":

                            return "You cant turn back now!";

                        case "west":

                            return "You cant do that";

                        default:
                            return "No such direction";
                    }

                case "fight":

                    if (gameWorld.sir.getHeroStrenght() < 5) {
                        gameWorld.sir.setHeroAlive(false);
                        return "Mr. Badguy strikes a deadly blow against you, but you dodged it. \n"
                                + "You push her down on the floor, and go for a final strike.\n"
                                + "But you slip and fall towards her, and she sees her opportunity. \n"
                                + "You feel a painful sensation in your chest and see a dagger right in your heart!\n"
                                + "Mr. Badguy grins, and throw your lifeless body on the floor. \n"
                                + "She goes over to the throne and slit your fathers throat open.\n"
                                + "\n"
                                + "Mr. Badguy: \"The castle belongs to me now!\"\n"
                                + "\n"
                                + "Sir Hero failed his mission to save his father and get the castle back.";
                    } else if (gameWorld.sir.getHeroStrenght() == 5) {
                        gameWorld.sir.setHeroAlive(false);
                        return "Mr. Badguy strikes a deadly blow against you, but you dodged it. \n"
                                + "You then go for a strike against her, but she dodged it as well!\n"
                                + "Both of you go at it for a while, until you are both dead tired. \n"
                                + "Exhausted from the fight, you both fall to the ground.\n"
                                + "\n"
                                + "Mr. Badguy: \"What are we doing? Why can we not just share this castle? It is big enough for the both of us.\"\n"
                                + "Sir Hero: \"Well, that is true. I do not need all the space anyway. You can have the evil side of the palace. It fits your personality.\"\n"
                                + "Mr. Badguy: \"That was unnecessary, but i will take your offer.\"\n"
                                + "Sir Hero: \"What about father? He is still healthy and will live for at least 10-20 years more.\"\n"
                                + "Mr. Badguy: \"I will take care of him.\"\n"
                                + "\n"
                                + "Sir Hero somewhat succeded his mission. The castle is partly his, but he was \"Unable\" to save his father from a horrible fate. \n"
                                + "The castle is shared by the siblings. Even through their differences, they manage to keep peace between them.";
                    } else if (gameWorld.sir.getHeroStrenght() > 5) {
                        gameWorld.sir.setHeroAlive(false);
                        return "Mr. Badguy strikes a deadly blow against you, but you dodged it. \n"
                                + "You push her to the floor and give her the final strike.\n"
                                + "Before the last sign of life leaves her eyes, she manages to say \"I hate you\".\n"
                                + "\n"
                                + "Sir Hero goes to untie his father and wake him up. Sadly he was not just unconscious, he was also poisoned!\n"
                                + "Your father dies in your arms, but you can see a smile on his face. You saved his castle.\n"
                                + "\n"
                                + "Sir Hero succeded his mission. Even though he could not save his father, he got the castle, in time so that his father at least knew that it would be in good hands.";
                    } else {
                        return "Something gone wrong";
                    }

                case "use":

                    return "You cant do that";

                case "search":
                case "look":

                    return "You cant do that";

                case "take":
                case "loot":
                case "get":

                    return "You cant do that";

                default:

                    return "You cant do that";

            }

        }

        return null;
    }

    //Getters og Setters    
    public static String getIntroText() {
        return getHeroName() + introText;
    }

    public static String getRoom1IntroText() {
        return room1IntroText;
    }

    public static String getRoom2IntroText(World gameWorld) {

        if (gameWorld.sir.getInventoryArray().contains(gameWorld.lantern)) {
            return room2IntroTextWithLight;
        } else {
            return room2IntroTextNoLight;
        }

    }

    public static String getRoom3IntroText() {
        return room3IntroText;
    }

    public static String getRoom4IntroText(String knightStatus) {
        switch (knightStatus) {
            case "deactivated":
                return room4IntroTextDeactivated;
            case "activated":
                return room4IntroTextActivated;
            case "defeated":
                return room4IntroTextDefeated;
            default:
                return null;
        }
    }

    public static String getRoom5IntroText() {
        return room5IntroText;
    }

    public static String getRoom6IntroText() {
        return room6IntroText;
    }

    public static String getRoom7IntroText() {
        return room7IntroText;
    }

    public static String getHeroName() {
        return heroName;
    }

    public static void setHeroName(String name) {
        heroName = name;
    }

}
