import java.util.*;
import java.io.*;
import java.io.RandomAccessFile; 

class TP01Q09 {

    public static void escrever() throws Exception {
      Scanner sc = new Scanner(System.in);
      sc.useLocale(Locale.US);
      RandomAccessFile file = new RandomAccessFile("file.txt", "rw");
      double x = 0;
      int n = sc.nextInt();
      for (int i = 0; i < n; i++) {
        x = sc.nextDouble();
        file.writeDouble(x);
      //  file.writeBytes(System.getProperty("line.separator"));
      }
      
      ler(file, n);
    }

    public static void ler (RandomAccessFile file, int n) throws Exception {
      double x = 0;
      int y = 0;
     for (int i = n; i > 0; i--) {
      file.seek((i - 1) * 8);
      x = file.readDouble();
      if (x == (long) x) {
      y = (int) x;
      System.out.println(y);
      }
      else {
      System.out.println(x);
     }
      
     }
    }


    public static void main (String[] args) throws Exception{

      escrever();
      
        }
    }