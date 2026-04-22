package commandexpos.invocador;

import java.util.Stack;
import commandexpos.comando.OrdenDigivice;

//INVOCADOR (Invoker): Inicia las solicitudes.
//Guarda una referencia al comando y gestiona el historial de acciones.
public class Digivice {
    // Referencia al comando actual (como en el diagrama de Refactoring Guru)
    private OrdenDigivice comando;
    // Pila para permitir la funcionalidad de deshacer (Undo)
    private Stack<OrdenDigivice> historialComandos = new Stack<>();

    // Configura el comando que se va a ejecutar (Setter).
    public void setComando(OrdenDigivice comando) {
        this.comando = comando;
    }

    // Ejecuta el comando configurado y lo guarda en el historial.
    public void ejecutarOrden() {
        if (comando != null) {
            comando.ejecutar();
            historialComandos.push(comando);
        } else {
            System.out.println("Digivice: No hay ninguna orden configurada.");
        }
    }

    // Revierte la última acción ejecutada usando el historial LIFO.
    public void presionarBotonCancelar() {
        if (!historialComandos.isEmpty()) {
            OrdenDigivice ultimaOrden = historialComandos.pop();
            System.out.println("--- Digivice: Cancelando última orden ---");
            ultimaOrden.deshacer();
        } else {
            System.out.println("Digivice: No hay acciones para cancelar.");
        }
    }
}
