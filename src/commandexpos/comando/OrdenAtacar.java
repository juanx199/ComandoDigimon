package commandexpos.comando;

import commandexpos.receptor.Digimon;

//COMANDO CONCRETO (ConcreteCommand): Encapsula la orden de ataque.
// Vincula la solicitud con el método atacar() del receptor (Digimon).
public class OrdenAtacar implements OrdenDigivice {
    private Digimon digimon;

    public OrdenAtacar(Digimon digimon) {
        this.digimon = digimon;
    }

    @Override
    public void ejecutar() {
        digimon.atacar(); // Delega la ejecución al receptor
    }

    @Override
    public void deshacer() {
        // Un ataque físico no siempre es reversible en este contexto.
        System.out.println("El ataque ya fue lanzado, ¡no se puede deshacer!");
    }
}
