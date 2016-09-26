import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class TextAdventure {

    public static void main(String[] args) throws IOException {

        //tools
        Room currentRoom;
        HashMap<String, Room> mapR1 = new HashMap<>();
        HashMap<String, Room> mapR2 = new HashMap<>();
        HashMap<String, Room> mapR3 = new HashMap<>();
        HashMap<String, Room> mapR4 = new HashMap<>();
        HashMap<Door, Room> doorMapR4 = new HashMap<>();
        ArrayList<Item> itemsR1 = new ArrayList<>();
        ArrayList<Item> itemsR2 = new ArrayList<>();
        ArrayList<Item> itemsR3 = new ArrayList<>();
        ArrayList<Item> itemsR4 = new ArrayList<>();
        ArrayList<Item> yourItems = new ArrayList<>();
        Backpack yourBackpack = new Backpack(yourItems);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        String userDir;

        //locations
        Room r1 = new Room("The Great Hall", "A long wide room draped here and there in curtains.");
        Room r2 = new Room("The Side Study", "a small cluttered room.");
        Room r3 = new Room("The Gardens", "a misty path between beds, once carefully tended now overgrown and disturbed by the encroaching weeds.");
        Room r4 = new Room("A Long Passage", "a narrow hallway lined with brooding portraits. Set into the walls to your left and right are blank grey doors, three to a side. They are locked.");
        Room r5 = new Room("","");
        Room r6 = new Room("","");
        Room r7 = new Room("","");
        Room r8 = new Room("","");
        Room r9 = new Room("","");
        Room r10 = new Room("","");


        //map for great hall
        mapR1.put("north", r4);
        mapR1.put("east", r2);
        mapR1.put("west", r3);
        r1.setRoomMap(mapR1);

        //map for side study
        mapR2.put("west", r1);
        r2.setRoomMap(mapR2);

        //map for gardens
        mapR3.put("east", r1);
        r3.setRoomMap(mapR3);

        //map for long passage
        mapR4.put("south", r1);
        r4.setRoomMap(mapR4);

        //items
        ImmovableObject window1Room4 = new ImmovableObject("a Window to the North.", "You look out upon a great vista.", "window");
        ImmovableObject desk = new ImmovableObject("a Small Desk in the Corner.", "You lean in to see papers and coffee.", "desk");
        ImmovableObject painting = new ImmovableObject("a large oil painting on the far wall.", "You see now the painting is of a strange thin man in a winged armchair. You get a cold feeling down your spine and turn away.", "painting");
        MovableObject key = new MovableObject("a plain and ordinary key.", "You examine it's surface and see nothing new.", "key");
        MovableObject lamp = new MovableObject("a large and cumbersome lamp.", "You try to light the lamp, but it is out of oil.", "lamp");
        MovableObject bottle = new MovableObject("a bottle of lamp oil", "you gaze at the golden liquid and it slaps against the side of the bottle", "oil");
        MovableObject bread = new MovableObject("Slightly stale rye bread.", "You try a piece but it's rather hard and takes too much effort to chew.", "bread");

        //item list for great hall
        r1.setItemContainer(itemsR1);

        //item list for side study
        itemsR2.add(desk);
        itemsR2.add(painting);
        itemsR2.add(lamp);
        r2.setItemContainer(itemsR2);

        //item list for gardens
        itemsR3.add(key);
        r3.setItemContainer(itemsR3);

        //item list for long passage
        itemsR4.add(window1Room4);
        itemsR4.add(bottle);
        r4.setItemContainer(itemsR4);

        //your backpack and items
        yourItems.add(bread);
        yourBackpack.setYourItems(yourItems);

        //doors
        Door r4D1 = new Door("first door to the west", "its a door", "first door right");
        Door r4D2 = new Door("second door to the west", "its a door", "second door right");
        Door r4D3 = new Door("third door to the west", "its a door", "third door right");
        Door r4D4 = new Door("first door to the east", "its a door", "first door left");
        Door r4D5 = new Door("second door to the east", "its a door", "second door left");
        Door r4D6 = new Door("third door to the east", "its a door", "third door left");


        //door map for long passage
        doorMapR4.put(r4D1 , r5);
        doorMapR4.put(r4D2 , r6);
        doorMapR4.put(r4D3 , r7);
        doorMapR4.put(r4D4 , r8);
        doorMapR4.put(r4D5 , r9);
        doorMapR4.put(r4D6 , r10);

        //init
        currentRoom = r1;
        String endGame = "endgame";

        //application
        do {
            System.out.println("You are in " + currentRoom.getRoomTitle() + "; " + currentRoom.getRoomDescription());
            System.out.print("There are exits to the ");

            for (String ky : currentRoom.getRoomMap().keySet()) {
                System.out.print(ky + ", ");
            }

            System.out.println("\nChoose a direction, or look around?");

            userDir = userInput.readLine().toLowerCase();

            if (userDir.contains("go") || userDir.contains("walk") || userDir.contains("move")) {
                boolean notDir = false;
                for (String kee : currentRoom.getRoomMap().keySet()) {
                    if (userDir.contains(kee)) {
                        currentRoom = currentRoom.getExitRoom(kee);
                        notDir = false;
                        System.out.println("");
                        break;
                    }
                    else{
                        notDir = true;
                    }
                }
                if (notDir) {
                    System.out.println("You cannot go that way.\n");
                }
            }
            else if (userDir.equals(endGame)) {
                break;
            }
            else if (userDir.contains("look") || userDir.contains("view")) {
                if (userDir.contains("around") || userDir.contains("room") || userDir.contains("location")) {
                    if (currentRoom.getItemContainer().isEmpty()) {
                        System.out.println("\nThe room is empty of items.\n");
                    } else {
                        System.out.println("\nYou find these items in the room...");
                        for (Item items : currentRoom.getItemContainer()) {
                            System.out.println(items.getItemName());
                        }
                        do {
                            System.out.println("\nWhat do you want to do?");

                            userDir = userInput.readLine().toLowerCase();

                            if (userDir.contains("look") || userDir.contains("view")) {
                                System.out.println(Item.viewItem(userDir, currentRoom));
                            }
                            else if (userDir.contains("pick") || userDir.contains("grab") || userDir.contains("take")){
                                Item removeItem = MovableObject.removeItem(userDir, currentRoom);

                                if (removeItem == null) {
                                    System.out.println("That item is not in the room.");
                                }
                                else {
                                    System.out.print("You place ");
                                    System.out.print(Backpack.addBackpackItem(removeItem, yourBackpack));
                                    System.out.print(" in your Backpack.");
                                }
                            }
                            else if (userDir.contains("back")){
                                System.out.println("");
                                break;
                            }
                            else {
                                System.out.println("You cannot do that.");
                            }
                        }while (!userDir.contains("back") && !userDir.contains("go") && !userDir.contains("leave") && userDir.contains("room"));
                    }
                } else if (userDir.contains("backpack")) {
                    System.out.println("\nThese are the items in your backpack...");
                    for (Item items : yourBackpack.getYourItems()) {
                        System.out.println(items.getItemName());
                    }
                    do {
                        System.out.println("\nWhat do you want to do?");
                        userDir = userInput.readLine().toLowerCase();

                        if (userDir.contains("look") || userDir.contains("view")) {
                            System.out.println(Backpack.viewBackpackItem(userDir, yourBackpack));
                        }
                        else if (userDir.contains("place") || userDir.contains("put") || userDir.contains("drop")){
                            Item removeBackpackItem = Backpack.removeBackpackItem(userDir, yourBackpack);

                            if (removeBackpackItem == null) {
                                System.out.println("That item is not in your Backpack.");
                            }
                            else {
                                System.out.print("You put ");
                                System.out.print(MovableObject.addItem(removeBackpackItem, currentRoom));
                                System.out.print(" in " + currentRoom.getRoomTitle());
                            }
                        }
                        else if (userDir.contains("back")){
                            System.out.println("");
                            break;
                        }
                        else {
                            System.out.println("You cannot do that.");
                        }
                    }while (!userDir.contains("back") && !userDir.contains("go") && !userDir.contains("leave") && userDir.contains("room"));
                }
            }
            else{
                System.out.println("That isn't a command.");
            }
        } while (!userDir.equals(endGame));
    }
}