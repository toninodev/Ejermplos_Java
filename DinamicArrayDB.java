package database;

import utilities.DinamicArray;


public class DinamicArrayDB extends Database {
    private final DinamicArray data;
    
    public DinamicArrayDB() {
        data=new DinamicArray();
    }
    
    @Override
    public Object add(Object obj) throws DBException {
        if (find(obj)!=null) throw new DBException(DbError.DUPLICATE,"Engadindo rexistro (add)");
        data.add(obj);
        return obj;
    }
    
    @Override
    public Object delete(Object obj) throws DBException {
        Object todelete;
        if (data.length() > 0) {
            data.startIteration();
            do {
                todelete=data.next();
                if (todelete.equals(obj)) {
                    data.remove();
                    return todelete;
                }
            } while(data.hasNext());
        }
        throw new DBException(DbError.NOTEXISTS,"Non se pudo eliminar "+obj);
    }
    
    @Override
    public Object[] list() {
        return data.toArray();
    }
    
    @Override
    public Object[] findAll(Filter f) throws DBException {
        DinamicArray result=new DinamicArray();
        Object info;
        if (data.length() > 0) {
            data.startIteration();
            do {
                info=data.next();
                if (f.isValid(info)) result.add(info);
            } while(data.hasNext());
        }
        return result.toArray();
    }
    
    /*
    Non é necesario sobrepoñela xa que serve a versión da clase pai
        
    @Override
    public Object find(Object obj) throws DBExceptin {

    }
    */
    
    @Override
    public Object findOne(Filter f) throws DBException {
        if (data.length() > 0) {
            Object info;
            data.startIteration();
            do {
                info=data.next();
                if (f.isValid(info)) return info;
            } while(data.hasNext());
        }
        return null;
    }
    
    @Override
    public void startIteration() {
        data.startIteration();
    }
    
    @Override
    public Object next() {
        return data.next();
    }
    
    @Override
    public Object modify(Object obj) throws DBException {
        if (data.length() > 0) {
            data.startIteration();
             do {
                if (data.next().equals(obj)) {
                    return data.put(obj);
                }
            } while(data.hasNext()); 
        }
        throw new DBException(DbError.NOTEXISTS,"Non se pudo modificar "+obj);
    }

    /**
     * TEST da clase
     * 
     * 
     * @param args
     * @throws database.DBException
     */
    public static void main(String[] args) throws DBException {
        ArrayDB adb=new ArrayDB(100);

        Object obj;
        try {
            
            adb.add("Prueba");
            adb.add(1500);
            adb.add("Exemplo....");
            adb.add(198.567);
            
            // Exemplo de visualización de todos os obxectos na base de datos

            adb.startIteration();
            while((obj=adb.next())!=null) System.out.println(obj);
            
            adb.delete(1500);
            
            System.out.println("FIND: "+adb.find("Exemplo...."));
     
            // Outro modo
            adb.startIteration();
            obj=adb.next();
            while(obj!=null) {
                System.out.println(obj);
                obj=adb.next();
            }
            
            adb.add("Prueba");
        } catch (DBException ex) {
            System.out.println("Error: "+String.format(ex.getMessage(),"'elemento'")+" --> "+ex.getReason());
            adb.delete("Esto lanza unha Exception que non se captura");
        }
    }
    
}
