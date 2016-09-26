class Item {
    private String itemCall;
    private String itemName;
    private String itemDescription;

    Item(String itemName, String itemDescription, String itemCall) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemCall = itemCall;
    }

    String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    String getItemCall() {
        return itemCall;
    }

    public void setItemCall(String itemCall) {
        this.itemCall = itemCall;
    }

    static String viewItem(String userDir, Room currentRoom) {
        String getTheStuff = "";
        String call;
        int index;
            for (Item item : currentRoom.getItemContainer()) {
                call = item.getItemCall();
                index = currentRoom.getItemContainer().indexOf(item);

                if (userDir.contains(call)) {
                    getTheStuff = currentRoom.getItemContainer().get(index).getItemDescription() + "";
                    break;
                } else {
                    getTheStuff = "You cannot do that.\n";
                }
            }
        return getTheStuff;
    }
}
