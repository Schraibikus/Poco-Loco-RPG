public class Trader implements Seller{

    @Override
    public String sell(Products products) {
        String result = "";
        if (products == Products.POTION){
            result = "зелье";
            return result;
        } else if (products == Products.SWORD){
            result = "меч";
            return result;
        } else result = "щит";
        return result;
    }
    public enum Products{
        POTION, SWORD, SHIELD
    }
}
