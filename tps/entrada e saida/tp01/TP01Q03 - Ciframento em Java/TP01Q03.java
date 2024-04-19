import java.util.*; 

class Ciframento {


    public static boolean isfim(String b) {
        if(b.charAt(0) == 'F' && b.charAt(1) == 'I' && b.charAt(2) == 'M' && b.length() == 3) 
        return false;
        return true;
        
    }

    public static String cesar(String texto) {
        int chave = 3;
        char[] crypto = new char[texto.length()];
        for (int i = 0; i < texto.length(); i ++) {
        if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z'){
        crypto[i] = (char)(((((int) texto.charAt(i) - 'A') + chave) % 26) + 'A');
        }
        else if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
            crypto[i] = (char)(((((int) texto.charAt(i) - 'a') + chave) % 26) + 'a');
        }
        else if (texto.charAt(i) > 0 && texto.charAt(i) < 127) {
            crypto[i] += (texto.charAt(i) + chave);
        }
       else{
            crypto[i] = texto.charAt(i);
        }
        }
        String str = String.valueOf(crypto);
        System.out.println(str);
        return str;
    }         

public static void main (String[] args) {
     // criar scanner
     Scanner sc = new Scanner(System.in);
     String[] str = new String[1000];
     int y = 0; // numero de strings
     // ler palavras
     do {
         str[y] = sc.nextLine(); 
     } while (isfim(str[y++]));
     y--; //desconsiderar FIM

     for (int i = 0; i < y; i++) 
    cesar(str[i]);
}    
}