package sample;

public class CipherMethod {
    private IEncryptable callback;

    public IEncryptable getCallback() {
        return callback;
    }

    public void setCallback(IEncryptable callback) {
        this.callback = callback;
    }

    public String encryptText(String plainText, String cipher){
        return callback.encrypt(plainText,cipher);
    }

    public String decryptText(String cipherText, String cipher){
        return callback.decrypt(cipherText,cipher);
    }
}
