import processing.core.*;
import controlP5.*;
public class TestApp extends PApplet {
	enum viewState{MainPage, MatchPage, ClientSummaryPage, TeamSummaryPage};

	viewState currentView=viewState.MainPage;

	ControlP5 mainPageControl;
	ControlP5 matchPageControl;
	ControlP5 clientPageControl;
	ControlP5 TeamPageControl;

	ControlP5 [] controllers;

	int buttonValue=0;
	int myColor=color(0,155,180);

	//variables used to determine what to show on which page
	//determine what to show on team page
	int currentTeam;
	//determine what to show on client summary page
	int currentClientSummary;
	//determine what to show on match page
	int currentClientA;
	int currentClientB;


	public void setup() {
		databaseRead();

		controllers=new ControlP5 [4];

		size(1000,600);
		background(0);

		frameRate(30);

		mainPageControl=new ControlP5(this);
		matchPageControl=new ControlP5(this);
		clientPageControl=new ControlP5(this);
		TeamPageControl=new ControlP5(this);

		controllers[viewState.MainPage.ordinal()]=mainPageControl;
		controllers[viewState.MatchPage.ordinal()]=matchPageControl;
		controllers[viewState.ClientSummaryPage.ordinal()]=clientPageControl;
		controllers[viewState.TeamSummaryPage.ordinal()]=TeamPageControl;



		setupMainPage();

		Button showMatchButton=mainPageControl.addButton("showMatch",1,100,100,100,19);
		showMatchButton.setLabel("go to Fake match");


		Button showclient=mainPageControl.addButton("showClientSummary",1,300,100,140,19);
		showclient.setLabel("go to Fake client summary");

		Button showTeam =mainPageControl.addButton("showTeamSummary",1,700,100,140,19);
		showTeam.setLabel("go to Fake Team summary");



		/**
		 * add everything to the match page controller here
		 */
		Button back1=matchPageControl.addButton("changeView",0,20,20,80,19);
		back1.setLabel("Back");
		Button play=matchPageControl.addButton("playMatch",5,500,500,80,19);
		play.setLabel("Play Match");
		matchPageControl.addTextlabel("fakematchtitle", "Match Data",500, 50);

		
		/**
		 * add everything to the client summary page controller here
		 */
		Button back2=clientPageControl.addButton("changeView",0,20,20,80,19);
		back2.setLabel("Back");
		clientPageControl.addTextlabel("clientInfotitle", "Client Summary",500, 50);


		/**
		 * add everything to the team summary page controller here
		 */
		Button back3=TeamPageControl.addButton("changeView",0,20,20,80,19);
		back3.setLabel("Back");
		TeamPageControl.addTextlabel("teamInfotitle", "Team Summary ",500, 50);

		changeView(0);
	}


	public void draw() {
		background(myColor);
		//if statement here to draw appropriate bar graphs and such
		// if(currentView)
	}

	public void changeView(int view){
		//keep the current view up to date
		currentView=viewState.values()[view];
		//hide all controllers
		for(int i=0;i<controllers.length;i++){
			controllers[i].hide();
		}
		//show the one we want
		controllers[view].show();
	}



	/**
	 * this function should read in all the information from the entire database and build/
	 * push it to the correct objects so the gui can handle stuff
	 */
	public void databaseRead(){



	}


	/**
	 * this function should set up the grid and button links on the main page
	 */
	public void setupMainPage(){



	}




	public void playMatch(int value){
		//used to animate the match being played

		//not ready yet
	}

	public void showMatch(int value){
		//map value to a combination of client A and B, and then swap the view

		//this.currentClientA=value% blah blah;
		//this.currentClientB= value% blah;

		changeView(viewState.MatchPage.ordinal());

	}





	public void showClientSummary(int value){
		//map value to a client to show in client summary
		this.currentClientSummary=value;

		changeView(viewState.ClientSummaryPage.ordinal());
	}






	public void showTeamSummary(int value){
		//map value to a team to show in team summary
		currentTeam=value;
		changeView(viewState.TeamSummaryPage.ordinal());
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main(new String[] { "--present", "TestApp" });
	}

}
