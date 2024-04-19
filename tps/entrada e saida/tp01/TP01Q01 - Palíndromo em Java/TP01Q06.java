public class TP01Q06 {
    public static boolean isVogal(String fra){
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)!=65&&fra.charAt(i)!=69&&fra.charAt(i)!=73&&fra.charAt(i)!=79&&fra.charAt(i)!=85&&fra.charAt(i)!=97&&fra.charAt(i)!=101&&fra.charAt(i)!=105&&fra.charAt(i)!=111&&fra.charAt(i)!=117){
                return false;
            }
        }
        return true;
    }
    public static boolean isConsoante(String fra){
        for(int i=0;i<fra.length();i++){
            for(int a=65;a<=90;a++){
                if(fra.charAt(i)==65||fra.charAt(i)==69||fra.charAt(i)==73||fra.charAt(i)==79||fra.charAt(i)==85||fra.charAt(i)==97||fra.charAt(i)==101||fra.charAt(i)==105||fra.charAt(i)==111||fra.charAt(i)==117){
                    return false;
                }
                else if(fra.charAt(i)==a){
                    a=90;
                }
                else if(fra.charAt(i)>=97&&fra.charAt(i)<=122){
                    a=90;
                }
                else{
                    return false;
                }
            }
                
        }
        return true;
    }
    public static boolean isInt(String fra){
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)>=48&&fra.charAt(i)<=57){
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static boolean isReal(String fra){
        int ponto=0;
        for(int i=0;i<fra.length();i++){          
            if(fra.charAt(i)>=48&&fra.charAt(i)<=57){
            }
            else if((fra.charAt(i)==46||fra.charAt(i)==44)&&ponto==0){                   
                ponto++;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String[] frase = new String[1000];
        int a=0;
        int i=0;
        Boolean[] X1 = new Boolean[1000];
        Boolean[] X2 = new Boolean[1000];
        Boolean[] X3 = new Boolean[1000];
        Boolean[] X4 = new Boolean[1000];
        do{
            frase[i] = MyIO.readLine();
            if(frase[i].charAt(0)=='F'&&frase[i].charAt(1)=='I'&&frase[i].charAt(2)=='M'&& frase[i].length()==3){
                a=1;
            }
            else{
                X1[i]= isVogal(frase[i]);
                X2[i] = isConsoante(frase[i]);
                X3[i] = isInt(frase[i]);
                X4[i] = isReal(frase[i]);
            }
            i++;
        }while(a==0);
        for(int x=0;x<i-1;x++){
            if(X1[x]==true){
                MyIO.print("SIM ");
            }
            else{
                MyIO.print("NAO ");
            }
            if(X2[x]==true){
                MyIO.print("SIM ");
            }
            else{
                MyIO.print("NAO ");
            }
            if(X3[x]==true){
                MyIO.print("SIM ");
            }
            else{
                MyIO.print("NAO ");
            }
            if(X4[x]==true){
                MyIO.print("SIM");
            }
            else{
                MyIO.print("NAO");
            }
            MyIO.print("\n");
        }
    }
}
