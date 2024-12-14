package tp1.view;

import tp1.util.MyStringUtils;

public class Messages {
	
	public static final String VERSION = "3";

	public static final String GAME_NAME = "Lemmings";

	public static final String USAGE = "Usage: %s [<level>]".formatted(GAME_NAME);

	public static final String WELCOME = String.format("%s %s%n", GAME_NAME, VERSION);

	public static final String LEVEL_NOT_A_NUMBER = "The level must be a number";

	public static final String LEVEL_NOT_A_NUMBER_ERROR = String.format("%s: %%s", LEVEL_NOT_A_NUMBER);

	public static final String CONFIGURED_LEVEL = "Level: %s";

	public static final String PROMPT = "Command > ";

	public static final String DEBUG = "[DEBUG] Executing: %s%n";

	public static final String ERROR = "[ERROR] Error: %s%n";

	public static final String LINE_SEPARATOR = System.lineSeparator();

	public static final String HELP_AVAILABLE_COMMANDS = "Available commands:";

	public static final String HELP_DETAILS_COMMAND_HELP_SEPARATOR = ": ";

	/* @formatter:off */
	public static final String[] HELP_LINES = new String[] { "Available commands:",
			"[n]one | \"\": skips cycle",
			"[r]eset: start a new game",
			"[h]elp: print this help message",
			"[e]xit: end the execution of the game"};
	/* @formatter:on */

	public static final String HELP = String.join(LINE_SEPARATOR+"   ", HELP_LINES) + LINE_SEPARATOR;
	
	public static final String UNKNOWN_COMMAND = "Unknown command";
	
	public static final String UNKOWN_ROLE="Unknown Role: %s";
	
	public static final String SETROLE_ERROR="SetRoleCommand error (Incorrect position or no object in that position admits that role)";
	
	public static final String COMMAND_PARAMETERS_MISSING = "Missing parameters";
	
	public static final String SETROLE_ERROR_ROLE="Incorrect or unexistent role";
	
	public static final String COMMAND_INCORRECT_PARAMETER_NUMBER = "Incorrect parameter numbers";

	public static final String INVALID_POSITION = "Invalid position (%s, %s)";

	public static final String INVALID_GAME_OBJECT = String.format("Invalid object %n");

	public static final String INVALID_COMMAND = "Invalid command";

	public static final String NUMBER_OF_CYCLES = "Number of cycles:";

	public static final String REMAINING_LEMMINGS = "Remaining lemmings:";

	public static final String DEAD_LEMMINGS = "Dead lemmings:";

	public static final Object EXIT_LEMMINGS = "Lemmings exit door:";

	public static final String NUM_LEMMINGS = "Lemmings in board:";

	public static final String GAME_OVER = "Game over";

	public static final String PLAYER_QUITS = "Player leaves the game";

	public static final String PLAYER_WINS = "Player wins!";
	public static final String PLAYER_LOOSES = "Player looses...";

	public static final String POSITION = "(%s,%s)";
	
	public static final String LEVEL_INVALID="Invalid Level";
	
	public static final String GAME_LOAD_INCORRECTGAMESTATUS="Invalid game status: %s";
	
	public static final String INCORRECT_FILE="Invalid file \"%s\" configuration";
	
	public static final String INVALID_OBJECT="Invalid Object: %s";
    
	public static final String COMMADN_EXECUTE_PROBLEM="Command execute problem";
	
	public static final String INVALID_COMMAND_PARAMETERS="Invalid command parameters";
	
	public static final String SAVE_FILE_ERROR ="Save error: %s ";
	
	public static final String LOAD_FILE_ERROR ="Load error";
	
	
//Commands
	
	
	public static final String COMMAND_SETROLE_NAME = "setRole";
	public static final String COMMAND_SETROLE_SHORTCUT = "sR";
	public static final String COMMAND_SETROLE_DETAILS = "[s]et[R]ole ROLE ROW COL:";
	public static final String COMMAND_SETROLE_HELP = "set the lemming in position (ROW,COL) to role ROLE";
	
