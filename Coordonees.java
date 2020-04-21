public class Coordonees {

    private int i,j;
    protected boolean dejaSaute;

    public Coordonees(int i, int j){
        this.i=i;
        this.j=j;
        dejaSaute=false;
    }

    public int getI(){
        return i;
    }

    public int getJ(){
        return j;
    }

    public boolean equals(Object o){
        Coordonees c = (Coordonees)o;
        return c.getI()==i && c.getJ()==j;
    }

    public String toString(){
        return "i="+i+" || j="+j;
    }
}
