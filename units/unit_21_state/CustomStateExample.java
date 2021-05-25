package unit_21_state;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import org.javatuples.Pair;

enum StateE {
	ON_SALE,
	IN_CART,
	IN_WISHLIST,
	SOLD
}

enum Transition {
	REMOVE_FROM_CART,
	ADD_TO_CART,
	ADD_TO_WISHLIST,
	REMOVE_FROM_WISHLIST,
	PAY
}

class OnSale {
	
}

class InCart {
	
}

class InWishlist {
	
}

class Sold {
	
}

public class CustomStateExample {

	public static void main(String[] args) {
		Map<StateE, List<Pair<Transition, StateE>>> stateMachine = new HashMap<>();
		
		List<Pair<Transition, StateE>> transitions = new ArrayList<Pair<Transition,StateE>>();
		
		transitions.add(new Pair<Transition, StateE>(Transition.ADD_TO_WISHLIST, StateE.IN_WISHLIST));
		transitions.add(new Pair<Transition, StateE>(Transition.ADD_TO_CART, StateE.IN_CART));
		stateMachine.put(StateE.ON_SALE, transitions);
		
		transitions = new ArrayList<Pair<Transition,StateE>>();
		transitions.add(new Pair<Transition, StateE>(Transition.REMOVE_FROM_WISHLIST, StateE.ON_SALE));
		transitions.add(new Pair<Transition, StateE>(Transition.ADD_TO_CART, StateE.IN_CART));
		stateMachine.put(StateE.IN_WISHLIST, transitions);
		
		transitions = new ArrayList<Pair<Transition,StateE>>();
		transitions.add(new Pair<Transition, StateE>(Transition.PAY, StateE.SOLD));
		transitions.add(new Pair<Transition, StateE>(Transition.REMOVE_FROM_CART, StateE.ON_SALE));
		stateMachine.put(StateE.IN_CART, transitions);
		
		StateE currentState = StateE.ON_SALE;
		StateE endState = StateE.SOLD;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("The current state of the product is " + currentState);
			System.out.println("Select action:");
			for (int index = 0; index < stateMachine.get(currentState).size(); index++) {
				Transition transition = stateMachine.get(currentState).get(index).getValue0();
				System.out.println(index + ". " + transition);
			}
			
			boolean isParsed;
			int choice = 0;
			do {
				System.out.println("Select your action");
				try {
					choice = Integer.parseInt(reader.readLine());
					isParsed = choice >= 0 && choice < stateMachine.get(currentState).size();
				} catch (Exception exception) {
					System.out.println("Bad input, try again");
					isParsed = false;
				}
			} while(!isParsed);
			
			currentState = stateMachine.get(currentState).get(choice).getValue1();
			if(currentState == endState) {
				break;
			}
		}
		
		System.out.println("The item was sold");
	}
}