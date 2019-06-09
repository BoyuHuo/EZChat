import service.testTcpServer;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;


public class Main {
    public static void main(String[] args) throws IOException {
        new testTcpServer();
        
    }


}
