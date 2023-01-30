import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Server {

    private ArrayList<Node> nodes;
    private Scanner fileLink;

    public Server() throws FileNotFoundException{

        java.io.File filePath = new java.io.File("src/Data.csv");
        fileLink = new Scanner(filePath);
        nodes = new ArrayList<Node>();

        while (hasAnotherLine()) {
            String Line = getLine();
            String[] LineArray = splitLine(Line);

            int m_ingredient_size = Integer.parseInt(LineArray[0]);
            String name = LineArray[1];
            String ingredient = LineArray[2];
            String extra_ingredients = LineArray[3];
            String link = LineArray[4];

            Node n = new Node(m_ingredient_size,name, ingredient, extra_ingredients, link);
            nodes.add(n);

        }
        fileLink.close();
        System.out.println(nodes);
    }

    public boolean hasAnotherLine(){return fileLink.hasNextLine();}

    public String getLine(){return fileLink.nextLine();}

    public String[] splitLine(String Line){return Line.split(",");}

    public ArrayList<Integer> searchFoods (String userIngredients){
        ArrayList<Integer> availableMealsID = new ArrayList<Integer>();
        int ingredientCounter = 0;
        String[] user_userIngredients = splitLine(userIngredients);
        for (Node n : nodes){

            for (String ingredient : user_userIngredients){

                if(searchIngredients(n,ingredient)){}
                ingredientCounter +=1;
            }
            if(ingredientCounter == 5){
                availableMealsID.add(n.getID());
            }
        }
        return availableMealsID;
    }

    public boolean searchIngredients(Node n, String userIngredient) {
        String[] mainIngredients_split = n.getMain_ingredients().split(".");
        for (String i : mainIngredients_split) {
            if (i.equals(userIngredient)){
                return true;
            }
        }
        return false;
    }

    public Node getNode(int NodeID){
        for(Node n : nodes){
            if(NodeID == n.getID()){
                return n;
            }
        }
        return null;
    }
}
