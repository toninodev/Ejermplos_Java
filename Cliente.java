package concesionario;

import java.util.Objects;
import utilities.Validator;
import utilities.validators.DNIValidator;
import utilities.validators.EmailValidator;
import utilities.validators.TelefonoValidator;


public class Cliente {
    private final String id;
    private String nome;
    private String apelidos;
    private String direccion;
    private String telefono;
    private String email;
    
    public Cliente(String dni,String nome,String apelidos) throws IllegalArgumentException {
        DNIValidator v=new DNIValidator(dni);
        if (!v.isValid()) throw new IllegalArgumentException(v.getMessage());
        if (nome==null || nome.length()==0) throw new IllegalArgumentException("Todos os ciudadanos deben ter un nome");
        this.id=dni;
        this.nome=nome;
        this.apelidos=apelidos;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getApelidos() {
        return apelidos;
    }
    

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        Validator v=new TelefonoValidator(telefono);
        if (!v.isValid()) throw new IllegalArgumentException(v.getMessage());
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Validator v=new EmailValidator(email);
        if (!v.isValid()) throw new IllegalArgumentException(v.getMessage());
        this.email = email;
    }
    
    
    @Override
    public String toString() {
        return "["+id+"] "+apelidos+", "+nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
}
