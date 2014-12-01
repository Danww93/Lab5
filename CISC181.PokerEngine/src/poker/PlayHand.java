package poker;

import java.util.ArrayList;
import java.util.Collections;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


import poker.Hand;






public class PlayHand {
	
	

	

	
	public static void main(String[] args) {
		

		
		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
	        Session session = sessionFactory.getCurrentSession();
		for (int gCount = 0; gCount <= 1; gCount++) {
			
			session.beginTransaction();
			ArrayList<Hand> Hands = new ArrayList<Hand>();
			Deck d = new Deck();
			
			for (int hCnt = 0; hCnt <= 2; hCnt++) {
				Hand h = new Hand(d);
				h.EvalHand();
				Hands.add(h);
			}
			Collections.sort(Hands, Hand.HandRank);
			
			session.save(Hands);
	        
	        
	        System.out.print("Hand Strength: " + Hands.get(0).getHandStrength());
			System.out.print(" Hi Hand: " + Hands.get(0).getHighPairStrength());
			System.out.print(" Lo Hand: " + Hands.get(0).getLowPairStrength());
			System.out.print(" Kicker: " + Hands.get(0).getKicker());
			

			System.out.print(" beats ");

			System.out.print(" Hand Strength: " + Hands.get(1).getHandStrength());
			System.out.print(" Hi Hand: " + Hands.get(1).getHighPairStrength());
			System.out.print(" Lo Hand: " + Hands.get(1).getLowPairStrength());
			System.out.print(" Kicker: " + Hands.get(1).getKicker());
			
			
			
			
			

			System.out.print("\n");

		}
		sessionFactory.close();
		

	}

}
