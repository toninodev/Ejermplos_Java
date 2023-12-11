package database;

public class ArrayDB extends Database {
    private Record[] data;
    private int iterate;
    
    public ArrayDB(int capacity) {
        data=new Record[capacity];
        for(int idx=0;idx<capacity;idx++) data[idx]=new Record();
    }
    
    @Override
    public Object add(Object obj) throws DBException {
        int position=getInsertPosition(obj);
        if (position<0) throw new DBException(DbError.ERRINSERT,"Non queda espazo na base de datos para engadir "+obj);
        data[position].setData(obj);
        return obj;
    }
    
    @Override
    public Object delete(Object obj) throws DBException {
        int position=getPosition(obj);
        if (position<0) throw new DBException(DbError.NOTEXISTS,"Non se pudo eliminar "+obj);
        data[position].delete();
        return data[position].getData();
    }
    
    @Override
    public Object[] list() {
        // Necesitamos usar estruturas dinámicas de almacenamento que veremos no futuro
        throw new UnsupportedOperationException("Operación non soportada");
    }
    
    @Override
    public Object[] findAll(Filter f) throws DBException {
        // Necesitamos usar estruturas dinámicas de almacenamento que veremos no futuro
        throw new UnsupportedOperationException("Operación non soportada");

    }
    
    
    /**
     * 
     * Serve a implantación en Database, non necesito sobrepoñela
     * 
     * 
    @Override
    public Object find(Object search) throws DBException {
        // Usamos unha clase anónima porque é moi cómodo
        //
        return findOne(new Filter() {
            @Override
            public boolean isValid(Object obj) {
                return search.equals(obj);
            }
        });
    }*/
    
    @Override
    public Object findOne(Filter f) throws DBException {
        for (Record r : data) {
            Object info = r.getData();
            if (!r.isDeleted() && f.isValid(info)) {
                return info;
            }
        }
        return null;
    }
    
    public void startIteration() {
        iterate=0;
    }
    
    public Object next() {
        Object result=null;
        while (iterate < data.length && result==null) {
            if (!data[iterate].isDeleted()) result=data[iterate].getData();
            iterate++;
        }
        return result;
    }
    
    @Override
    public Object modify(Object obj) throws DBException {
        int idx=getPosition(obj);
        if (idx<0) throw new DBException(DbError.NOTEXISTS,"modificando "+obj);
        Record r=data[idx];
        r.setData(obj);
        return r;
    }
    
    private int getInsertPosition(Object obj) throws DBException {
        int ipos=-1;
        for(int idx=0;idx<data.length;idx++) {
            if (!data[idx].isDeleted() && data[idx].getData().equals(obj)) throw new DBException(DbError.DUPLICATE,"buscando posición de inserción");
            if (ipos<0 && data[idx].isDeleted()) ipos=idx;
        }
        return ipos;
    }
    
    private int getPosition(Object obj) throws DBException {
        int ipos=-1;
        for(int idx=0;idx<data.length && ipos<0;idx++) {
            if (!data[idx].isDeleted() && data[idx].getData().equals(obj)) ipos=idx;
        }
        return ipos;
    }
    
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