	//A
	public static final String COMMAND_NONE_NAME = "none";
	public static final String COMMAND_NONE_SHORTCUT = "n";
	public static final String COMMAND_NONE_DETAILS = "[n]one | \"\"";
	public static final String COMMAND_NONE_HELP = "user does not perform any action";
	
	//Added reset commands
	public static final String COMMAND_RESET_NAME = "reset";
	public static final String COMMAND_RESET_SHORTCUT = "r";
	public static final String COMMAND_RESET_DETAILS = "[r]eset";
	public static final String COMMAND_RESET_HELP = "reset the level that was being played";
	
	//Added none command
	public static final String COMMAND_UPDATE_NAME = "update";
	public static final String COMMAND_UPDATE_SHORTCUT = "u";
	public static final String COMMAND_UPDATE_DETAILS = "[u]pdate";
	public static final String COMMAND_UPDATE_HELP = "updates the game by one cycle";
	
	public static final String COMMAND_EXIT_NAME = "exit";
	public static final String COMMAND_EXIT_SHORTCUT = "e";
	public static final String COMMAND_EXIT_DETAILS = "[e]xit";
	public static final String COMMAND_EXIT_HELP = "exits the game";

	public static final String COMMAND_HELP_NAME = "help";
	public static final String COMMAND_HELP_SHORTCUT = "h";
	public static final String COMMAND_HELP_DETAILS = "[h]elp";
	public static final String COMMAND_HELP_HELP = "shows this help";
	
	public static final String COMMAND_LOAD_NAME = "load";
	public static final String COMMAND_LOAD_SHORTCUT = "l";
	public static final String COMMAND_LOAD_DETAILS = "[l]oad <fileName>";
	public static final String COMMAND_LOAD_HELP = "load a state of the game from the text file <fileName>";
	
	public static final String COMMAND_SAVE_NAME = "Save";
	public static final String COMMAND_SAVE_SHORTCUT = "s";
	public static final String COMMAND_SAVE_DETAILS = "[s]ave to <fileName>";
	public static final String COMMAND_SAVE_HELP = "save  a state of the game to the text file <fileName>";
//Roles
	public static final String WALKER_NAME="Walker";
	public static final String WALKER_SHORTCUT="w";
	public static final String WALKER_DETAILS="[W]alker";
	public static final String WALKER_HELP="Lemming that walks";
	
	public static final String PARACHUTER_NAME="Parachuter";
	public static final String PARACHUTER_SHORTCUT="p";
	public static final String PARACHUTER_DETAILS="[P]arachuter";
	public static final String PARACHUTER_HELP="Lemming that falls with a parachute";
	
	public static final String DOWNCAVER_NAME="Downcaver";
	public static final String DOWNCAVER_SHORTCUT="d";
	public static final String DOWNCAVER_DETAILS="[D]owncaver";
	public static final String DOWNCAVER_HELP="Lemming caves downwards";
	
	public static final String DRONE_NAME="Drone";
	public static final String DRONE_SHORTCUT="dr";
	public static final String DRONE_DETAILS="[Dr]one";
	public static final String DRONE_HELP="Drone that flies through all directions specified";
	

//Symbols
	public static final String EMPTY = "";
	public static final String WALL = MyStringUtils.repeat("▓",ConsoleView.CELL_SIZE);
	public static final String METALWALL = MyStringUtils.repeat("X",ConsoleView.CELL_SIZE);
	public static final String EXIT_DOOR = "🚪";
	public static final String LEMMING_RIGHT = "K";
	public static final String LEMMING_LEFT = "ꓘ";
	public static final String PARACHUTE = "🪂";
	public static final String LEMMING_DOWN_CAVER = "´･ω･`";
	public static final String DRONE = "🛸";
}
