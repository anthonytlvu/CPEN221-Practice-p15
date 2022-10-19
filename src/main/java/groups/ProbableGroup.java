package groups;

import java.util.*;

public class ProbableGroup {

    private final Set<String> elts = new HashSet<>();
    private final Map<Pair<String>, String> productMap = new HashMap<>();
    /**
     * <p>Create an instance of ProbableGroup</p>
     *
     * @param elements is not null, not empty and does not contain "" or null
     * @param opTable  is not null and not empty,
     *                 and all pairs of `String`s in elements are keys in opTable
     */
    public ProbableGroup(Set<String> elements, Map<Pair<String>, String> opTable) {
        this.elts.addAll(elements);
        this.productMap.putAll(opTable);
    }


    /**
     * Obtain the elements in an instance of ProbableGroup
     *
     * @return the set of elements in this instance of ProbableGroup
     */
    public Set<String> getElements() {
        return new HashSet<>(elts);
    }

    /**
     * Obtain the complete operation table for an instance of ProbableGroup
     *
     * @return the complete operation table for this instance of ProbableGroup
     */
    public Map<Pair<String>, String> getOpTable() {
        return new HashMap<>(productMap);
    }

    /**
     * Return a * b
     *
     * @param a is an element of this ProbableGroup
     * @param b is an element of this ProbableGroup
     * @return a * b
     */
    public String product(String a, String b) {
        return productMap.get(new Pair<>(a, b));
    }

    /**
     * Obtain the identity element of this ProbableGroup
     *
     * @return the identity of the ProbableGroup if it exists, otherwise returns the empty String ("")
     */
    public String getIdentity() {
        int count = 0;
        for (String strI: elts) {
            for (String strJ: elts) {
                if (!Objects.equals(product(strJ, strI), strJ) || !Objects.equals(product(strI, strJ), strJ)){
                    count = 0;
                    break;
                }
                count++;
            }
            if (count == elts.size()) return strI;
        }

        return "";
    }

    /**
     * Obtain the inverse of element a
     *
     * @param a is an element of this ProbableGroup
     * @return the inverse of a, a', such that a * a' = e if it exists, otherwise returns the empty String ("")
     */
    public String getInverse(String a) {
        String id = getIdentity();
        for (String strI: elts) {
            if (Objects.equals(product(a, strI), id) && Objects.equals(product(strI, a), id)) return strI;
        }

        return "";
    }

    /**
     * Obtain a^n = a * a^(n-1) as defined by the * operation for this ProbableGroup
     *
     * @param a is an element of this ProbableGroup
     * @param n n > 0 and n is the exponent that we would like to raise a to
     * @return a^n
     */
//    public String power(String a, int n) {
//        if (n == 1) return a;
//        if (n > 1) {
//            String power = product(a, a);
//            for (int i = 2; i < n; i++) {
//                power = product(power, a);
//            }
//            return power;
//        }
//
//        return "";
//    }
    public String power(String a, int n) {
        if (n == 1) return a;
        if (n > 1) return product(a, power(a, n - 1));
        return "";
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
        String str = getIdentity();
        for (int i = 0; i < productMap.size(); i++)
            if (Objects.equals(power(a, i), str)) return i;

        return 0;
    }

    /**
     * Check if this ProbableGroup is a group
     *
     * @return true if the ProbableGroup is a group, otherwise return false
     */
    public boolean isGroup() {
        if (Objects.equals(getIdentity(), "")) return false;
        for (String str1: elts) if (Objects.equals(getInverse(str1), "")) return false;
        for (String x1: elts)
            for (String x2: elts)
                for (String x3: elts)
                    if (!Objects.equals(product(x1, product(x2, x3)), product(product(x1, x2), x3))) return false;
        for (String x1: elts)
            for (String x2: elts)
                if(!elts.contains(product(x1, x2))) return false;
        return true;
    }

    /**
     * Check if this ProbableGroup is commutative
     *
     * @return true if the Probable Group is commutative, otherwise return false
     */
    public boolean isCommutative() {
        for (String strI: elts)
            for (String strJ: elts)
                if (!Objects.equals(product(strJ, strI), product(strI, strJ))) return false;
        return true;
    }

    /**
     * Check if a set h is a subgroup of this instance
     *
     * @param h is a set of elements
     * @return true if h is a subgroup of this instance, otherwise return false
     */
    public boolean isSubgroup(Set<String> h) {
        for (String str1: h) {
            if(!h.contains(getInverse(str1))) return false;
            for (String str2: h) if(!h.contains(product(str1, str2))) return false;
        }

        return true;
    }
}