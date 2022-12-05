import java.io.IOException;


public class Runner {

    public static void main(String[] args) throws IOException {
        ParserService parser = new ParserService();

        Rate minyayloRate = parser.getMinyayloRate();
        Rate bankRate = parser.getBankRate();
        Rate cashRate = parser.getCashRate();

        System.out.println(minyayloRate);
        System.out.println(cashRate);
        System.out.println(bankRate);


    }
}







