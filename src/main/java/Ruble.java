public class Ruble {
    public String ending (double amount) {
        int integerPart = (int) amount;

        String integerPartString = Integer.toString(integerPart);
        String currency = "рубл";

        if (integerPart % 10 == 1 && integerPart % 100 != 11) {
            currency += "ь";
        } else if (integerPart % 10 >= 2 && integerPart % 10 <= 4 && (integerPart % 100 < 10 || integerPart % 100 >= 20)) {
            currency += "я";
        } else {
            currency += "ей";
        }

        return integerPartString + " " + currency;
    }
}
