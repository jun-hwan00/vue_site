public class RunLengthEncoding {

    public static void runLengthEncoding(String input) {
        int count = 1; 
        char prev = input.charAt(0); 

        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i); 
            if (current == prev) {
                count++;
            } else {  
                printCurrentCode(prev, count);
                count = 1;
                prev = current;
            }
        }
        printCurrentCode(prev, count); 
    }

    public static void printCurrentCode(char code, int count) {
        if (count == 0) { 
            System.out.println("Encoding error!");
            System.exit(1);
        }
        
        switch (code) {
            case 'W': case 'B': 
                System.out.print(count + "" + code);
                break;
            default:
                System.out.println("Encoding error!"); 
                System.exit(1);
        }
    }

    public static void main(String[] args) {
        String input = "WWBBWWW";
        runLengthEncoding(input);
    }
}
