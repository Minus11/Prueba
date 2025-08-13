import java.util.Scanner;

public class Main {

    private static void contactMenu(Scanner scanner) {
        LinkedList<DataTypeExamples.Contact> contacts = new LinkedList<>(LinkedList.ListType.SINGLY);
        while (true) {
            System.out.println("--- Gestión de contactos ---");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Mostrar contactos");
            System.out.println("0. Volver");
            int op = scanner.nextInt();
            scanner.nextLine();
            switch (op) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    contacts.insert(new DataTypeExamples.Contact(nombre, direccion, telefono));
                    break;
                case 2:
                    System.out.print("Nombre del contacto a eliminar: ");
                    String nombreDel = scanner.nextLine();
                    boolean eliminado = contacts.delete(new DataTypeExamples.Contact(nombreDel, "", ""));
                    System.out.println(eliminado ? "Eliminado" : "No encontrado");
                    break;
                case 3:
                    System.out.print("Nombre del contacto a buscar: ");
                    String nombreBusc = scanner.nextLine();
                    boolean encontrado = contacts.search(new DataTypeExamples.Contact(nombreBusc, "", ""));
                    System.out.println(encontrado ? "Encontrado" : "No encontrado");
                    break;
                case 4:
                    contacts.display();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> list = null;
        LinkedList.ListType type = null;
        while (true) {
            System.out.println("--- Menú Principal ---");
            System.out.println("1. Seleccionar tipo de lista");
            System.out.println("2. Insertar elemento");
            System.out.println("3. Eliminar elemento");
            System.out.println("4. Buscar elemento");
            System.out.println("5. Mostrar elementos");
            System.out.println("6. Ejemplos de tipos de datos");
            System.out.println("7. Gestión de contactos");
            System.out.println("0. Salir");
            int op = scanner.nextInt();
            scanner.nextLine();
            switch (op) {
                case 1:
                    System.out.println("Seleccione tipo de lista: 1) Simple 2) Doble 3) Circular");
                    int t = scanner.nextInt();
                    scanner.nextLine();
                    if (t == 1) type = LinkedList.ListType.SINGLY;
                    else if (t == 2) type = LinkedList.ListType.DOUBLY;
                    else if (t == 3) type = LinkedList.ListType.CIRCULAR;
                    else {
                        System.out.println("Opción inválida");
                        break;
                    }
                    list = new LinkedList<>(type);
                    break;
                case 2:
                    if (list == null) {
                        System.out.println("Primero seleccione el tipo de lista");
                        break;
                    }
                    System.out.print("Dato a insertar: ");
                    String data = scanner.nextLine();
                    list.insert(data);
                    break;
                case 3:
                    if (list == null) {
                        System.out.println("Primero seleccione el tipo de lista");
                        break;
                    }
                    System.out.print("Dato a eliminar: ");
                    String del = scanner.nextLine();
                    boolean eliminado = list.delete(del);
                    System.out.println(eliminado ? "Eliminado" : "No encontrado");
                    break;
                case 4:
                    if (list == null) {
                        System.out.println("Primero seleccione el tipo de lista");
                        break;
                    }
                    System.out.print("Dato a buscar: ");
                    String search = scanner.nextLine();
                    boolean found = list.search(search);
                    System.out.println(found ? "Encontrado" : "No encontrado");
                    break;
                case 5:
                    if (list == null) {
                        System.out.println("Primero seleccione el tipo de lista");
                        break;
                    }
                    list.display();
                    break;
                case 6:
                    DataTypeExamples.primitiveExample();
                    DataTypeExamples.complexExample();
                    DataTypeExamples.contactExample();
                    break;
                case 7:
                    contactMenu(scanner);
                    break;
                case 0:
                    System.out.println("Adiós");
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}
