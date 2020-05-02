public class Node  {

    protected tour tour;
    protected Node prochainNode;

    public Node(tour tour){
        this.tour = tour;
    }

    public boolean equals(Object o){
        tour t = (tour)o;
        return t.equals(tour);
    }
}
