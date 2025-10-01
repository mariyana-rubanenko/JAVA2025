package example_01;

public class Main_01 {

    public static void main(String[] args) {
        //
        StringModificator sm_1 = (text) -> text.toUpperCase();
        System.out.println(sm_1.getString("hello"));

        StringModificator sm_2 = (text) -> {
            String result = "";
            for (char let : text.toCharArray()) {
                if (Character.isLetter(let) || let == ' ') {
                    result += let;
                }
            }
            return result;
        };
        System.out.println(sm_2.getString("MIPT 123"));

        StringModificator sm_3 = (String text) -> "length = " + text.length();

    }
}
