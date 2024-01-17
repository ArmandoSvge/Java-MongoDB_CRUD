import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Metodos {
    public MongoCollection <Document> listarCollection (MongoDatabase db, String nombre){
        MongoCollection<Document> Collection = db.getCollection(nombre);
        Document doc = Collection.find().first();
        System.out.println(doc.toJson());
        return  Collection;
    }
    public void buscar(MongoDatabase db, String collection, String key, String value) {


        MongoCollection<Document> Collection = db.getCollection(collection);
        Document findDocument = new Document(key, value);
        MongoCursor<Document> resultDocument = Collection.find(findDocument).iterator();

        System.out.println("Listado de todos los resultados:");

        while (resultDocument.hasNext()) {
            Document pokemonDoc = resultDocument.next();
            System.out.println(pokemonDoc.toJson());
        }


    }
    public void eliminar(MongoDatabase db, String collection, String key, String value) {
        MongoCollection<Document> Collection = db.getCollection(collection);
        Document deleteDocument = new Document(key, value);
        Collection.deleteOne(deleteDocument);
        System.out.println("Registro eliminado correctamente.");
    }

    public void eliminarVarios(MongoDatabase db, String collection, String key, String value) {
        MongoCollection<Document> Collection = db.getCollection(collection);
        Document deleteDocument = new Document(key, value);
        Collection.deleteMany(deleteDocument);
        System.out.println("Registros eliminados correctamente.");
    }

    public void insertar(MongoDatabase db, String collection, String name) {
        MongoCollection<Document> Collection = db.getCollection(collection);
        Document insertDocument = new Document("name", name);
        Collection.insertOne(insertDocument);
        System.out.println("Registro insertado correctamente.");
    }

    public void actualizar(MongoDatabase db, String collection, String key, String oldValue, String newValue) {
        MongoCollection<Document> Collection = db.getCollection(collection);
        Document filterDocument = new Document(key, oldValue);
        Document updateDocument = new Document("$set", new Document(key, newValue));
        Collection.updateOne(filterDocument, updateDocument);
        System.out.println("Registro actualizado correctamente.");
    }

    public void contarTodos(MongoDatabase db, String collection) {
        MongoCollection<Document> Collection = db.getCollection(collection);
        int contador=0;
        MongoCursor<Document> resultDocument = Collection.find().iterator();

        System.out.println("Listado de todos los resultados:");

        while (resultDocument.hasNext()) {
            Document pokemonDoc = resultDocument.next();
            System.out.println(pokemonDoc.get("name"));
            contador++;
        }
        System.out.println("En total hay "+contador);

    }
}
