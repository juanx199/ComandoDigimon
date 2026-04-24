package commandexpos;

import commandexpos.receptor.Digimon;
import commandexpos.comando.OrdenDigivice;
import commandexpos.comando.OrdenAtacar;
import commandexpos.comando.OrdenEvolucionar;
import commandexpos.invocador.Digivice;

/**
 * CLIENTE (Client): Orquesta la creación y configuración de los objetos.
 * Es responsable de instanciar el receptor, los comandos y el invocador.
 */
public class Cliente {

    public static void main(String[] args) {
        System.out.println("==== INICIO DE LA AVENTURA ====\n");

        // 1. Crear el Receptor (Receiver): Contiene la lógica real
        Digimon miDigimon = new Digimon("Agumon", "Principiante");

        // 2. Crear los Comandos (ConcreteCommands): Encapsulan las peticiones
        OrdenDigivice ordenAtaque = new OrdenAtacar(miDigimon);
        OrdenDigivice ordenEvolucion = new OrdenEvolucionar(miDigimon, "Campeón", "Greymon");

        // 3. Crear el Invocador (Invoker): El control remoto (Digivice)
        Digivice digivice = new Digivice();

        // 4. Interacción: El Cliente asocia comandos al Invocador
        System.out.println("El personaje configura la orden de Ataque en el Digivice:");
        digivice.setComando(ordenAtaque); // Configuración
        digivice.ejecutarOrden();         // Ejecución

        System.out.println("\nEl personaje configura la orden de Evolución:");
        digivice.setComando(ordenEvolucion);
        digivice.ejecutarOrden();

        System.out.println("\nEl Digimon evolucionado ataca:");
        OrdenDigivice ordenAtaqueFuerte = new OrdenAtacar(miDigimon);
        digivice.setComando(ordenAtaqueFuerte);
        digivice.ejecutarOrden();

        // 5. Demostración de Undo (Deshacer)
        System.out.println("\n¡Oh no! El personaje se equivocó, quiere cancelar:");
        digivice.presionarBotonCancelar(); // Cancela el ataque fuerte
        digivice.presionarBotonCancelar(); // Cancela la evolución

        System.out.println("\nEstado final del Digimon: " + miDigimon.getNombre() + " (" + miDigimon.getEtapa() + ")");
    }
}
