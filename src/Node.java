
public class Node {
    private int ID;
    private String name;
    private String main_ingredients;
    private String extra_ingredients;
    private String link;

    public Node() {}

    public Node(int ID, String name, String main_ingredients, String extra_ingredients, String link){
        this.ID = ID;
        this.name = name;
        this.main_ingredients = main_ingredients;
        this.extra_ingredients = extra_ingredients;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public String getMain_ingredients() {
        return main_ingredients;
    }

    public String getExtra_ingredients() {
        return extra_ingredients;
    }

    public String getLink() {
        return link;
    }

    public int getID() {return ID;}

    public String toString() {
        return name + "main ingredients: " + main_ingredients + "\n " +
                "extra ingredients: " + extra_ingredients + "\n" +
                "Recipe link: " + link;
    }
}

