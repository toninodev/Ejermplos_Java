package daw.iesrodeira.com.common;

/**
 *
 * @author xavi
 */
class Provider {
    final String tin;
    String name;
    String email;
    String phone;
    String address;
    String description;

    public Provider(String tin, String name, String email, String phone) throws TINException {
        Validator v=new TinValidator();
        if (!v.isValid(tin)) throw new TINException("O Cif non e valido");
        
        //new Tin(tin);
        this.tin = tin;
        
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getTin() {
        return tin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
