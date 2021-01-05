package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField txtKey;

    @FXML
    private TextField txtPlainText;

    @FXML
    private TextField txtCipherText;

    @FXML
    private Button btnEncrypt;

    @FXML
    private Button btnDecrypt;

    @FXML
    void btnDecryptOnAction(ActionEvent event) {
        String cipher=txtKey.getText();
        String cipherText=txtCipherText.getText();

        cipher=cipher.toUpperCase();
        cipherText=cipherText.toUpperCase();

        txtKey.setText(cipher);
        txtCipherText.setText(cipherText);

        CipherMethod cipherMethod=new CipherMethod();
        cipherMethod.setCallback(new Encryption().getMonoCipherMethod());

        txtPlainText.setText(cipherMethod.decryptText(cipherText,cipher));

    }

    @FXML
    void btnEncryptOnAction(ActionEvent event) {
        String cipher=txtKey.getText();
        String plainText=txtPlainText.getText();

        cipher=cipher.toUpperCase();
        plainText=plainText.toUpperCase();

        txtPlainText.setText(plainText);
        txtKey.setText(cipher);

        CipherMethod cipherMethod=new CipherMethod();
        cipherMethod.setCallback(new Encryption().getMonoCipherMethod());

        txtCipherText.setText(cipherMethod.encryptText(plainText,cipher));
    }

}
