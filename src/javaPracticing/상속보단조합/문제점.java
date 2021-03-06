package javaPracticing.상속보단조합;

public class 문제점 {

    public static void main(String[] args) {
        EncryptedDocument encryptedDocument = new EncryptedDocument("value");
        System.out.println(encryptedDocument.content());
        System.out.println(encryptedDocument.length());
    }
}

class Document {
    final String value;
    private int length;

    public Document(String value) {
        this.value = value;
    }

    public int length() {
        return content().length();
    }

    String content() {
        return value;
    }
}

class EncryptedDocument extends Document {

    public EncryptedDocument(String value) {
        super(value);
    }

    @Override
    public String toString() {
        return content();
    }

    @Override
    public String content() {
        String decryptedValue = "something";
        return decryptedValue;
    }
}
