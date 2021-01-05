package sample;

public class TestMethod {
    private CipherMethod method;

    public TestMethod() {
        this.method=new CipherMethod();
        this.method.setCallback(new Encryption().getMonoCipherMethod());
    }


    public static void main(String[] args) {

        TestMethod tm=new TestMethod();

        System.out.println(tm.method.encryptText("WEATHER","FEATHER"));
        System.out.println(tm.method.decryptText("GHFKYHM","FEATHER"));
    }
}
