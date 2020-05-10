public class Coordonees {

    private int i,j;
    protected boolean dejaSaute;

    public Coordonees(int i, int j){    // on crée l'objet coordonnées
        this.i=i;                       // i est la ligne du tableau
        this.j=j;                       // j est la colonne du tableau
        dejaSaute=false;                // dejaSaute fait référence au fait qu'un pion ait été sauté par un autre pion ou non
    }

    public int getI(){      // méthode qui donne la valeur de la ligne
        return i;
    } //Pour retourner i

    public int getJ(){      // méthode qui donne la valeur de la colonne
        return j;
    } //Pour retourner j

    public boolean equals(Object o){    // méthode qui retourne les mêmes coordonnées que l'objet o 
        Coordonees c = (Coordonees)o;
        return c.getI()==i && c.getJ()==j;
    }

    public String toString(){  // méthode qui retourne la valeur de la ligne et de la colonne
        return "i="+i+" || j="+j;
    } //Methode toString
}
