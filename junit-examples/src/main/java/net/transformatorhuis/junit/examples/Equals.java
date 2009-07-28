package net.transformatorhuis.junit.examples;

/**
 *
 * @author cyberroadie
 */
public class Equals {

    private Integer equalInteger = null;
    private String equalString = null;

    public Equals() {
    }

    public Equals(Integer equalInteger, String equalString) {
        this.equalInteger = equalInteger;
        this.equalString = equalString;
    }

    @Override
    public boolean equals(Object object) {
        if(object == null) {
            return false;
        }
        if(!(object instanceof Equals)) {
            return false;
        }
        Equals compareEquals = (Equals) object;
        if(compareEquals.getEqualInteger() == this.equalInteger &&
                compareEquals.getEqualString().equals(this.equalString)) {
            return true;
        }
        return false;
    }

    public Integer getEqualInteger() {
        return equalInteger;
    }

    public String getEqualString() {
        return equalString;
    }

    /**
     * If equals is overridden, you also need to overide hashcode
     * for correct ofr proper functioning of hashmap/hashset/hashtable etc.
     * @return
     */
    @Override
    public int hashCode() {
        // Primes gives a better distribution in hash tables
        final int hashMultiplier = 41;
        int result = 7;
        result = result * equalString.hashCode();
        result = result * equalInteger.hashCode();
        return result;
    }

}
