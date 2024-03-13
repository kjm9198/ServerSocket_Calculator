package ovh.devnote.dekoratorex;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketHandler {
    //private InputStream is;
    //private OutputStream os;

    private PrintWriter out;
    private Scanner in;
    private Socket socket;
    public SocketHandler(Socket socket) throws IOException {

        this.socket = socket;
        in = new Scanner(new BufferedInputStream(socket.getInputStream()));
        out = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()),true);
    }

    public PrintWriter getOut() {
        return out;
    }

    public Scanner getIn() {
        return in;
    }

    public Socket getSocket() {
        return socket;
    }
}
