import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class LinkedListCirculaire {

    private LinkedHashMap<tour, Node> nodes;
    protected Node tete;
    protected Node queue;
    private int size;

    public LinkedListCirculaire() {
        nodes = new LinkedHashMap<>();
        tete=null;
        queue=null;
        size=0;
    }

    public LinkedListCirculaire(LinkedList<tour> joueurs){
        nodes = new LinkedHashMap<>();
        tete=null;
        queue=null;
        size=0;
        joueurs.forEach(this::add);
    }

    public void add(tour tour){
        Node aAjouter = new Node(tour);
        nodes.put(tour, aAjouter);

        if (tete == null){
            tete = aAjouter;
        }
        else {
            queue.prochainNode = aAjouter;
        }
        queue = aAjouter;
        queue.prochainNode = tete;
        size++;
    }

    public boolean remove(tour tour){
        if(tour==null){
            return  false;
        }
        else if (nodes.containsKey(tour)){
            if(size==1){
                tete=null;
                queue=null;
                nodes.remove(tour);
                size--;
            }

            else if(tour.equals(tete.tour)){
                tete=tete.prochainNode;
                nodes.remove(tour);
                queue.prochainNode=tete;
                size--;
            }
            else if(tour.equals(queue.tour)){
                Node current=tete;
                while (!current.prochainNode.tour.equals(tour)){
                    current=current.prochainNode;
                }
                queue=current;
                queue.prochainNode=tete;
                nodes.remove(tour);
                size--;

            }
            else {
                Node current = tete;
                while (!current.prochainNode.tour.equals(tour)){
                    current=current.prochainNode;
                }
                current.prochainNode=nodes.get(tour).prochainNode;
                nodes.remove(tour);
                size--;
            }
            return true;
        }
        else{return false;}
    }

    public int size(){
        return size;
    }

    public Node getNode(tour tour) {
        if (nodes.containsKey(tour)) {
            return nodes.get(tour);
        } else {
            System.out.println("n'est pas dans la liste");
            return null;
        }
    }

    public Node getFirst(){
        return tete;
    }


    public LinkedList<tour> getTours(){
        return new LinkedList<>(nodes.keySet());
    }


    public static void main(String[] args) throws Exception {
        LinkedListCirculaire tours = new LinkedListCirculaire();
        tours.add(tour.tourVERT);
        tours.add(tour.tourROSE);
        tours.add(tour.tourBLEU);
        tours.add(tour.tourROUGE);
        tours.add(tour.tourJAUNE);
        tours.add(tour.tourNOIR);

        Node tourActuel = tours.getFirst();
        System.out.println(tourActuel.tour.toString());
        tourActuel=tourActuel.prochainNode;
        System.out.println(tourActuel.tour.toString());
        tours.remove(tour.tourBLEU);
        tourActuel=tourActuel.prochainNode;
        System.out.println(tourActuel.tour.toString());
    }

}