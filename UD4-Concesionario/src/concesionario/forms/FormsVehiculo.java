package concesionario.forms;

import concesionario.Vehiculo;
import errors.CancelException;
import utilities.Data;
import utilities.Input;
import utilities.validators.MatriculaValidator;

public class FormsVehiculo {
    
    public static Vehiculo crearVehiculo() {
        try {
            System.out.println("Introduce los datos del nuevo vehículo:");

            String marca = Input.getString("Marca: ");
            String modelo = Input.getString("Modelo: ");
            int precio = Input.getInteger("Precio: ", 500);  // Precio mínimo de 500€

            Vehiculo nuevoVehiculo = new Vehiculo(marca, modelo, precio);

            boolean novo=Input.confirma("E un vehículo novo?");
            if (!novo) {
                nuevoVehiculo.setDataMatriculacion(Input.getData("Data de Matriculación:",new Data(1,1,1995),Data.today()));
                nuevoVehiculo.setMatricula(Input.getString("Matrícula: ", null, new MatriculaValidator()));
                nuevoVehiculo.setKilometraxe(Input.getInteger("Kilometraje: ", 0));  // Kilometraje mínimo de 0
            } 

            System.out.println("Vehículo creado correctamente:\n" + nuevoVehiculo);
            return nuevoVehiculo;
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear el vehículo: " + e.getMessage());
            return null;
        } catch (CancelException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void editarVehiculo(Vehiculo vehiculo) {
        try {
            System.out.println("Editando datos do vehículo [" + vehiculo.getMatricula() + "] "+vehiculo.getMarca()+" "+vehiculo.getModelo()+":");
            System.out.println("Datos actuaiss:\n" + vehiculo);

            vehiculo.setPrezo(Input.getInteger("Novo Prezo: ", vehiculo.getPrezo(),500,null));  // Se mantiene el valor actual si el usuario no lo cambia

            System.out.println("Vehículo editado correctamente:\n" + vehiculo);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al editar el vehículo: " + e.getMessage());
        } catch (CancelException e) {
            System.out.println(e.getMessage());
        }
    }
 }
