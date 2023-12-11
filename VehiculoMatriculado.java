package concesionario;

import utilities.Data;
import utilities.validators.MatriculaValidator;


public class VehiculoMatriculado extends Vehiculo {
    private final Cliente propietario;
    private final int prezoventa;

    public VehiculoMatriculado(Vehiculo v,Data datamatricula,String matricula,Cliente propietario,int prezoventa) {
        super(v.marca,v.modelo,v.prezo);
        if (prezoventa<500) throw new IllegalArgumentException("Non se pode vender un vehículo por menos de 500€");
        
        if (v.eNovo()) {
            if (datamatricula.eAntes(Data.today())) throw new IllegalArgumentException("A data de matriculación debe ser posterior ou iguala hoxe");
        } else { 
            if (datamatricula.eDespois(Data.today())) throw new IllegalArgumentException("A data de matriculación debe ser anterior ou igual a hoxe");
        }
        if (!new MatriculaValidator(matricula).isValid()) throw new IllegalArgumentException("A matricula "+matricula+" non é válida");

        this.kilometraxe=v.kilometraxe;
        this.dataMatriculacion=datamatricula;
        this.matricula=matricula;
        this.propietario=propietario;
        this.prezoventa=prezoventa;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public int getPrezoventa() {
        return this.prezoventa;
    }
    
    @Override
    public String toString() {
        return super.toString()+" comprado por "+propietario;
    }
}
