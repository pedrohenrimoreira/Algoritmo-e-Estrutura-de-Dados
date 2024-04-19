import java.io.BufferedReader;
import java.io.FileReader;

class Personagem{
    private String nome;
    private int altura;
    private double pesoDouble;
    private int pesoInt;
    private String corDoCabelo;
    private String corDaPele;
    private String corDosOlhos;
    private String anoNascimento;
    private String genero;
    private String homeworld;
    public Personagem(){
        pesoDouble=0;
        pesoInt=0;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setAltura(int altura){
        this.altura=altura;
    }
    public int getAltura(){
        return this.altura;
    }
    public void setPeso(double peso){
        this.pesoDouble=peso;
    }
    public double getPeso(){
        return this.pesoDouble;
    }
    public void setPesoInt(int peso){
        this.pesoInt=peso;
    }
    public int getPesoInt(){
        return this.pesoInt;
    }
    public void setCorDoCabelo(String cor){
        this.corDoCabelo=cor;
    }
    public String getCorDoCabelo(){
        return this.corDoCabelo;
    }
    public void setCorDaPele(String cor){
        this.corDaPele=cor;
    }
    public String getCorDaPele(){
        return this.corDaPele;
    }
    public void setCorDosOlhos(String cor){
        this.corDosOlhos=cor;
    }
    public String getCorDosOlhos(){
        return this.corDosOlhos;
    }
    public void setAnoNascimento(String ano){
        this.anoNascimento=ano;
    }
    public String getAnoNascimetno(){
        return this.anoNascimento;
    }
    public void setGenero(String genero){
        this.genero=genero;
    }
    public String getGenero(){
        return this.genero;
    }
    public void setHomeworld(String homeworld){
        this.homeworld=homeworld;
    }
    public String getHomeworld(){
        return this.homeworld;
    }
    public void Leitura(String entrada){
        try{
            BufferedReader buff = new BufferedReader(new FileReader(entrada));
            String str = buff.readLine();
            Criador(str);
        } catch(Exception e){         
        }
    }
    public void Criador(String str){
        // Pegar nome
        for(int i=0;i<str.length()-4;i++){
            if(str.substring(i, i+4).equals("name")){
                String nome="";
                for(int j=i+8;str.charAt(j)!=39;j++){
                    nome+=str.charAt(j);
                }
                setNome(nome);
                i=str.length();
            }
        }
        // Pegar altura
        for(int i=0;i<str.length()-6;i++){
            if(str.substring(i, i+6).equals("height")){
                String altura="";
                for(int j=i+10;str.charAt(j)!=39;j++){
                    altura+=str.charAt(j);
                }
                try{setAltura(Integer.parseInt(altura));}
                catch(Exception e){}
                i=str.length();
            }
        }
        // Pegar peso
        for(int i=0;i<str.length()-4;i++){
            if(str.subSequence(i, i+4).equals("mass")){
                String peso="";
                for(int j=i+8;str.charAt(j)!=39;j++){
                    peso+=str.charAt(j);
                }

                try{setPesoInt(Integer.parseInt(peso));}
                catch(Exception e){
                    setPeso(Double.parseDouble(peso));
                }
                i=str.length();
            }
        }
        // Pegar cor do cabelo
        for(int i=0;i<str.length()-10;i++){
            if(str.subSequence(i, i+10).equals("hair_color")){
                String cor="";
                for(int j=i+14;str.charAt(j)!=39;j++){
                    cor+=str.charAt(j);
                }
                setCorDoCabelo(cor);
                i=str.length();
            }
        }
        // Pegar cor da pele
        for(int i=0;i<str.length()-10;i++){
            if(str.subSequence(i, i+10).equals("skin_color")){
                String cor="";
                for(int j=i+14;str.charAt(j)!=39;j++){
                    cor+=str.charAt(j);
                }
                setCorDaPele(cor);
                i=str.length();
            }
        }
        // Pegar cor do olho
        for(int i=0;i<str.length()-9;i++){
            if(str.subSequence(i, i+9).equals("eye_color")){
                String cor="";
                for(int j=i+13;str.charAt(j)!=39;j++){
                    cor+=str.charAt(j);
                }
                setCorDosOlhos(cor);
                i=str.length();
            }
        }
        // Pegar ano de nascimento
        for(int i=0;i<str.length()-10;i++){
            if(str.subSequence(i, i+10).equals("birth_year")){
                String ano="";
                for(int j=i+14;str.charAt(j)!=39;j++){
                    ano+=str.charAt(j);
                }
                setAnoNascimento(ano);
                i=str.length();
            }
        }
        // Pegar gênero
        for(int i=0;i<str.length()-6;i++){
            if(str.substring(i, i+6).equals("gender")){
                String genero="";
                for(int j=i+10;str.charAt(j)!=39;j++){
                    genero+=str.charAt(j);
                }
                setGenero(genero);
                i=str.length();
            }
        }
        // Pegar homeworld
        for(int i=0;i<str.length()-9;i++){
            if(str.subSequence(i, i+9).equals("homeworld")){
                String home="";
                for(int j=i+13;str.charAt(j)!=39;j++){
                    home+=str.charAt(j);
                }
                setHomeworld(home);
                i=str.length();
            }
        }
    }
    public void Imprime(){
        MyIO.print(" ## ");
        MyIO.print(getNome());
        MyIO.print(" ## ");
        MyIO.print(getAltura());
        MyIO.print(" ## ");
        if(getPesoInt()==-0)
        MyIO.print(getPeso());
        else
        MyIO.print(getPesoInt());
        MyIO.print(" ## ");
        MyIO.print(getCorDoCabelo());
        MyIO.print(" ## ");
        MyIO.print(getCorDaPele());
        MyIO.print(" ## ");
        MyIO.print(getCorDosOlhos());
        MyIO.print(" ## ");
        MyIO.print(getAnoNascimetno());
        MyIO.print(" ## ");
        MyIO.print(getGenero());
        MyIO.print(" ## ");
        MyIO.print(getHomeworld());
        MyIO.println(" ## ");
    }
}
public class TP02Q01 {
    public static void main(String[] args){
        String entrada=MyIO.readLine();
        while(!entrada.equals("FIM")){
            Personagem personagem = new Personagem();
            personagem.Leitura(entrada);
            personagem.Imprime();
            entrada=MyIO.readLine();
        }
    }
}
