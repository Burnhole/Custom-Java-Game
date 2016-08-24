package dcman58.Engine;

public class Vector2f {
	
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}public String toString(){
		return "("+x+" , " + y + ")";
	}
	private float x, y;

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	

}
