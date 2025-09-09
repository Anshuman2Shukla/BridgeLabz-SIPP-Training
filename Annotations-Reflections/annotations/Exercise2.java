package annotations;

class LegacyAPI {
    @Deprecated
    public void oldFeature() {
        System.out.println("Old feature - do not use");
    }
    public void newFeature() {
        System.out.println("New feature - use this");
    }
}

public class Exercise2 {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature(); // IDE/compiler warns about deprecation
        api.newFeature();
    }
}
