/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author xavi
 */
public class Record {
    boolean isvalid=false;
    Object data=null;
    
    
    boolean isDeleted() {
        return !isvalid;
    }
    
    void delete() {
        isvalid=false;
    }
    
    Object getData() {
        return data;
    }
    
    void setData(Object obj) {
        this.data=obj;
        isvalid=true;
    }
}
