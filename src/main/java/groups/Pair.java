package groups;

public class Pair<E> {
    private E elem1, elem2;

    /**
     * Create a new pair given two elements
     *
     * @param elem1 not null
     * @param elem2 not null
     */
    public Pair(E elem1, E elem2) {
        assert ((elem1 != null) && (elem2 != null));
        this.elem1 = elem1;
        this.elem2 = elem2;
    }

    /**
     * Compare two Pair objects for equality.
     *
     * @param obj is not null
     * @return true if this Pair and the other Pair represent
     * the same two elems and false otherwise.
     */
    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Pair) {
            Pair other = (Pair) obj;
            return ((this.elem1.equals(other.elem1) && this.elem2.equals(other.elem2)));
        } else {
            return false;
        }

    }

    /**
     * Compute the hashCode for a Pair
     *
     * @return the hashCode for this Pair
     */
    @Override
    public int hashCode() {
        return elem1.hashCode() * elem1.hashCode() * elem1.hashCode() + elem2.hashCode() * elem2.hashCode();
    }

    /**
     * Return the first element in the Pair.
     * The ordering of E objects in a Pair is arbitrary.
     *
     * @return the first element in the Pair.
     */
    public E getElem1() {
        return elem1;
    }

    /**
     * Return the second element in the Pair.
     * The ordering of E objects in a Pair is arbitrary.
     *
     * @return the second element in the Pair.
     */
    public E getElem2() {
        return elem2;
    }

    /**
     * Return a String representation of the Pair.
     *
     * @return a String representation of the Pair.
     */
    @Override
    public String toString() {
        return (elem1.toString() + " & " + elem2.toString());
    }

}