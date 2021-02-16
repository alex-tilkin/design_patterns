package unit_21_state;

class State{
	void on(LightSwitch lightSwitch) {
		System.out.println("Lightswitch is already on");
	}
	
	void off(LightSwitch lightSwitch) {
		System.out.println("Lightswitch is already off");
	}
}

class OnState extends State{
	public OnState() {
		System.out.println("The ligh is turned on");
	}
	
	@Override
	void off(LightSwitch lightSwitch) {
		System.out.println("Switching the ligh off");
		lightSwitch.setState(new OffState());
	}
}

class OffState extends State{
	public OffState() {
		System.out.println("The ligh is turned off");
	}
	
	@Override
	void on(LightSwitch lightSwitch) {
		System.out.println("Switching the ligh on");
		lightSwitch.setState(new OnState());
	}
}

class LightSwitch{
	private State state;
	
	public LightSwitch() {
		state = new OffState();
	}
	
	void on() {	
		state.on(this);
	}
	
	void off() {
		state.off(this);
	}
	
	void setState(State state) {
		this.state = state;
	}
}


public class ClassicStateExample {

	public static void main(String[] args) {
		LightSwitch lightSwitch = new LightSwitch();
		
		lightSwitch.on();
		lightSwitch.off();
		lightSwitch.off();
	}
}