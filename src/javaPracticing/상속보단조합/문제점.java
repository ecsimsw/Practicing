package javaPracticing.상속보단조합;

public class 문제점 {

    public static void main(String[] args) {
        EncryptedDocument encryptedDocument = new EncryptedDocument("value");
        System.out.println(encryptedDocument.content());
        System.out.println(encryptedDocument.length());
    }
}

class Document {
    String value;

    public Document(String value) {
        this.value = value;
    }

    public int length() {
        return value.length();
    }

    public String content() {
        return value;
    }
}

class EncryptedDocument extends Document {

    public EncryptedDocument(String value) {
        super(value);
    }

    public String content() {
        // decrypt encrypted
        String decryptedValue = "something";
        return decryptedValue;
    }
}