import java.util.ArrayList;

class Backpack {
    private ArrayList yourItems;

    Backpack(ArrayList yourItems) {
        this.yourItems = yourItems;
    }

    ArrayList<Item> getYourItems() {
        return yourItems;
    }

    void setYourItems(ArrayList yourItems) {
        this.yourItems = yourItems;
    }

    static String viewBackpackItem(String userDir, Backpack yourBackpack) {
        String getTheStuff = "";
        String call;
        int index;
            for (Item item : yourBackpack.getYourItems()) {
                call = item.getItemCall();
                index = yourBackpack.getYourItems().indexOf(item);

                if (userDir.contains(call)) {
                    getTheStuff = yourBackpack.getYourItems().get(index).getItemDescription() + "";
                    break;
                } else {
                    getTheStuff = "You cannot do that.\n;";
                }
            }
        return getTheStuff;
    }

    static String addBackpackItem (Item removeItem, Backpack yourBackpack) {

        yourBackpack.getYourItems().add(removeItem);

        return removeItem.getItemName();
    }

    static Item removeBackpackItem (String userDir, Backpack yourBackpack) {
        Item theItem = null;
        String call;
        int index;
        for (Item item : yourBackpack.getYourItems()) {
            call = item.getItemCall();
            index = yourBackpack.getYourItems().indexOf(item);

            if (userDir.contains(call)) {
                yourBackpack.getYourItems().remove(index);
                theItem = item;
                break;

            } else {
                theItem = null;
            }
        }
        return theItem;
    }

}



