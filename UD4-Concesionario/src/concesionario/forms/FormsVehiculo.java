package concesionario.forms;

import concesionario.Vehiculo;
import errors.CancelException;
import utilities.Data;
import utilities.Input;
import utilities.validators.MatriculaValidator;

public class FormsVehiculo {
    
    public static Vehiculo crearVehiculo() {
        try {
            System.out.println("Introduce los datos del nuevo veh�culo:");

            String marca = Input.getString("Marca: ");
            String modelo = Input.getString("Modelo: ");
            int precio = Input.getInteger("Precio: ", 500);  // Precio m�nimo de 500�

            Vehiculo nuevoVehiculo = new Vehiculo(marca, modelo, precio);

            boolean novo=Input.confirma("E un veh�culo novo?");
            if (!novo) {
                nuevoVehiculo.setDataMatriculacion(Input.getData("Data de Matriculaci�n:",new Data(1,1,1995),Data.today()));
                nuevoVehiculo.setMatricula(Input.getString("Matr�cula: ", null, new MatriculaValidator()));
                nuevoVehiculo.setKilometraxe(Input.getInteger("Kilometraje: ", 0));  // Kilometraje m�nimo de 0
            } 

            System.out.println("Veh�culo creado correctamente:\n" + nuevoVehiculo);
            return nuevoVehiculo;
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear el veh�culo: " + e.getMessage());
            return null;
        } catch (CancelException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void editarVehiculo(Vehiculo vehiculo) {
        try {
            System.out.println("Editando datos do veh�culo [" + vehiculo.getMatricula() + "] "+vehiculo.getMarca()+" "+vehiculo.getModelo()+":");
            System.out.println("Datos actuaiss:\n" + vehiculo);

            vehiculo.setPrezo(Input.getInteger("Novo Prezo: ", vehiculo.getPrezo(),500,null));  // Se mantiene el valor actual si el usuario no lo cambia

            System.out.println("Veh�culo editado correctamente:\n" + vehiculo);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al editar el veh�culo: " + e.getMessage());
        } catch (CancelException e) {
            System.out.println(e.getMessage());
        }
    }
 }
