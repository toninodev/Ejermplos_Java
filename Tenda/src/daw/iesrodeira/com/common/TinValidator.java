/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.iesrodeira.com.common;

/**
 *
 * @author xavi
 */
public class TinValidator extends Validator {
    @Override
    public boolean isValid(Object obj) {
        String tin=(String)obj;
        try {
            Tin v=new Tin(tin);
            return true;
        } catch(TINException e) {
            return false;
        }
    }
}
