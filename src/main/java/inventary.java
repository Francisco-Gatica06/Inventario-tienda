import java.util.Scanner;

public class inventary {
    public static void main(String[] args) {
        Object[][] productos = new Object[10][3];
        ejecutarMenu(productos);
    }

    public static void ejecutarMenu(Object productos[][]){
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion, productos);
        } while (opcion != 5);
    }

    public static void mostrarMenu() {
        System.out.println("\nMenú inventario de productos:");
        System.out.println("1. Agreagar producto");
        System.out.println("2. Restar producto");
        System.out.println("3. Consultar disponibilidad");
        System.out.println("4. Listar productos");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static int leerOpcion() {
        int opcion = 0;
        while (true) {
            Scanner scanner = crearScanner();
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= 5) {
                    break;
                } else {
                    System.out.print("Opción inválida. Intente nuevamente: ");
                }
            } else {
                System.out.print("Entrada no válida. Ingrese un número: ");
                scanner.next();
            }
        }
        return opcion;
    }

    public static String leerCadena(String mensaje) {
        Scanner scanner = crearScanner();
        System.out.print(mensaje);
        String cadena = scanner.nextLine();
        return cadena;
    }

    public static Integer leerEntero(String mensaje) {
        Scanner scanner = crearScanner();
        System.out.print(mensaje);
        String entrada = scanner.nextLine();
        Integer entero = Integer.parseInt(entrada);
        return entero;
    }

    public static Scanner crearScanner() {
        return new Scanner(System.in);
    }

    public static void ejecutarOpcion(int opcion, Object[][] productos) {
        switch (opcion) {
            case 1:
                agregarProductoMenu(productos);
                break;
            case 2:
                restarProductosMenu(productos);
                break;
            case 3:
                break;
            case 4:
                listarProductos(productos);
                break;
            case 5:
                System.out.println("Saliendo del sistema. ¡Hasta luego!");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public static Object[][] agregarProductos(String nombre, int idProducto, int cantidad, Object productos[][]) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i][0] == null) {
                productos[i][0] = idProducto;
                productos[i][1] = cantidad;
                productos[i][2] = nombre;
                break;
            }
        }
        return productos;
    }

    public static void agregarProductoMenu(Object[][] productos) {
        String nombre = leerCadena("Ingrese el nombre del producto: ");
        int idProducto = leerEntero("Ingrese el id del producto: ");
        int cantidad = leerEntero("Ingrese la cantidad del producto: ");

        productos = agregarProductos(nombre,idProducto, cantidad, productos);
        System.out.println("Producto agregado exitosamente.");
    }

    public static boolean restarProductos(int idProducto, int cantidadARestar, Object[][] productos) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i][0] != null && productos[i][0].equals(idProducto) && ) {
                productos[i][1] = productos[i][1] - cantidadARestar;
            }
        }
    }

    public static void restarProductosMenu(Object[][] productos) {
        int id = leerEntero("Ingrese el id del producto: ");
        int cantidadARestar = leerEntero("Ingrese la cantidad de producto que quiere quitar: ");

        if (restarProductos(id, cantidadARestar, productos)) {
            System.out.println("Producto agregado exitosamente.");
        } else {
            System.out.println("Producto no existe.");
        }


    }

//    public static int consultarDisponibiliad(int idProducto) {}

    public static void listarProductos(Object[][] productos) {
        for (int i = 0; i < totalProductos(productos); i++) {
            for (int j = 0; j < productos[i].length; j++) {
                System.out.print(productos[i][j] + " ");
            }
        }
    }

    public static int totalProductos(Object[][] productos) {
        int total = 0;
        for (int i = 0; i < productos.length; i++) {
            if (productos[i][0] != null) {
                total ++;
            }
        }
        return total;
    }




}
