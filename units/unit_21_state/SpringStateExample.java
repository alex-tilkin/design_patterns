package unit_21_state;

import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

enum States {
	ON_SALE,
	IN_CART,
	IN_WISHLIST,
	SOLD
}

enum Events {
	REMOVE_FROM_CART,
	ADD_TO_CART,
	ADD_TO_WISHLIST,
	REMOVE_FROM_WISHLIST,
	PAY
}

class SpringStateExample {
	public static StateMachine<States, Events> buildMachine() throws Exception {
		StateMachineBuilder.Builder<States, Events> builder = StateMachineBuilder.builder();

		builder.configureStates().withStates().initial(States.ON_SALE).states(EnumSet.allOf(States.class));

		builder.configureTransitions().withExternal().source(States.ON_SALE).event(Events.ADD_TO_WISHLIST).target(States.IN_WISHLIST)
			.and().withExternal().source(States.ON_SALE).event(Events.ADD_TO_CART).target(States.IN_CART)
			.and().withExternal().source(States.IN_WISHLIST).event(Events.ADD_TO_CART).target(States.IN_CART)
			.and().withExternal().source(States.IN_CART).event(Events.REMOVE_FROM_CART).target(States.ON_SALE)
			.and().withExternal().source(States.IN_CART).event(Events.PAY).target(States.SOLD);

		return builder.build();
	}

	// requires org.springframework.statemachine
	public static void main(String[] args) throws Exception {
		StateMachine<States, Events> machine = buildMachine();
		machine.start();

		States exitState = States.IN_CART;

		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			State<States, Events> state = machine.getState();

			System.out.println("The phone is currently " + state.getId());
			System.out.println("Select a trigger:");

			List<Transition<States, Events>> ts = machine.getTransitions().stream().filter(t -> t.getSource() == state)
					.collect(Collectors.toList());
			for (int i = 0; i < ts.size(); ++i) {
				System.out.println("" + i + ". " + ts.get(i).getTrigger().getEvent());
			}

			boolean parseOK;
			int choice = 0;
			do {
				try {
					System.out.println("Please enter your choice:");

					choice = Integer.parseInt(console.readLine());
					parseOK = choice >= 0 && choice < ts.size();
				} catch (Exception e) {
					parseOK = false;
				}
			} while (!parseOK);

			// perform the transition
			machine.sendEvent(ts.get(choice).getTrigger().getEvent());

			if (machine.getState().getId() == exitState)
				break;
		}
		
		System.out.println("And we are done!");
	}
}