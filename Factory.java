/**
 * @author Gladys de la Roca, Jackeline Hidalgo
 * Clase Factory
 * Clase que crea objeto segun sea requerido
 * @version 29/08/2016
 */

import java.util.*;

public class Factory<E>{
    public Set<E> getSet(int implementado){
        if(implementado==1){
            return new HashSet<E>(); //HashSet
        }else if(implementado==2){
            return new TreeSet<E>(); //TreeSet
        }else if(implementado==3){
            return new LinkedHashSet<E>(); //LinkedHashSet
        }else{
            return null;
        }
    }
}
