public class DataTypeExamples {

    public static void primitiveExample() {
        LinkedList<Integer> list = new LinkedList<>(LinkedList.ListType.SINGLY);
        list.insert(10);
        list.insert(20);
        list.insert(30);
        System.out.println("Ejemplo con enteros:");
        list.display();
    }

    public static void complexExample() {
        LinkedList<String> list = new LinkedList<>(LinkedList.ListType.DOUBLY);
        list.insert("uno");
        list.insert("dos");
        list.insert("tres");
        System.out.println("Ejemplo con cadenas:");
        list.display();
    }

    public static void contactExample() {
        LinkedList<Contact> contacts = new LinkedList<>(LinkedList.ListType.SINGLY);
        contacts.insert(new Contact("Ana", "Calle 1", "111-111"));
        contacts.insert(new Contact("Luis", "Calle 2", "222-222"));
        System.out.println("Contactos de ejemplo:");
        contacts.display();
    }

    public static class Contact {
        private String nombre;
        private String direccion;
        private String telefono;

        public Contact(String nombre, String direccion, String telefono) {
            this.nombre = nombre;
            this.direccion = direccion;
            this.telefono = telefono;
        }

        public String getNombre() {
            return nombre;
        }

        @Override
        public String toString() {
            return nombre + " | " + direccion + " | " + telefono;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Contact contact = (Contact) o;
            return nombre.equals(contact.nombre);
        }

        @Override
        public int hashCode() {
            return nombre.hashCode();
        }
    }
}
