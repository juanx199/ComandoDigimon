package commandexpos.receptor;


//RECEPTOR (Receiver): Contiene la lógica de negocio real.
// Representa al Digimon que realiza las acciones solicitadas por los comandos.
public class Digimon {
    private String nombre;
    private String etapa;

    public Digimon(String nombre, String etapa) {
        this.nombre = nombre;
        this.etapa = etapa;
    }
    // Realiza la acción de ataque. 
    public void atacar() {
        System.out.println(this.nombre + " (Etapa: " + this.etapa + ") usa su ataque especial!");
    }
    // Cambia el estado del Digimon a una nueva forma. 
    public void evolucionar(String nuevaEtapa, String nuevoNombre) {
        System.out.println(this.nombre + " digievoluciona en... " + nuevoNombre + "!");
        this.nombre = nuevoNombre;
        this.etapa = nuevaEtapa;
    }
    // Restaura el estado previo del Digimon (utilizado para deshacer). 
    public void involucionar(String etapaAnterior, String nombreAnterior) {
        System.out.println(this.nombre + " pierde energía y vuelve a ser... " + nombreAnterior + ".");
        this.nombre = nombreAnterior;
        this.etapa = etapaAnterior;
    }
    // Getters para consultar el estado actual
    public String getNombre() { return nombre; }
    public String getEtapa() { return etapa; }
}
