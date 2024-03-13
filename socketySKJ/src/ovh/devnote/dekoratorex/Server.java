package ovh.devnote.dekoratorex;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;


public class Server {
    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8189);

        while (true) {
            Socket socket = serverSocket.accept();
            SocketHandler sh = new SocketHandler(socket);
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Otwieram : "+sh.getSocket());
                    if (sh.getIn().hasNextLine()) {
                        String line = sh.getIn().nextLine();
                        if (line.equals("s00001")) {
                            int r1 = ThreadLocalRandom.current().nextInt(101, 1000 + 1);
                            int r2 = ThreadLocalRandom.current().nextInt(20, 100 + 1);
                            sh.getOut().println("Twoj nr To: " + line);
                            sh.getOut().println("Policz nwd liczb:");

                            sh.getOut().println(r1 + " " + r2);

                            int nwd = nwd(r1, r2);
                            System.out.println(nwd);
                            if (sh.getIn().hasNextLine()) {
                                line = sh.getIn().nextLine();


                                System.out.println(nwd);
                                if (Integer.parseInt(line) == nwd) {
                                    sh.getOut().println("GOOD");
                                } else {
                                    sh.getOut().println("WRONG");
                                }
                            } else
                                line = "-1";
                        } else {
                            sh.getOut().println("Bledne dane!!");

                        }


                    }
                    try {
                        System.out.println("Zamykam :"+sh.getSocket());
                        sh.getSocket().close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });
        }

    }

    public static int nwd(int a, int b) {
        if (a % b == 0)
            return b;
        else {
            int t = a;
            a = b;
            b = t % b;
            return nwd(a, b);
        }

    }

}
