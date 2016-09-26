class MovableObject extends Item{

    MovableObject(String itemName, String itemDescription, String itemCall) {
        super(itemName, itemDescription, itemCall);
    }

    static Item removeItem (String userDir, Room currentRoom) {
        Item theItem = null;
        String call;
        int index;
        for (Item item : currentRoom.getItemContainer()) {
            call = item.getItemCall();
            index = currentRoom.getItemContainer().indexOf(item);

            if (userDir.contains(call)) {
                currentRoom.getItemContainer().remove(index);
                theItem = item;
                break;

            } else {
                theItem = null;
            }
        }
        return theItem;
    }

    static String addItem (Item removeBackpackItem, Room currentRoom) {

        currentRoom.getItemContainer().add(removeBackpackItem);

        return removeBackpackItem.getItemName();
    }


}
