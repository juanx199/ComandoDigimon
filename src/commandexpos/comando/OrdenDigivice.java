package commandexpos.comando;

// COMANDO (Command): Interfaz común para todas las órdenes.
// Define el contrato para ejecutar y deshacer acciones.
public interface OrdenDigivice {
    // Ejecuta la solicitud encapsulada.
    void ejecutar();

    // Revierte los cambios realizados por ejecutar().
    void deshacer();
}
