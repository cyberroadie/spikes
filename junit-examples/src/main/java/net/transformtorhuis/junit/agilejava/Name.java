package net.transformtorhuis.junit.agilejava;

/**
 *
 * @author cyberroadie
 */
public class Name {

    private String name = null;

    public Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if(object ==  null) {
            return false;
        } 
        if(!(object instanceof Name)) {
            return false;
        }
        Name testName = (Name) object;
        return this.name.equals(testName.getName());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

}
