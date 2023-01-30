import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GUI extends JFrame{

    private JPanel main;
    private JTextArea Title;
    private JTextPane ingredients_input_area;
    private JTextPane food_display;
     String input = " ";
    JButton confirm_button;

    public String getInput() {
        return input;
    }
    public void setInput(String input) { this.input = input;}


    public GUI() {
        Title.setText("FoodForThought?");
        Title.setEditable(false);
        setContentPane(main);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        food_display.setEditable(false);
        ingredients_input_area.setEditable(true);

        setSize(600,500);
        setVisible(true);
        setResizable(false);

        ingredients_input_area.setText("type ingredients here e.g(eggs,bread)");
        ingredients_input_area.setSize(200,200);
        ingredients_input_area.setMaximumSize(new Dimension(200,200));
        ingredients_input_area.setMinimumSize(new Dimension(200,200));


        confirm_button = new JButton();
        confirm_button.setBounds(70,375,150,50);
        confirm_button.setText("Search foods");
        confirm_button.setBackground(new Color(27,225,154));
        try {
            this.add(confirm_button);
        }
        catch(NullPointerException e){
            System.out.println("NullPointerException thrown!");
        }


        food_display.setSize(150,275);
        food_display.setMaximumSize(new Dimension(275,200));
        food_display.setMinimumSize(new Dimension(275,200));

        confirm_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input = "RUN";
            }
        });


    }



    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        GUI gui = new GUI();
        Server server = new Server();
        Node node = new Node();
        boolean running = true;
        String userInput ;
        String displayedText=("");
        ArrayList<Integer> foodIDs = new ArrayList<Integer>();

        while (running){
            while (gui.getInput().equals(" ") ){
                TimeUnit.MILLISECONDS.sleep(100);
            }

            userInput = gui.ingredients_input_area.getText();
            System.out.println(gui.ingredients_input_area.getText());
            foodIDs = server.searchFoods(userInput);

            for(int ID : foodIDs){
                node = server.getNode(ID);
                displayedText = displayedText + node.toString();
            }

            gui.food_display.setText(displayedText);
            if (displayedText.equals("")){
                gui.food_display.setText("NO FOODS FOUND");
            }
            gui.setInput(" ");
            userInput = "" ;
            displayedText = "" ;
        }










    }
}
