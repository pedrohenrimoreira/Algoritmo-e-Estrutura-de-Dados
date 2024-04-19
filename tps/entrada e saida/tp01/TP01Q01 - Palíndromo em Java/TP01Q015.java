import java.util.*; 

class TP01Q015 {

    public static boolean isfim(String b) {
        if(b.charAt(0) == 'F' && b.charAt(1) == 'I' && b.charAt(2) == 'M' && b.length() == 3) 
        return false;
        return true;
        
    }

    public static void is(String texto) {
    texto.toLowerCase();
    System.out.print(isVogal(texto)  + " ");
    System.out.print(isconsu(texto)  + " ");
    System.out.print(isint(texto)  + " ");
    System.out.println(isreal(texto));
    }


    public static String isVogal(String texto) {
        return isVogal(texto, 0);
    }
    public static String isVogal(String texto, int i) {
        String resp;
        if (i == texto.length()) {
        resp = ("SIM");
        }
        else if (texto.charAt(i) != 'a' && texto.charAt(i) != 'e' && texto.charAt(i) != 'i' && texto.charAt(i) != 'o' && texto.charAt(i) != 'u') {
        resp = ("NAO");
        }
        else {
            resp = isVogal(texto, i + 1);
        }
        return resp;
    }
    public static String isconsu(String texto) {
        return isconsu(texto, 0);
    }
    public static String isconsu(String texto, int i) {
        String resp;
        if (i == texto.length()) {
        resp = ("SIM");
        }
        else if (!(texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') || (texto.charAt(i) == 'a' || texto.charAt(i) == 'e' || texto.charAt(i) == 'i' || texto.charAt(i) == 'o' || texto.charAt(i) == 'u')) {
        resp = ("NAO");
        }
        else {
            resp = isconsu(texto, i + 1);
        }
        return resp;
       }

    public static String isint(String texto) {
        return isint(texto, 0);
    }
    public static String isint(String texto, int i) {
        String resp;
        if (i == texto.length()) {
        resp = ("SIM");
        }
        else if (!(texto.charAt(i) >= '0' && texto.charAt(i) <= '9')) {
        resp = ("NAO");
        }
        else {
            resp = isint(texto, i + 1);
        }
        return resp;
       }
       
       public static String isreal(String texto) {
        return isreal(texto, 0, 0);
       }
       public static String isreal(String texto, int i, int count) {
        String resp;
        if (i == texto.length()) {
        resp = ("SIM");
        }
        else if (!(((texto.charAt(i) >= '0' && texto.charAt(i) <= '9') || texto.charAt(i) == ',' || texto.charAt(i) == '.') && count < 2)) {
        resp = ("NAO");
        }
        else {
            if (texto.charAt(i) == ',' || texto.charAt(i) == '.') {
            count++;
            }
            resp = isreal(texto, i + 1, count);
        }
        return resp;
       }     

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = new String[1000];
        int y = 0; // numero de strings
        // ler palavras
        do {
            str[y] = sc.nextLine(); 
        } while (isfim(str[y++]));
        y--; //desconsiderar FIM

        for (int i = 0; i < y; i++) {
            is(str[i]);
            }
    }

    
}