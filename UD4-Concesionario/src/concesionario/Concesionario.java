package concesionario;

import concesionario.forms.FormsCliente;
import concesionario.forms.FormsVehiculo;
import database.DBException;
import database.Database;
import database.DinamicArrayDB;
import database.Filter;
import errors.CancelException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.Data;
import utilities.Input;
import utilities.validators.MatriculaValidator;

public class Concesionario {
    private static final Database databaseClientes = new DinamicArrayDB();
    private static final Database databaseVehiculos = new DinamicArrayDB();
    private static final Database databaseMatriculaciones = new DinamicArrayDB();
    private static Scanner scn=new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int opcion=0;
        do {
            try {
                System.out.println("Men� de Gesti�n del Concesionario");
                System.out.println("1. Gestionar Clientes");
                System.out.println("2. Gestionar Veh�culos");
                System.out.println("3. Gestionar Matriculaciones");
                System.out.println("4. Salir");
                
                System.out.print("Elixe Opci�n: ");
                opcion = Integer.parseInt(scn.nextLine());
                
                switch (opcion) {
                    case 1:
                        gestionarClientes();
                        break;
                    case 2:
                        gestionarVehiculos();
                        break;
                    case 3:
                        gestionarMatriculaciones();
                        break;
                    
                }
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            }
        } while (opcion != 4);
    }

    private static void gestionarClientes() {
        int opcion=0;
        do {
            try {
                System.out.println("\nMen� de Gesti�n de Clientes");
                System.out.println("1. Crear Cliente");
                System.out.println("2. Editar Cliente");
                System.out.println("3. Listar Clientes");
                System.out.println("4. Eliminar Cliente");
                System.out.println("5. Volver al Men� Principal");
                
                System.out.print("Elixe Opci�n: ");
                opcion = Integer.parseInt(scn.nextLine());
                
                switch (opcion) {
                    case 1:
                        Cliente nuevoCliente = FormsCliente.crearCliente();
                        if (nuevoCliente != null) {
                            try {
                                databaseClientes.add(nuevoCliente);
                                System.out.println("Cliente a�adido a la base de datos.");
                            } catch (DBException e) {
                                System.out.printf("Error al a�adir el cliente a la base de datos: " + e.getMessage()+"\n",nuevoCliente);
                            }
                        }
                        break;
                    case 2:
                        Cliente clienteEditar = seleccionarCliente();
                        if (clienteEditar != null) {
                            FormsCliente.editarCliente(clienteEditar);
                            try {
                                databaseClientes.modify(clienteEditar);
                                System.out.println("Cliente modificado en la base de datos.");
                            } catch (DBException e) {
                                System.out.printf("Error al modificar el cliente en la base de datos: " + e.getMessage()+"\n",clienteEditar);
                            }
                        }
                        break;
                    case 3:
                        listarClientes();
                        break;
                    case 4:
                         Cliente cl=buscaCliente();
                         if (cl==null) System.out.println("O cliente con non existe");
                         else {
                             if (Input.confirma("Seguro que queres borrar "+cl+"? ")) {
                                 databaseClientes.delete(cl);
                             } 
                         }
                         break;
                }
            } catch (CancelException | NumberFormatException ex) {
                System.out.println(ex.getMessage());
            } catch (DBException ex) {
                System.out.println(ex.getMessage()+" ("+ex.getReason()+")");
            }
        } while (opcion != 5);
    }

    private static void gestionarVehiculos() {
        int opcion=0;
        do {
            try {
                System.out.println("\nMen� de Gesti�n de Veh�culos");
                System.out.println("1. Crear Veh�culo");
                System.out.println("2. Editar Veh�culo");
                System.out.println("3. Listar Veh�culos");
                System.out.println("4. Eliminar Veh�culo");
                System.out.println("5. Volver al Men� Principal");
                
                System.out.print("Elixe Opci�n: ");
                opcion = Integer.parseInt(scn.nextLine());
                
                switch (opcion) {
                    case 1:
                        Vehiculo nuevoVehiculo = FormsVehiculo.crearVehiculo();
                        if (nuevoVehiculo != null) {
                            try {
                                databaseVehiculos.add(nuevoVehiculo);
                                System.out.println("Veh�culo a�adido a la base de datos.");
                            } catch (DBException e) {
                                System.out.printf("Error al a�adir el veh�culo a la base de datos: " + e.getMessage()+"\n",nuevoVehiculo);
                            }
                        }
                        break;
                    case 2:
                        Vehiculo vehiculoEditar = seleccionarVehiculo();
                        if (vehiculoEditar != null) {
                            FormsVehiculo.editarVehiculo(vehiculoEditar);
                            try {
                                databaseVehiculos.modify(vehiculoEditar);
                                System.out.println("Veh�culo modificado en la base de datos.");
                            } catch (DBException e) {
                                System.out.printf("Error al modificar el veh�culo en la base de datos: " + e.getMessage()+"\n",vehiculoEditar);
                            }
                        }
                        break;
                    case 3:
                        listarVehiculos();
                        break;
                    case 4:
                        Vehiculo v=seleccionarVehiculo();
                        if (Input.confirma("Estas seguro de eliminar "+v)) {
                            databaseVehiculos.delete(v);
                        }
                }
            } catch (CancelException | NumberFormatException ex) {
                System.out.println(ex.getMessage());
            } catch (DBException ex) {
                System.out.println(ex.getMessage()+" ("+ex.getReason()+")");            }
        } while (opcion != 5);
    }

    private static void gestionarMatriculaciones() {
        int opcion=0;
        do {
            try {
                System.out.println("\nMen� de Gesti�n de Matriculaciones");
                System.out.println("1. Matricular Veh�culo");
                System.out.println("2. Listar Matriculaciones");
                System.out.println("3. Volver al Men� Principal");
                
                System.out.print("Elixe Opci�n: ");
                opcion = Integer.parseInt(scn.nextLine());         
                
                switch (opcion) {
                    case 1:
                        
                        Cliente cliente=buscaCliente();
                        if (cliente==null) throw new IllegalArgumentException("O cliente non existe");
                        
                        System.out.println("O comprador �: "+cliente);
                        Vehiculo vehiculo = seleccionarVehiculo();
                        String matricula;
                        Data datamatriculacion;
                        
                        if (vehiculo != null) {
                            if (vehiculo.eNovo()) {
                                matricula=Input.getString("Matr�cula: ", null, new MatriculaValidator());
                                datamatriculacion=Input.getData("Data de Matriculaci�n:",Data.today(),Data.today(),null);
                            } else {
                                matricula=vehiculo.getMatricula();
                                datamatriculacion=vehiculo.getDataMatriculacion();
                            }
                            int prezoventa=Input.getInteger("Prezo de Venta: ",vehiculo.getPrezo());
                            VehiculoMatriculado vehiculoMatricular=new VehiculoMatriculado(vehiculo,datamatriculacion,matricula,cliente,prezoventa);
                            
                            try {
                                if (Input.confirma("Confirma a venta de "+vehiculo+" a "+cliente+" por "+prezoventa+"�")) {
                                    databaseMatriculaciones.add(vehiculoMatricular);
                                    databaseVehiculos.delete(vehiculo);
                                }
                                System.out.println("Veh�culo matriculado correctamente.");
                            } catch (DBException e) {
                                System.out.printf("Erro o matricular o veh�culo: " + e.getMessage()+"\n",vehiculo);
                            }
                        }
                        break;
                    case 2:
                        listarMatriculaciones();
                        break;
                }
            } catch (CancelException | NumberFormatException ex) {
                System.out.println(ex.getMessage());
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        } while (opcion != 3);
    }

    private static Cliente buscaCliente() throws CancelException {
        Cliente cl=null;
        try {
            String dni=Input.getString("Dni del cliente");
            cl=(Cliente)databaseClientes.findOne(new Filter() {
                @Override
                public boolean isValid(Object obj) {
                    return ((Cliente)obj).getId().equals(dni);
                }
            });
            return cl;
        } catch (DBException ex) {
            System.out.printf("Erro buscando cliente: " + ex.getMessage()+"\n",cl);
        }
        return null;
    }
    
    private static Cliente seleccionarCliente() throws CancelException {
        try {
            Object[] clientes = databaseClientes.list();
            if (clientes.length > 0) {
                System.out.println("Seleccione un cliente:");
                for (int i = 0; i < clientes.length; i++) {
                    System.out.println((i + 1) + ". " + clientes[i]);
                }
                int opcion = Input.getInteger("Ingrese el n�mero del cliente: ", 1, clientes.length);
                return (Cliente) clientes[opcion - 1];
                
            } else {
                System.out.println("No hay clientes disponibles en la base de datos.");
                return null;
            }
        } catch (DBException e) {
            System.out.println("Error al obtener la lista de clientes: " + e.getMessage());
        } 
        return null;
    }

    private static Vehiculo seleccionarVehiculo() throws CancelException {
        try {
            Object[] vehiculos = databaseVehiculos.list();
            if (vehiculos.length > 0) {
                System.out.println("Seleccione un veh�culo:");
                for (int i = 0; i < vehiculos.length; i++) {
                    System.out.println((i + 1) + ". " + vehiculos[i]);
                }
                int opcionVehiculo = Input.getInteger("Ingrese el n�mero del veh�culo: ", 1, vehiculos.length);
                return (Vehiculo) vehiculos[opcionVehiculo - 1];
            } else {
                System.out.println("No hay veh�culos disponibles en la base de datos.");
                return null;
            }
        } catch (DBException e) {
            System.out.println("Error al obtener la lista de veh�culos: " + e.getMessage());
        } 
        return null;
    }

    private static void listarClientes() {
        try {
            Object[] clientes = databaseClientes.list();
            if (clientes.length > 0) {
                System.out.println("Lista de Clientes:");
                for (Object cliente : clientes) {
                    System.out.println(cliente);
                }
            } else {
                System.out.println("No hay clientes disponibles en la base de datos.");
            }
        } catch (DBException e) {
            System.out.println("Error al obtener la lista de clientes: " + e.getMessage());
        }
    }

    private static void listarVehiculos() {
        try {
            Object[] vehiculos = databaseVehiculos.list();
            if (vehiculos.length > 0) {
                System.out.println("Lista de Veh�culos:");
                for (Object vehiculo : vehiculos) {
                    System.out.println(vehiculo);
                }
            } else {
                System.out.println("No hay veh�culos disponibles en la base de datos.");
            }
        } catch (DBException e) {
            System.out.println("Error al obtener la lista de veh�culos: " + e.getMessage());
        }
    }

    private static void listarMatriculaciones() {
        try {
            Object[] matriculaciones = databaseMatriculaciones.list();
            if (matriculaciones.length > 0) {
                System.out.println("Lista de Matriculaciones:");
                for (Object matriculacion : matriculaciones) {
                    System.out.println(matriculacion);
                }
            } else {
                System.out.println("No hay matriculaciones disponibles en la base de datos.");
            }
        } catch (DBException e) {
            System.out.println("Error al obtener la lista de matriculaciones: " + e.getMessage());
        }
    }
    
}
