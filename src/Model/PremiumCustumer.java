package Model;

public class PremiumCustumer extends Custumer{
    private static StoredFiles preCustumer = new StoredFiles("Premium Custumers.json");

    public static StoredFiles getPreCustumer() {
        return preCustumer;
    }
}
