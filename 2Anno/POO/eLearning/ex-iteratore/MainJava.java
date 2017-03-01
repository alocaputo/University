import java.util.*;


//import Poly.PolynomialTerm;




public class MainPoly {

	public static void main(String[] args) {
		Vector<Poly> l = new Vector<Poly>();
		Poly p0 = new Poly();
		Poly p1 = new Poly(5,4);
		Poly p2 = new Poly(5,3);
		l.add(p1);
		l.add(p2);
		Iterator<Poly> it2 = l.iterator();
		//p1.mul(p2);
		//p1.minus();
		differentiate(l);
		//while(it2.hasNext()){
		//System.out.println(it2.next().toString());
		//int d = p.degree();
		//}
		//p1.next();
	}
	
	/**
	* @param p not null
	* @return the result of symbolic differentiation of a poly
	* @Throws NullPointerException if p==null
	*/
	static public Poly differentiate(Vector<Poly> p) {
	Objects.requireNonNull(p);
	Poly q = new Poly();
	Iterator<Poly> it2 = p.iterator();
	//try {
	for (int i=1; it2.hasNext(); i++){
		Poly e = it2.next();
		q = q.add(new Poly(e.coefficient(e.degree())*e.degree(), e.degree()-1));		
	}
	System.out.println(q.toString());
	//} catch (NegativeExponentException nee){
	//assert false : "this cannot happen";
	//}
	return(q);
	}

}
