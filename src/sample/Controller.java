package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable{

    @FXML
    private Button buttonHello;

    @FXML
    private Button buttonAddWords;

    @FXML
    private Label labelWords;

    @FXML
    private TextField textFieldAddWords;


    private List<String> wordss;
    private List<String> randedWords = new ArrayList<>();
    private Random random;


    public void setTextFieldAddWords(){
        wordss.add(textFieldAddWords.getText());
        textFieldAddWords.clear();
    }


//    public void kliknięcie(){
//        System.out.println("Hellloooo");
//    }
// opcja w scene builder

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        words = Arrays.asList("Życie jest piękne", "Jutra nie będzie", "AkademiaKodu uczy jak żyć...","Beata jak żyć");
//        raz tworzy listę ze stałą liczbą pól itd, można wynulować

       wordss = new ArrayList<>();
       wordss.add("Życie jest piękne");
       wordss.add("Jutra nie będzie");
       wordss.add("AkademiaKodu uczy jak żyć...");

        random = new Random();

        createDialog("Siemka ziom!","","Witaj w naszych sentencjach");

        textFieldAddWords.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ENTER)){
                    setTextFieldAddWords();
                }
            }
        });
        buttonAddWords.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setTextFieldAddWords();
            }
        });
        buttonHello.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               handleRandomSentence();
                }
        });
    }
    private void handleRandomSentence(){
        String randedWord = wordss.get(random.nextInt(wordss.size()));
        while (randedWords.contains(randedWord)) {
            if (randedWords.size() >= wordss.size()) {

                createDialog("Błąd","","Koniec sentencji");
                return; }
            randedWord = wordss.get(random.nextInt(wordss.size()));
        }
        labelWords.setText(randedWord);
        randedWords.add(randedWord);

    }

    public static void createDialog(String title, String header,String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(header);
        alert.setHeaderText(content);
        alert.show();
    }

//    private void handleKeyPressed(){
//
//    }

}
