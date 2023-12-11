package concesionario;

import java.util.Objects;
import utilities.Data;
import utilities.validators.MatriculaValidator;

public class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int prezo;
    protected Data dataMatriculacion=null;  // Si a matr�cula � null debe ser null
    protected String matricula=null; // Si a matr�cula � null � un veh�culo novo
    protected int kilometraxe=0;

    public Vehiculo(String marca,String modelo,int prezo) {
        this.marca=marca;
        this.modelo=modelo;
        if (prezo<500) throw new IllegalArgumentException("Un veh�culo non pode ter un valor inferior a 500�");
        this.prezo=prezo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
    
    public int getPrezo() {
        return prezo;
    }
    
    public void setPrezo(int prezo) {
        if (prezo<500) throw new IllegalArgumentException("Un veh�culo non pode valer menos de 500�");
        this.prezo=prezo;
    }


    public Data getDataMatriculacion() {
        return dataMatriculacion;
    }

    
    public void setDataMatriculacion(Data data) {
        if (data.eDespois(Data.today())) throw new IllegalArgumentException("A data de matriculaci�n debe ser anterior a hoxe");
        this.dataMatriculacion=data;
    }

    public String getMatricula() {
        return matricula;
    }
    
    public void setMatricula(String matricula) {
        if (!new MatriculaValidator(matricula).isValid()) throw new IllegalArgumentException("A matricula "+matricula+" non � v�lida");
        this.matricula = matricula;
    }


    public int getKilometraxe() {
        return kilometraxe;
    }

    public void setKilometraxe(int kilometraxe) {
        if (kilometraxe<=0) throw new IllegalArgumentException("O kilometraxe debe ser > 0");
        this.kilometraxe = kilometraxe;
    }

    public boolean eNovo() {
        return matricula==null;
    }
    
    public boolean eKm0() {
        return (matricula!=null) && (kilometraxe<=1000);
    }
    
    public boolean eOcasion() {
        return (matricula!=null) && (kilometraxe>1000);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
       
        final Vehiculo other = (Vehiculo) obj;

        if (matricula!=null) return this.matricula.equals(other.matricula);

        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        String str=marca+" "+modelo+" ("+prezo+" �)";
        if (eNovo()) return str;
        else {
            str="["+matricula+"] "+str;
            if (eKm0()) str+=" ** KM0 **";
            else        str+=" ** Vehiculo de Ocasi�n **";
            str+=" ("+kilometraxe+"kms)";
        }
        return str;
    }
}
