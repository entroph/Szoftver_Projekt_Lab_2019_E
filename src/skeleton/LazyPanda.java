package skeleton;

import static skeleton.Application.*;

public class LazyPanda extends Panda{

	private boolean sitting;

	public LazyPanda(){}

	public LazyPanda(Field cf) {
		super(cf);
	}

	public boolean Lazy(Fotel f) {
		tabs++;
		logger(toString() + ".Lazy");
		sitting = true;
		setField(f.GetField());
		Release();
		tabs--;
		return true;
	}
	
	public void UnLazy(Fotel f) {
		tabs++;
		sitting = false;
		logger(toString() + ".UnLazy");
		tabs--;
	}
	
	public void Move() {
		
	}
}
