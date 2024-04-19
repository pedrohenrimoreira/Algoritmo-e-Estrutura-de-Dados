import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class TP03Q03{

    public static void main(String[] args) throws Exception {

        String[] entrada = new String[1000];
        Scanner sc = new Scanner(new File("/tmp/games.csv")); // /tmp/games.csv
        Scanner scanner = new Scanner(System.in, "ISO-8859-1");

        int n = 0, count = 0;

        Games[] obj = new Games[4403];

        Lista lista = new Lista();

        while (sc.hasNext()) {

            obj[count] = new Games();

            String[] lineFilter = sc.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            obj[count].setAppId(Integer.parseInt(lineFilter[0]));

            obj[count].setName(lineFilter[1]);

            String dateFormate = lineFilter[2].replace("\"", "");
            String date = dateFormate.substring(0, 3) + "/"
                    + dateFormate.substring(dateFormate.length() - 4, dateFormate.length());
            obj[count].setDate((new SimpleDateFormat("MMM/yyyy", Locale.US).parse(date)));

            obj[count].setOwners(lineFilter[3]);

            obj[count].setAge(Integer.parseInt(lineFilter[4]));

            obj[count].setPrice(Float.parseFloat(lineFilter[5]));

            obj[count].setDlcs(Integer.parseInt(lineFilter[6]));

            obj[count].setLanguages(lineFilter[7].split("(\"\\[')|(', ')|('\\]\")"));

            obj[count].setWebsite(lineFilter[8]);

            obj[count].setWindows(Boolean.valueOf(lineFilter[9]));

            obj[count].setMac(Boolean.valueOf(lineFilter[10]));

            obj[count].setLinux(Boolean.valueOf(lineFilter[11]));

            obj[count].setUpVotes(Float.parseFloat(lineFilter[12])
                    / (Float.parseFloat(lineFilter[12]) + Float.parseFloat(lineFilter[13])));

            obj[count].setAvg_pt(Integer.parseInt(lineFilter[14]));

            obj[count].setDevelopers(lineFilter[15]);

            obj[count].setGenres((lineFilter.length > 16) ? lineFilter[16].split(",") : null);
            count++;

        }

        do {
            entrada[n] = scanner.nextLine();
        } while (!(isFim(entrada[n++])));
        n--;

        sc.close();
        scanner.close();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < count; j++) {
                if (Integer.parseInt(entrada[i]) == obj[j].getAppId()) {
                    lista.inserirFim(obj[j]);
                }
            }
        }

        lista.insertionSort();
        lista.mostrar();
    } 

    static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
}

class Lista {

    // ATRIBUTOS
    // -----------------------------------------------------------------------------------
    // ATRIBUTOS
    private Games[] array;
    private int n;

    // CONSTRUTORES
    // --------------------------------------------------------------------------------
    // CONSTRUTORES
    public Lista() {
        this(1000);
    }

    public Lista(int tam) {
        array = new Games[1000];
        n = 0;
    }

    // METODOS
    // -------------------------------------------------------------------------------------
    // METODOS
    public void inserirInicio(Games s) throws Exception { // Inserir Inicio

        if (n >= array.length) {
            throw new Exception("Tamanho da Lista Excedido");
        }

        for (int i = n; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = s;
        n++;
    }

    public void inserirFim(Games s) throws Exception { // Inserir Fim

        if (n >= array.length) {
            throw new Exception("Tamanho da Lista Excedido");
        }

        array[n] = s;
        n++;
    }

    public void inserir(Games s, int pos) throws Exception { // Inserir

        if (n >= array.length) {
            throw new Exception("Tamanho da Lista Excedido");
        }

        for (int i = n; i > pos; i--) {
            array[i] = array[i - 1];
        }

        array[pos] = s;
        n++;
    }

    public String removerInicio() throws Exception { // Remover Inicio

        if (n == 0) {
            throw new Exception("Lista vazia");
        }

        String resp = array[0].getName();
        n--;

        for (int i = 0; i < n; i++) {
            array[i] = array[i + 1];
        }

        return resp;
    }

    public String removerFim() throws Exception { // Remover Fim

        if (n == 0) {
            throw new Exception("Lista vazia");
        }

        return array[--n].getName();
    }

    public String remover(int pos) throws Exception { // Remover

        if (n == 0 || pos < 0 || pos >= n) {
            throw new Exception("Posicao inexistente da Lista");
        }

        String resp = array[pos].getName();
        n--;

        for (int i = pos; i < n; i++) {
            array[i] = array[i + 1];
        }

        return resp;
    }

    public void mostrar() { // Mostrar

        for (int i = 0; i < n; i++) {
            array[i].imprimir();
        }
    }

    public void insertionSort() {
        int j;
        int key;
        int i;  

        for (j = 1; j < n; j++) {
            //key = array[j].getAppId();
            //MyIO.println(key);
            Games temp = array[j].clone();
            for (i = j - 1; (i >= 0) && (array[i].getAppId() > temp.getAppId()); i--) {
                array[i + 1] = array[i].clone();
            }
            array[i + 1] = temp.clone();
        }
    }

}

class Games {

    // ATRIBUTOS
    // -----------------------------------------------------------------------------------

