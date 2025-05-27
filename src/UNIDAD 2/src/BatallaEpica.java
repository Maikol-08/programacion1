import java.util.Scanner;
import java.util.Random;
                        
// Clase base: Personaje
class Personaje {
    String nombre;
    int fuerza;
    int velocidad;
    int resistencia;
    int resistenciaMaxima;
    boolean transformado = false;

    public Personaje(String nombre, int fuerza, int velocidad, int resistencia) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.velocidad = velocidad;
        this.resistencia = resistencia;
        this.resistenciaMaxima = resistencia;
    }

    public void atacar(Personaje oponente) {
        System.out.println("💥 " + nombre + " ataca a " + oponente.nombre + " con fuerza de " + fuerza + " puntos!");
        oponente.resistencia -= fuerza;
        if (oponente.resistencia < 0) oponente.resistencia = 0;
        System.out.println("🔸 " + oponente.nombre + " queda con " + oponente.resistencia + " puntos de resistencia!");
    }

    public void mostrarEstadisticas() {
        System.out.println("\n🔰 --- Stats de " + nombre + " ---");
        System.out.println("💪 Fuerza: " + fuerza);
        System.out.println("⚡ Velocidad: " + velocidad);
        System.out.println("❤️ Resistencia: " + resistencia + "/" + resistenciaMaxima);
        if (transformado) {
            System.out.println("✨ ¡TRANSFORMADO!");
        }
        System.out.println("-------------------\n");
    }
}

// Clase Goku          
class Goku extends Personaje {
    private boolean puedeTransformarse = true;

    public Goku(String nombre, int fuerza, int velocidad, int resistencia) {
        super(nombre, fuerza, velocidad, resistencia);
    }

    public void kamehameha(Personaje oponente) {
        int damage = fuerza * 2;
        System.out.println("🌟 ¡¡¡KAAAAA-MEEEEE-HAAAAA-MEEEEE-HAAAAAA!!!");
        System.out.println("💥 ¡" + nombre + " lanza un Kamehameha con poder de " + damage + "!");
        oponente.resistencia -= damage;
        if (oponente.resistencia < 0) oponente.resistencia = 0;
        System.out.println("🔸 " + oponente.nombre + " queda con " + oponente.resistencia + " puntos de resistencia!");
    }

    public void transformacion() {
        if (!puedeTransformarse) {
            System.out.println("❌ ¡Ya estás transformado!");
            return;
        }
        System.out.println("⚡ ¡¡¡AAAAAAAAAAAAHHHHHHH!!!");
        System.out.println("✨ ¡" + nombre + " se transforma en Super Saiyajin!");
        fuerza *= 2;
        velocidad *= 2;
        transformado = true;
        puedeTransformarse = false;
    }

    public void usarSemilla() {
        if (resistencia == resistenciaMaxima) {
            System.out.println("❌ ¡Ya tienes la salud al máximo!");
            return;
        }
        System.out.println("🌱 ¡" + nombre + " usa una semilla del ermitaño!");
        resistencia = resistenciaMaxima;
        System.out.println("❤️ ¡Salud recuperada al máximo!");
    }
}

// Clase Thanos
class Thanos extends Personaje {
    private Random random = new Random();
    private boolean puedeUsarChasquido = true;

    public Thanos(String nombre, int fuerza, int velocidad, int resistencia) {
        super(nombre, fuerza, velocidad, resistencia);
    }

    public void poderGema(Personaje oponente) {
        int damage = fuerza * 3;
        System.out.println("💎 ¡" + nombre + " usa la Gema del Poder!");
        System.out.println("💥 ¡Ataque con poder de " + damage + "!");
        oponente.resistencia -= damage;
        if (oponente.resistencia < 0) oponente.resistencia = 0;
        System.out.println("🔸 " + oponente.nombre + " queda con " + oponente.resistencia + " puntos de resistencia!");
    }

    public void chasquido(Personaje oponente) {
        if (!puedeUsarChasquido) {
            System.out.println("❌ ¡Ya usaste el chasquido!");
            return;
        }
        System.out.println("🌟 ¡" + nombre + " usa el CHASQUIDO!");
        if (random.nextBoolean()) {
            System.out.println("💀 ¡El chasquido fue efectivo! ¡" + oponente.nombre + " se desvanece!");
            oponente.resistencia = 0;
        } else {
            System.out.println("😅 ¡" + oponente.nombre + " resistió el chasquido!");
        }
        puedeUsarChasquido = false;
    }

    public void usarGemaTiempo() {
        if (resistencia == resistenciaMaxima) {
            System.out.println("❌ ¡Ya tienes la salud al máximo!");
            return;
        }
        System.out.println("⌛ ¡" + nombre + " usa la Gema del Tiempo para recuperarse!");
        resistencia += 50;
        if (resistencia > resistenciaMaxima) resistencia = resistenciaMaxima;
        System.out.println("❤️ ¡Recuperó 50 puntos de resistencia!");
    }
}
 
// Clase principal
public class BatallaEpica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear personajes
        Goku goku = new Goku("Goku", 100, 90, 150);
        Thanos thanos = new Thanos("Thanos", 90, 80, 180);

        System.out.println("⚔️ ¡BATALLA ÉPICA: GOKU VS THANOS! ⚔️\n");

        // Mostrar stats iniciales
        goku.mostrarEstadisticas();
        thanos.mostrarEstadisticas();

        // Loop de batalla
        int opcion;
        do {
            System.out.println("🎮 Elige una acción:");
            System.out.println("1. 👊 Goku ataca normal");
            System.out.println("2. 🌟 Goku usa Kamehameha");
            System.out.println("3. ⚡ Goku se transforma");
            System.out.println("4. 👊 Thanos ataca normal");
            System.out.println("5. 💎 Thanos usa Gema del Poder");
            System.out.println("6. 🌟 Thanos intenta el Chasquido");
            System.out.println("7. 🌱 Goku usa semilla / ⌛ Thanos usa Gema del Tiempo");
            System.out.println("8. 📊 Ver estadísticas");
            System.out.println("9. 🚪 Terminar batalla");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    goku.atacar(thanos);
                    break;
                case 2:
                    goku.kamehameha(thanos);
                    break;
                case 3:
                    goku.transformacion();
                    break;
                case 4:
                    thanos.atacar(goku);
                    break;
                case 5:
                    thanos.poderGema(goku);
                    break;
                case 6:
                    thanos.chasquido(goku);
                    break;
                case 7:
                    System.out.println("¿Quién se recupera? (1: Goku, 2: Thanos)");
                    int quien = scanner.nextInt();
                    if (quien == 1) goku.usarSemilla();
                    else if (quien == 2) thanos.usarGemaTiempo();
                    break;
                case 8:
                    goku.mostrarEstadisticas();
                    thanos.mostrarEstadisticas();
                    break;
                case 9:
                    System.out.println("🏁 ¡La batalla ha terminado!");
                    break;
                default:
                    System.out.println("❌ Opción inválida.");
                    break;
            }

            // Verificar si alguien murió
            if (goku.resistencia == 0) {
                System.out.println("\n💀 ¡" + goku.nombre + " ha sido derrotado!");
                System.out.println("👑 ¡" + thanos.nombre + " es el ganador!");
                break;
            } else if (thanos.resistencia == 0) {
                System.out.println("\n💀 ¡" + thanos.nombre + " ha sido derrotado!");
                System.out.println("👑 ¡" + goku.nombre + " es el ganador!");
                break;
            }

        } while (opcion != 9);

        scanner.close();
    }
}