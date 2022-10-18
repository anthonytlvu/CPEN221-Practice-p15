package groups;

import java.util.Map;
import java.util.Set;

public class ProbableGroup {

    /**
     * <p>Create an instance of ProbableGroup</p>
     *
     * @param elements is not null, not empty and does not contain "" or null
     * @param opTable  is not null and not empty,
     *                 and all pairs of `String`s in elements are keys in opTable
     */
    public ProbableGroup(Set<String> elements, Map<Pair<String>, String> opTable) {
        // TODO: implement the constructor
    }


    /**
     * Obtain the elements in an instance of ProbableGroup
     *
     * @return the set of elements in this instance of ProbableGroup
     */
    public Set<String> getElements() {
        // TODO: implement this method
        return null;
    }

    /**
     * Obtain the complete operation table for an instance of ProbableGroup
     *
     * @return the complete operation table for this instance of ProbableGroup
     */
    public Map<Pair<String>, String> getOpTable() {
        // TODO: Implement this method
        return null;
    }

    /**
     * Return a * b
     *
     * @param a is an element of this ProbableGroup
     * @param b is an element of this ProbableGroup
     * @return a * b
     */
    public String product(String a, String b) {
        // TODO: Implement this method
        return null;
    }

    /**
     * Obtain the identity element of this ProbableGroup
     *
     * @return the identity of the ProbableGroup if it exists, otherwise returns the empty String ("")
     */
    public String getIdentity() {
        // TODO: Implement this method
        return null;
    }

    /**
     * Obtain the inverse of element a
     *
     * @param a is an element of this ProbableGroup
     * @return the inverse of a, a', such that a * a' = e if it exists, otherwise returns the empty String ("")
     */
    public String getInverse(String a) {
        // TODO: Implement this method
        return null;
    }

    /**
     * Obtain a^n = a * a^(n-1) as defined by the * operation for this ProbableGroup
     *
     * @param a is an element of this ProbableGroup
     * @param n n > 0 and n is the exponent that we would like to raise a to
     * @return a^n
     */
    public String power(String a, int n) {
        // TODO: Implement this method
        return null;
    }

    /**
     * Obtain the order of element a
     * It is provable that for a finite Group the order is always finite
     * // requires: this.isGroup() returns true
     *
     * @param a is an element of this ProbableGroup
     * @return the order of element a in this ProbableGroup
     */
    public int order(String a) {
        // TODO: Implement this method
        return -1;
    }

    /**
     * Check if this ProbableGroup is a group
     *
     * @return true if the ProbableGroup is a group, otherwise return false
     */
    public boolean isGroup() {
        // TODO: Implement this method
        return false;
    }

    /**
     * Check if this ProbableGroup is commutative
     *
     * @return true if the Probable Group is commutative, otherwise return false
     */
    public boolean isCommutative() {
        // TODO: Implement this method
        return false;
    }

    /**
     * Check if a set h is a subgroup of this instance
     *
     * @param h is a set of elements
     * @return true if h is a subgroup of this instance, otherwise return false
     */
    public boolean isSubgroup(Set<String> h) {
        // TODO: Implement this method
        return false;
    }
}