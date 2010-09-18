import processing.core.PApplet;
import processing.serial.Serial;


public class SerialExample extends PApplet {
	Serial port;

	public void setup() {
		size(200,200);
		background(0);

		System.out.println("Available serial ports:");
		System.out.println(Serial.list());
	}

	public void draw() {
		// draw a gradient from black to white
		for (int i = 0; i < 256; i++) {
			stroke(i);
			line(i, 0, i, 150);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("starting");
		PApplet.main(new String[] { "--present", "SerialExample" });

	}
}