    private int app_id;
    private int age;
    private int avg_pt;
    private int dlcs;
    private Date release_date;
    private String name;
    private String owners;
    private String website;
    private String developers;
    private String[] languages;
    private String[] genres;
    private float price;
    private float upvotes;
    private boolean windows;
    private boolean mac;
    private boolean linux;

    // SimpleDateFormat formataador = new SimpleDateFormat("MMM/yyyy", Locale.US);

    // CONSTRUTORES
    // --------------------------------------------------------------------------------

    Games() {
        app_id = 0;
        name = "";
        release_date = null;
        owners = "";
        age = 0;
        price = 0;
        dlcs = 0;
        languages = null;
        website = "";
        windows = true;
        mac = true;
        linux = true;
        upvotes = 0;
        avg_pt = 0;
        developers = "";
        genres = null;
    }

    // link do dateformat
    // https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
    SimpleDateFormat formataador = new SimpleDateFormat("MMM/yyyy", Locale.US);

    // GETS E SETS
    // ---------------------------------------------------------------------------------

    public int getAppId() {
        return this.app_id;
    }

    public void setAppId(int app_id) {
        this.app_id = app_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return formataador.format(this.release_date);
    }

    public void setDate(Date release_date) {
        this.release_date = release_date;
    }

    public String getOwners() {
        return this.owners;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getDlcs() {
        return this.dlcs;
    }

    public void setDlcs(int dlcs) {
        this.dlcs = dlcs;
    }

    public String[] getLanguages() {
        return this.languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Boolean getWindows() {
        return this.windows;
    }

    public void setWindows(Boolean windows) {
        this.windows = windows;
    }

    public Boolean getMac() {
        return this.mac;
    }

    public void setMac(Boolean mac) {
        this.mac = mac;
    }

    public Boolean getLinux() {
        return this.linux;
    }

    public void setLinux(Boolean linux) {
        this.linux = linux;
    }

    public Float getUpVotes() {
        return this.upvotes;
    }

    public void setUpVotes(float upvotes) {
        this.upvotes = upvotes;
    }

    public int getAvg_pt() {
        return this.avg_pt;
    }

    public void setAvg_pt(int avg_pt) {
        this.avg_pt = avg_pt;
    }

    public String getDevelopers() {
        return this.developers;
    }

    public void setDevelopers(String developers) {
        this.developers = developers;
    }

    public String[] getGenres() {
        return this.languages;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    // IMPRESSOES
    // ----------------------------------------------------------------------------------

    void imprimirPrice() {
        System.out.format(Locale.US, "%.2f ", this.price);
    }

    void imprimirLinguas() {

        System.out.print("[");

        if (languages.length == 1)
            System.out.print(languages[0].replaceAll("[\\[\\]']", "") + "] ");

        else {

            for (int i = 1; i < languages.length - 1; i++)
                System.out.print(languages[i] + ", ");

            System.out.print(languages[languages.length - 1] + "] ");
        }
    }

    void imprimirWebSite() {
        if (this.website.isEmpty()) {
            System.out.print("null ");
        } else {
            System.out.print(this.website + " ");
        }
    }

    void imprimirUpVotes() {
        System.out.print((int) Math.round(this.upvotes * 100) + "% ");
    }

    void imprimirAVG() {
        int horasContadas = this.avg_pt / 60, minutosPassados = this.avg_pt % 60;
        if (horasContadas == 0 && minutosPassados == 0)
            System.out.print("null ");

        else if (horasContadas > 0) {
            System.out.print(horasContadas + "h ");
        } else {
            System.out.print(horasContadas + "");

        }
        if (minutosPassados > 0) {
            System.out.print("m ");
        } else {
            System.out.print("");

        }
        // MyIO.print(((horasContadas > 0) ? horasContadas + "h " : "") +
        // ((minutosPassados > 0) ? minutosPassados + "m " : ""));
    }

    void imprimirGeneros() {

        System.out.print("[");

        if (genres.length == 1)
            System.out.print(genres[0].replace("\"", "") + "]\n");

        else {

            System.out.print(genres[0].replace("\"", "") + ", ");

            for (int i = 1; i < genres.length - 1; i++)
                System.out.print(genres[i] + ", ");

            System.out.print(genres[genres.length - 1].replace("\"", "") + "]\n");
        }
    }

    void imprimir() {

        System.out.printf("%d %s %s %s %d ", this.app_id, this.name, formataador.format(this.release_date), this.owners,
                this.age);
        imprimirPrice();
        System.out.print(this.dlcs + " ");
        imprimirLinguas();
        imprimirWebSite();
        System.out.printf("%b %b %b ", this.windows, this.mac, this.linux);
        imprimirUpVotes();
        imprimirAVG();
        System.out.print(this.developers.replace("\"", "") + " ");
        imprimirGeneros();
    }

    public Games clone(){
        Games temp = new Games();
        temp.app_id = this.app_id;
        temp.age = this.age;
        temp.avg_pt = this.avg_pt;
        temp.dlcs = this.dlcs;
        temp.release_date = this.release_date;
        temp.name = this.name;
        temp.owners = this.owners;
        temp.website = this.website;
        temp.developers = this.developers;
        temp.languages = this.languages;
        temp.genres = this.genres;
        temp.price = this.price;
        temp.upvotes = this.upvotes;
        temp.windows = this.windows;
        temp.mac = this.mac;
        temp.linux = this.linux;
        return temp;
    }
}