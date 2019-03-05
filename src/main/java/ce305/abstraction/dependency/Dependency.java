package ce305.abstraction.dependency;

import java.util.UUID;

public final class Dependency {
    public final UUID id;
    public final String name;
    
    public Dependency(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override    
    public boolean equals(Object o) {        
        if (this == o) return true;        
        if (o == null || getClass() != o.getClass()) return false; 

        Dependency dependency = (Dependency) o;    

        if (this.id.equals(dependency.id)) {
            return false;
        }
        
        return true;
    }    
    @Override    
    public int hashCode() {        
        int result = (this.id != null ? this.id.hashCode() : 0);
        return result;    
    }

    @Override
    public String toString() {
        return String.format("id: %s, name: %s", this.id, this.name);
    }
}