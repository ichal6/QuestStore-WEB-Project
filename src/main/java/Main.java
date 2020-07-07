import model.CodecoolerClass;

public class Main {
    public static void main(String[] args) {
        CodecoolerClass simpleClass = new CodecoolerClass
                .Builder()
                .withID(1)
                .withCity("Mielec")
                .withName("Nasza Klasa")
                .build();

        System.out.println(simpleClass.getCity() + " " + simpleClass.getName() + " " + simpleClass.getId());
    }
}
