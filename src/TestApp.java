import processing.core.*;
import controlP5.*;
public class TestApp extends PApplet {
	ControlP5 controlP5;
	int buttonValue=0;
	int myColor=color(0,155,180);
	
	public void setup() {
		size(200,200);
		background(0);
		controlP5=new ControlP5(this);
		Button button1=controlP5.addButton("buttonA",0,100,100,80,19);
		button1.setLabel("button of awesome");
		controlP5.addButton("buttonB",255,100,120,80,19);
		controlP5.addButton("buttonValue",128,100,140,80,19);
	}

	public void draw() {
		stroke(255);
		if (mousePressed) {
			line(mouseX,mouseY,pmouseX,pmouseY);
		}
		fill(myColor);
		rect(20,20,width-40,height-40);
		
	}
	/**
	 * @param args
	 */
	 public static void main(String[] args) {
		 PApplet.main(new String[] { "--present", "TestApp" });
	 }
	 
	 public void buttonA(int theValue){
		 myColor=theValue;
	 }

	 public void buttonB(int theValue){
		 myColor=theValue;
	 }
}
