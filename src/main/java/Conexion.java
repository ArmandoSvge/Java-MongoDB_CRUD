import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Conexion {
   private String url="";
    private  String database= "Pokemon";
    private MongoClient client;
    public MongoDatabase connect (String url, String nombreBD){
        //Hago conexion
        client = MongoClients.create(url);

        //Seleccionar Base de datos
        MongoDatabase database1 = client.getDatabase(database);
        return database1;
    }
    public void disconnect(){
        client.close();
}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public MongoClient getClient() {
        return client;
    }

    public void setClient(MongoClient client) {
        this.client = client;
    }
}
