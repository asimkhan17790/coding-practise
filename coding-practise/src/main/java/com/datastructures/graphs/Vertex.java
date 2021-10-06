package com.datastructures.graphs;

import java.util.Objects;

// Copied from Baeldung
public class Vertex {

    public String label;
    public Vertex(String label){
        this.label = label;
    }

    @Override
    public boolean equals(Object o){

        if (o == this){
            return true;
        }
        if (!(o instanceof Vertex) ){
            return false;
        }
        Vertex vo = (Vertex)o;
        
        return vo.label.equals(this.label);        
    }  
    public int hashCode() {
        int result = 1;
        result = 37 * result + Objects.hashCode(this.label);        
        return result;
      }
    
}

