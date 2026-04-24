package commandexpos.comando;

import commandexpos.receptor.Digimon;

// COMANDO CONCRETO (ConcreteCommand): Encapsula la orden de evolución.
//Almacena el estado previo del receptor para permitir la involución (Undo).
public class OrdenEvolucionar implements OrdenDigivice {
    private Digimon digimon;
    // Parámetros previos para deshacer
    private String etapaAnterior;
    private String nombreAnterior;
    // Parámetros nuevos para ejecutar
    private String nuevaEtapa;
    private String nuevoNombre;

    public OrdenEvolucionar(Digimon digimon, String nuevaEtapa, String nuevoNombre) {
        this.digimon = digimon;
        this.nuevaEtapa = nuevaEtapa;
        this.nuevoNombre = nuevoNombre;
    }
    @Override
    public void ejecutar() {
        // Guardamos el estado actual antes de cambiarlo
        this.etapaAnterior = digimon.getEtapa();
        this.nombreAnterior = digimon.getNombre();
        digimon.evolucionar(nuevaEtapa, nuevoNombre);
    }
    @Override
    public void deshacer() {
        // Restauramos el receptor a su estado anterior almacenado
        digimon.involucionar(etapaAnterior, nombreAnterior);
    }
}
