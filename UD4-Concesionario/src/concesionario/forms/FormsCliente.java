package concesionario.forms;

import concesionario.Cliente;
import errors.CancelException;
import utilities.Input;
import utilities.validators.EmailValidator;
import utilities.validators.TelefonoValidator;

/**
 *
 * @author xavi
 */
public class FormsCliente {

    public static Cliente crearCliente() {
        try {
            System.out.println("Introduce los datos del nuevo cliente:");

            String dni = Input.getString("DNI: ");
            String nombre = Input.getString("Nombre: ");
            String apellidos = Input.getString("Apellidos: ");

            Cliente nuevoCliente = new Cliente(dni, nombre, apellidos);

            nuevoCliente.setDireccion(Input.getString("Dirección: "));
            nuevoCliente.setTelefono(Input.getString("Teléfono: ", null, new TelefonoValidator()));
            nuevoCliente.setEmail(Input.getString("Email: ", null, new EmailValidator()));

            System.out.println("Cliente creado correctamente:\n" + nuevoCliente);
            return nuevoCliente;
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear el cliente: " + e.getMessage());
            return null;
        } catch (CancelException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void editarCliente(Cliente cliente) {
        if (cliente == null) {
            System.out.println("No se puede editar un cliente nulo");
            return;
        }

        try {
            System.out.println("Editando datos del cliente [" + cliente.getId() + "]:");
            System.out.println("Datos actuales:\n" + cliente);

            cliente.setDireccion(Input.getString("Nueva dirección: ",cliente.getDireccion()));
            cliente.setTelefono(Input.getString("Nuevo teléfono: ", cliente.getTelefono(), new TelefonoValidator()));
            cliente.setEmail(Input.getString("Nuevo email: ", cliente.getEmail(), new EmailValidator()));

            System.out.println("Cliente editado correctamente:\n" + cliente);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al editar el cliente: " + e.getMessage());
        } catch (CancelException e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
