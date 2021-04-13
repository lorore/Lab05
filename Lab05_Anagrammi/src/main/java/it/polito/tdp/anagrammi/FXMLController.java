

package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Anagramma;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    private Button btnReset;

    @FXML
    void handleCalcolaAnagrammi(ActionEvent event) {
    	this.txtAnagrammiCorretti.clear();
    	this.txtAnagrammiErrati.clear();
    	String parola=this.txtParola.getText();
    	if(parola.isEmpty()) {
    		this.txtAnagrammiCorretti.setText("Nessuna parola inserita");
    		return;
    	}
    	
    	if(parola.length()>8) {
    		this.txtAnagrammiCorretti.setText("Per piacere, non inserire parole con più di 8 caratteri");
    		return;
    	}
    	
    List<Anagramma> result=this.model.generaAnagrammi(parola);
    for(Anagramma a: result) {
    	if(a.isCorrect())
    		this.txtAnagrammiCorretti.appendText(a+"\n");
    	else
    		this.txtAnagrammiErrati.appendText(a+"\n");
    }
    return;	
    	
    }

    @FXML
    void handleReset(ActionEvent event) {
    	this.txtParola.clear();
    	this.txtAnagrammiCorretti.clear();
    	this.txtAnagrammiErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model=model;
    }
}
