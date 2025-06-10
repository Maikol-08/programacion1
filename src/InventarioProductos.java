public class InventarioProductos {

    public static int contarProductosAgotados(int[][] matriz) {
        int contador = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 0) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public static double promedioInventarioBajo(int[][] matriz) {
        int suma = 0, contador = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < 20) {
                    suma += matriz[i][j];
                    contador++;
                }
            }
        }
        return contador > 0 ? (double) suma / contador : 0;
    }

    
    public static void imprimirInventarioCritico(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] <= 5) {
                    System.out.println("Inventario crítico en [" + i + "][" + j + "]: " + matriz[i][j] + " unidades");
                }
            }
        }
    }


    public static int[] posicionMayorInventario(int[][] matriz) {
        int maxCantidad = Integer.MIN_VALUE;
        int[] posicion = new int[2];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > maxCantidad) {
                    maxCantidad = matriz[i][j];
                    posicion[0] = i;
                    posicion[1] = j;
                }
            }
        }
        return posicion;
    }

    public static int totalInventario(int[][] matriz) {
        int total = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                total += matriz[i][j];
            }
        }
        return total;
    }
    public static void main(String[] args) {
        int[][] inventario = {
            {10, 0, 25, 5, 50},
            {3, 20, 0, 100, 18},
            {15, 5, 70, 40, 6},
            {0, 30, 90, 2, 80}
        };

        System.out.println("Productos agotados: " + contarProductosAgotados(inventario));
        System.out.println("Promedio de inventario bajo (<20 unidades): " + promedioInventarioBajo(inventario));
        imprimirInventarioCritico(inventario);
        int[] mayorInventario = posicionMayorInventario(inventario);
        System.out.println("Producto con mayor inventario en posición: [" + mayorInventario[0] + "][" + mayorInventario[1] + "]");
        System.out.println("Total de inventario: " + totalInventario(inventario));
    }
}