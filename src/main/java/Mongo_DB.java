import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Mongo_DB {
    public static void main(String[] args) {
        try {
            String url = "";
            String database = "Pokemon";
            Scanner scanner = new Scanner(System.in);
            Conexion conexion = new Conexion();
            MongoClient mongoClient = MongoClients.create(url);
            MongoDatabase db = conexion.connect(url, database);
            Metodos metodos = new Metodos();
            int opcion;

            do {
                try {
                    System.out.println("\nMenú:");
                    System.out.println("1. Listar Pokemon en la colección");
                    System.out.println("2. Buscar  Pokemon por valor");
                    System.out.println("3. Eliminar  Pokemon por valor");
                    System.out.println("4. Insertar nuevo  Pokemon");
                    System.out.println("5. Actualizar  Pokemon");
                    System.out.println("6. Eliminar  varios Pokemon por valor");
                    System.out.println("7. Contabilizar Pokemon");
                    System.out.println("0. Salir");
                    System.out.print("Selecciona una opción: ");

                    opcion = scanner.nextInt();
                } catch (InputMismatchException e) {

                    System.out.println("Error: Ingresa un número entero.");
                    scanner.nextLine();
                    opcion = -1;
                }

                switch (opcion) {
                    case 1:
                        metodos.listarCollection(db, "Pokemon");
                        break;
                    case 2:
                        System.out.print("Ingrese la clave a buscar: ");
                        String claveBusqueda = scanner.next();
                        System.out.print("Ingrese el valor a buscar: ");
                        String valorBusqueda = scanner.next();
                        metodos.buscar(db, "Pokemon", claveBusqueda, valorBusqueda);
                        break;
                    case 3:
                        System.out.print("Ingrese la clave del  Pokemon a eliminar: ");
                        String claveEliminar = scanner.next();
                        System.out.print("Ingrese el valor del  Pokemon a eliminar: ");
                        String valorEliminar = scanner.next();
                        metodos.eliminar(db, "Pokemon", claveEliminar, valorEliminar);
                        break;
                    case 4:
                        System.out.print("Ingrese el nuevo valor  del   Pokemon: ");
                        String valorInsertar = scanner.next();
                        metodos.insertar(db, "Pokemon", valorInsertar);
                        break;
                    case 5:
                        System.out.print("Ingrese la clave del Pokemon a actualizar: ");
                        String claveActualizar = scanner.next();
                        System.out.print("Ingrese el valor actual del Pokemon a actualizar: ");
                        String valorActual = scanner.next();
                        System.out.print("Ingrese el nuevo valor del Pokemon: ");
                        String valorNuevo = scanner.next();
                        metodos.actualizar(db, "Pokemon", claveActualizar, valorActual, valorNuevo);
                        break;
                    case 6:
                        System.out.print("Ingrese la clave de los Pokemon a eliminar: ");
                        String claveEliminar1 = scanner.next();
                        System.out.print("Ingrese el valor de los Pokemon a eliminar: ");
                        String valorEliminar1 = scanner.next();
                        metodos.eliminar(db, "Pokemon", claveEliminar1, valorEliminar1);
                        break;
                    case 7:
                        metodos.contarTodos(db, "Pokemon");
                        break;
                    case 0:
                        // Salir
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (opcion != 0);

            mongoClient.close();
        } catch (Exception e) {
            // Manejar la excepción de manera apropiada
            e.printStackTrace();
        }
    }
}
