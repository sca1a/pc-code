import java.io.*;
import java.util.*;

public class MatrixGame {
    public static void main(String[] args) {
        new MatrixGame().run();
    }

    class $R {
        InputStream in; byte b; byte[] buf; int bi, bz;
        $R(InputStream I) { in=I; buf=new byte[65536]; bi=bz=0; read(); }
        void skip() { while (b >= 0 && b <= 32) read(); }
        void read() {
            if (bi==bz) {
                bi=0; try { bz=in.read(buf); } catch(Exception e) { bz=-1; } }
            b = bz == -1 ? -1 : buf[bi++];  }
        int nextInt() {
            int i=0; boolean s=false; skip();
            if (b == '-') { s=true; read(); }
            for (; b > 32; read()) i = i*10 + b-48; return s ? -i : i; }
    }
    class $W extends PrintWriter {
        $W() { super(new BufferedOutputStream(System.out)); }
    }

    void run() {
        $R $r = new $R(System.in);
        $W $w = new $W();

        int T = $r.nextInt();

        for (int ncase = 1; ncase <= T; ncase++) {
            int m = $r.nextInt();
            int n = $r.nextInt();

            int nim = 0;
            for (int i = 0; i < m; i++) {
                int row = 0;
                for (int j = 0; j < n; j++)
                    row += $r.nextInt();

                nim ^= row;
            }

            $w.println("Case " + ncase + ": "
                       + (nim == 0 ? "Bob" : "Alice"));
        }

        $w.close();
    }
}
