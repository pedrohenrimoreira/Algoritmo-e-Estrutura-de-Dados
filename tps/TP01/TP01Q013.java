

import java.util.*; 

class TP01Q013 {


    public static boolean isfim(String b) {
        if(b.charAt(0) == 'F' && b.charAt(1) == 'I' && b.charAt(2) == 'M' && b.length() == 3) 
        return false;
        return true;
        
    }

    public static String cesar(String texto) {
        StringBuffer sb = new StringBuffer();
        sb.append(texto);
        return cesar(sb, 0);
    }

    public static String cesar(StringBuffer texto, int i) {
        int chave = 3;
        String resp;
        if (i == texto.length()) {
        String str = texto.toString();
        System.out.println(str);
        resp = str;
        }
        else {
            if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z'){
                texto.setCharAt(i,(char)(((((int) texto.charAt(i) - 'A') + chave) % 26) + 'A'));
                }
                else if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                    texto.setCharAt(i,(char)(((((int) texto.charAt(i) - 'a') + chave) % 26) + 'a'));
                }
                else if (texto.charAt(i) > 0 && texto.charAt(i) < 127) {
                    texto.setCharAt(i,(char) (texto.charAt(i) + chave));
                }
            resp = cesar (texto, i + 1);    
        }
        return resp;
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