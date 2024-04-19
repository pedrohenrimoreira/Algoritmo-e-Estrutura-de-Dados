public class array {
    public static void main(String[] args){
        int n = MyIO.readInt();
        for(int i=0;i<n;i++){
            int total=0;
            int m = MyIO.readInt();
            for(int j=0;j<m;j++){
                String str = MyIO.readLine();
                str = str.toUpperCase();
                for(int z=0;z<str.length();z++){
                    total+=(((int)(str.charAt(z)))-65)+j+z;
                }
            }
            System.out.println(total);
        }
    }
}
