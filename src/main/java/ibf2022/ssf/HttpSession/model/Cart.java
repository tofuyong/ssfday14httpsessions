package ibf2022.ssf.HttpSession.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Cart implements Serializable{

    private List<Item> contents = new LinkedList<>();
    

    public List<Item> getContents() {
        return this.contents;
    }

    public void setContents(List<Item> contents) {
        this.contents = contents;
    }

    //Method to add items to list
    public void addItemToCart(Item item){
        this.contents.add(item);
    }
    
    
}
