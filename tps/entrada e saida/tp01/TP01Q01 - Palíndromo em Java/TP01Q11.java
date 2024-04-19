import java.util.*; 

class TP01Q11 {

    public static boolean ispal(String x) {
        return ispal(x, 0);
    }

    public static boolean ispal(String x, int i) {
        boolean resp;
        if (i == x.length() / 2){
            resp = true;
        }
        else if (x.charAt(i) != x.charAt(x.length() - i - 1)) {
            resp = false;
        }
        else {
            resp = ispal(x, i + 1);
        }
        return resp;
    }

    public static boolean isfim(String b) {
            if(b.charAt(0) == 'F' && b.charAt(1) == 'I' && b.charAt(2) == 'M') 
            return false;
            return true;
            
        }


    public static void imprimir(String a) {
    if (ispal(a) == true) 
    System.out.println("SIM");
    else 
    System.out.println("NAO");
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


    // chamar função de imprimir
    for (int i = 0; i < y; i++) 
    imprimir(str[i]);
     
    } 

}