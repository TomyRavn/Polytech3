package RhythmGame_14;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.Console;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {

	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;

	ArrayList<Note> noteList = new ArrayList<Note>();

	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);

		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			note.screenDraw(g);
		}

		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString("000000", 565, 702);

	}

	public void pressS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}

	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}

	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}

	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}

	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}

	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}

	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}

	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	@Override
	public void run() {
		dropNotes(this.titleName);
	}

	public void close() {
		gameMusic.close();
		this.interrupt();
	}

	public void dropNotes(String titleName) {
		Beat[] beats = null;
		if (titleName.equals("Joakim Karud - Love Mode")) {
			int startTime = 5481 - Main.REACH_TIME * 1000;
			
			beats = loveModeBeat(beats, startTime);

		} else if (titleName.equals("Bensound - SadDay")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] { new Beat(startTime, "Space")

			};

		} else if (titleName.equals("Alan Walker - Energy")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] { new Beat(startTime, "Space")

			};
			
		}

		int i = 0;

		gameMusic.start();

		while (i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if (beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public Beat[] loveModeBeat(Beat[] beats, int startTime) {
		
		//0.1s = 1gap BPM
		int gap = 87;
		
		beats = new Beat[] { 
				new Beat(startTime, "S"),
				new Beat(startTime + gap * 7, "D"),
				new Beat(startTime + gap * 9, "F"),
				new Beat(startTime + gap * 19, "S"),
				new Beat(startTime + gap * 28, "D"),
				new Beat(startTime + gap * 31, "F"),
				new Beat(startTime + gap * 35, "S"),
				new Beat(startTime + gap * 39, "D"),
				new Beat(startTime + gap * 43, "F"),
				new Beat(startTime + gap * 47, "Space"),
				new Beat(startTime + gap * 51, "S"),
				new Beat(startTime + gap * 55, "Space"),
				new Beat(startTime + gap * 59, "Space"),
				new Beat(startTime + gap * 65, "D"),
				new Beat(startTime + gap * 74, "F"),
				new Beat(startTime + gap * 76, "S"),
				new Beat(startTime + gap * 80, "D"),
				new Beat(startTime + gap * 84, "F"),
				new Beat(startTime + gap * 89, "S"),
				new Beat(startTime + gap * 93, "D"),
				new Beat(startTime + gap * 99, "F"),
				new Beat(startTime + gap * 103, "S"),
				new Beat(startTime + gap * 107, "D"),
				new Beat(startTime + gap * 111, "F"),
				new Beat(startTime + gap * 115, "S"),
				new Beat(startTime + gap * 119, "D"),
				new Beat(startTime + gap * 123, "F"),
				new Beat(startTime + gap * 127, "Space"),
				new Beat(startTime + gap * 131, "S"),
				new Beat(startTime + gap * 138, "D"),
				new Beat(startTime + gap * 141, "F"),
				new Beat(startTime + gap * 148, "S"),
				new Beat(startTime + gap * 155, "D"),
				new Beat(startTime + gap * 159, "F"),
				new Beat(startTime + gap * 163, "S"),
				new Beat(startTime + gap * 167, "D"),
				new Beat(startTime + gap * 171, "F"),
				new Beat(startTime + gap * 175, "S"),
				new Beat(startTime + gap * 179, "D"),
				new Beat(startTime + gap * 183, "F"),
				new Beat(startTime + gap * 187, "Space"),
				new Beat(startTime + gap * 195, "S"),
				new Beat(startTime + gap * 200, "D"),
				new Beat(startTime + gap * 204, "F"),
				new Beat(startTime + gap * 207, "S"),
				new Beat(startTime + gap * 211, "D"),
				new Beat(startTime + gap * 218, "F"),
				new Beat(startTime + gap * 220, "S"),
				new Beat(startTime + gap * 225, "D"),
				new Beat(startTime + gap * 229, "F"),
				new Beat(startTime + gap * 233, "S"),
				new Beat(startTime + gap * 237, "D"),
				new Beat(startTime + gap * 241, "F"),
				new Beat(startTime + gap * 245, "S"),
				new Beat(startTime + gap * 250, "D"),
				new Beat(startTime + gap * 256, "Space"),
				new Beat(startTime + gap * 262, "F"),
				new Beat(startTime + gap * 265, "S"),
				new Beat(startTime + gap * 272, "D"),
				new Beat(startTime + gap * 277, "F"),
				new Beat(startTime + gap * 285, "S"),
				new Beat(startTime + gap * 289, "D"),
				new Beat(startTime + gap * 293, "Space"),
				new Beat(startTime + gap * 299, "Space"),
				new Beat(startTime + gap * 307, "Space"),
				new Beat(startTime + gap * 314, "Space"),
				new Beat(startTime + gap * 320, "F"),
				new Beat(startTime + gap * 329, "S"),
				new Beat(startTime + gap * 331, "D"),
				new Beat(startTime + gap * 335, "F"),
				new Beat(startTime + gap * 339, "S"),
				new Beat(startTime + gap * 344, "D"),
				new Beat(startTime + gap * 348, "F"),
				new Beat(startTime + gap * 354, "S"),
				new Beat(startTime + gap * 358, "D"),
				new Beat(startTime + gap * 362, "F"),
				new Beat(startTime + gap * 366, "S"),
				new Beat(startTime + gap * 370, "D"),
				new Beat(startTime + gap * 374, "F"),
				new Beat(startTime + gap * 378, "S"),
				new Beat(startTime + gap * 382, "Space"),
				new Beat(startTime + gap * 386, "S"),
				new Beat(startTime + gap * 392, "D"),
				new Beat(startTime + gap * 395, "F"),
				new Beat(startTime + gap * 401, "S"),
				new Beat(startTime + gap * 409, "D"),
				new Beat(startTime + gap * 413, "F"),
				new Beat(startTime + gap * 417, "S"),
				new Beat(startTime + gap * 421, "D"),
				new Beat(startTime + gap * 425, "F"),
				new Beat(startTime + gap * 429, "S"),
				new Beat(startTime + gap * 433, "D"),
				new Beat(startTime + gap * 437, "F"),
				new Beat(startTime + gap * 441, "Space"),
				new Beat(startTime + gap * 449, "S"),		//양손
				new Beat(startTime + gap * 454, "D"),
				new Beat(startTime + gap * 459, "F"),
				new Beat(startTime + gap * 464, "S"),
				new Beat(startTime + gap * 468, "D"),
				new Beat(startTime + gap * 472, "F"),
				new Beat(startTime + gap * 477, "S"),
				new Beat(startTime + gap * 482, "D"),
				new Beat(startTime + gap * 487, "F"),
				new Beat(startTime + gap * 492, "S"),
				new Beat(startTime + gap * 497, "D"),
				new Beat(startTime + gap * 501, "F"),
				new Beat(startTime + gap * 508, "S"),
				new Beat(startTime + gap * 513, "D"),
				new Beat(startTime + gap * 518, "F"),
				new Beat(startTime + gap * 523, "S"),
				new Beat(startTime + gap * 527, "D"),
				new Beat(startTime + gap * 531, "F"),
				new Beat(startTime + gap * 535, "S"),
				new Beat(startTime + gap * 539, "D"),
				new Beat(startTime + gap * 543, "F"),
				new Beat(startTime + gap * 547, "S"),
				new Beat(startTime + gap * 551, "D"),
				new Beat(startTime + gap * 555, "F"),
				new Beat(startTime + gap * 559, "S"),
				new Beat(startTime + gap * 563, "D"),
				new Beat(startTime + gap * 567, "F"),
				new Beat(startTime + gap * 571, "S"),
				new Beat(startTime + gap * 575, "D"),
				new Beat(startTime + gap * 579, "F"),
				new Beat(startTime + gap * 581, "J"),
				new Beat(startTime + gap * 583, "S"),
				new Beat(startTime + gap * 587, "D"),
				new Beat(startTime + gap * 587, "J"),
				new Beat(startTime + gap * 591, "F"),
				new Beat(startTime + gap * 595, "S"),
				new Beat(startTime + gap * 599, "D"),
				new Beat(startTime + gap * 603, "F"),
				new Beat(startTime + gap * 607, "S"),
				new Beat(startTime + gap * 611, "D"),
				new Beat(startTime + gap * 615, "F"),
				new Beat(startTime + gap * 619, "S"),
				new Beat(startTime + gap * 623, "D"),
				new Beat(startTime + gap * 627, "F"),
				new Beat(startTime + gap * 631, "S"),
				new Beat(startTime + gap * 635, "D"),
				new Beat(startTime + gap * 639, "F"),
				new Beat(startTime + gap * 643, "S"),
				new Beat(startTime + gap * 647, "D"),
				new Beat(startTime + gap * 651, "F"),
				new Beat(startTime + gap * 655, "S"),
				new Beat(startTime + gap * 659, "D"),
				new Beat(startTime + gap * 663, "F"),
				new Beat(startTime + gap * 667, "S"),
				new Beat(startTime + gap * 671, "D"),
				new Beat(startTime + gap * 675, "F"),
				new Beat(startTime + gap * 679, "S"),
				new Beat(startTime + gap * 683, "D"),
				new Beat(startTime + gap * 687, "F"),
				new Beat(startTime + gap * 691, "S"),
				new Beat(startTime + gap * 695, "D"),
				new Beat(startTime + gap * 699, "F"),
				new Beat(startTime + gap * 703, "S"),
				new Beat(startTime + gap * 707, "D"),
				new Beat(startTime + gap * 711, "F"),
				new Beat(startTime + gap * 715, "S"),
				new Beat(startTime + gap * 719, "D"),
				new Beat(startTime + gap * 723, "F"),
				new Beat(startTime + gap * 727, "S"),
				new Beat(startTime + gap * 731, "D"),
				new Beat(startTime + gap * 735, "F"),
				new Beat(startTime + gap * 739, "S"),
				new Beat(startTime + gap * 743, "D"),
				new Beat(startTime + gap * 747, "F"),
				new Beat(startTime + gap * 751, "S"),
				new Beat(startTime + gap * 755, "D"),
				new Beat(startTime + gap * 759, "F"),
				new Beat(startTime + gap * 763, "S"),
				new Beat(startTime + gap * 767, "D"),
				new Beat(startTime + gap * 771, "F"),
				new Beat(startTime + gap * 775, "S"),
				new Beat(startTime + gap * 779, "D"),
				new Beat(startTime + gap * 783, "F"),
				new Beat(startTime + gap * 787, "S"),
				new Beat(startTime + gap * 793, "D"),
				new Beat(startTime + gap * 797, "F"),
				new Beat(startTime + gap * 801, "S"),
				new Beat(startTime + gap * 805, "D"),
				new Beat(startTime + gap * 809, "F"),
				new Beat(startTime + gap * 813, "S"),
				new Beat(startTime + gap * 817, "D"),
				new Beat(startTime + gap * 821, "F"),
				new Beat(startTime + gap * 825, "S"),
				new Beat(startTime + gap * 829, "D"),
				new Beat(startTime + gap * 833, "F"),
				new Beat(startTime + gap * 837, "S"),
				new Beat(startTime + gap * 841, "D"),
				new Beat(startTime + gap * 845, "F"),
				new Beat(startTime + gap * 849, "S"),
				new Beat(startTime + gap * 853, "D"),
				new Beat(startTime + gap * 857, "F"),
				new Beat(startTime + gap * 861, "S"),
				new Beat(startTime + gap * 865, "D"),
				new Beat(startTime + gap * 869, "F"),
				new Beat(startTime + gap * 873, "S"),
				new Beat(startTime + gap * 877, "D"),
				new Beat(startTime + gap * 881, "F"),
				new Beat(startTime + gap * 885, "S"),
				new Beat(startTime + gap * 889, "D"),
				new Beat(startTime + gap * 893, "F"),
				new Beat(startTime + gap * 897, "S"),
				new Beat(startTime + gap * 901, "D"),
				new Beat(startTime + gap * 905, "F"),
				new Beat(startTime + gap * 909, "S"),
				new Beat(startTime + gap * 913, "D"),
				new Beat(startTime + gap * 917, "F"),
				new Beat(startTime + gap * 921, "S"),
				new Beat(startTime + gap * 925, "D"),
				new Beat(startTime + gap * 929, "F"),
				new Beat(startTime + gap * 933, "S"),
				new Beat(startTime + gap * 937, "D"),
				new Beat(startTime + gap * 941, "F"),
				new Beat(startTime + gap * 945, "S"),
				new Beat(startTime + gap * 949, "D"),
				new Beat(startTime + gap * 953, "F"),
				new Beat(startTime + gap * 957, "S"),
				new Beat(startTime + gap * 961, "D"),
				new Beat(startTime + gap * 965, "F"),
				new Beat(startTime + gap * 969, "S"),
				new Beat(startTime + gap * 973, "D"),
				new Beat(startTime + gap * 977, "F"),
				new Beat(startTime + gap * 981, "S"),
				new Beat(startTime + gap * 985, "D"),
				new Beat(startTime + gap * 989, "F"),
				new Beat(startTime + gap * 993, "S"),
				new Beat(startTime + gap * 997, "D"),
				new Beat(startTime + gap * 1001, "F"),
				new Beat(startTime + gap * 1005, "S"),
				new Beat(startTime + gap * 1009, "D"),
				new Beat(startTime + gap * 1013, "F"),
				new Beat(startTime + gap * 1017, "S"),
				new Beat(startTime + gap * 1021, "D"),
				new Beat(startTime + gap * 1025, "F"),
				new Beat(startTime + gap * 1029, "S"),
				new Beat(startTime + gap * 1033, "D"),
				new Beat(startTime + gap * 1037, "F"),
				new Beat(startTime + gap * 1041, "S"),
				new Beat(startTime + gap * 1045, "D"),
				new Beat(startTime + gap * 1049, "F"),
				new Beat(startTime + gap * 1053, "S"),
				new Beat(startTime + gap * 1057, "D"),
				new Beat(startTime + gap * 1061, "F"),
				new Beat(startTime + gap * 1065, "S"),
				new Beat(startTime + gap * 1069, "D"),
				new Beat(startTime + gap * 1073, "F"),
				new Beat(startTime + gap * 1077, "S"),
				new Beat(startTime + gap * 1081, "D"),
				new Beat(startTime + gap * 1085, "F"),
				new Beat(startTime + gap * 1089, "S"),
				new Beat(startTime + gap * 1093, "D"),
				new Beat(startTime + gap * 1097, "F"),
				new Beat(startTime + gap * 1101, "S"),
				new Beat(startTime + gap * 1105, "D"),
				new Beat(startTime + gap * 1109, "F"),
				new Beat(startTime + gap * 1113, "S"),
				new Beat(startTime + gap * 1117, "D"),
				new Beat(startTime + gap * 1121, "F"),
				new Beat(startTime + gap * 1125, "S"),
				new Beat(startTime + gap * 1129, "D"),
				new Beat(startTime + gap * 1133, "F"),
				new Beat(startTime + gap * 1137, "S"),
				new Beat(startTime + gap * 1141, "D"),
				new Beat(startTime + gap * 1145, "F"),
				new Beat(startTime + gap * 1149, "S"),
				new Beat(startTime + gap * 1153, "D"),
				new Beat(startTime + gap * 1157, "F"),
				new Beat(startTime + gap * 1161, "S"),
				new Beat(startTime + gap * 1165, "D"),
				new Beat(startTime + gap * 1169, "F"),
				new Beat(startTime + gap * 1173, "S"),
				new Beat(startTime + gap * 1177, "D"),
				new Beat(startTime + gap * 1181, "F"),
				new Beat(startTime + gap * 1185, "S"),
				new Beat(startTime + gap * 1189, "D"),
				new Beat(startTime + gap * 1193, "F"),
				new Beat(startTime + gap * 1197, "S"),
				new Beat(startTime + gap * 1201, "D"),
				new Beat(startTime + gap * 1205, "F"),
				new Beat(startTime + gap * 1209, "S"),
				new Beat(startTime + gap * 1213, "D"),
				new Beat(startTime + gap * 1217, "F"),
				new Beat(startTime + gap * 1221, "S"),
				new Beat(startTime + gap * 1225, "D"),
				new Beat(startTime + gap * 1229, "F"),
				new Beat(startTime + gap * 1233, "S"),
				new Beat(startTime + gap * 1237, "D"),
				new Beat(startTime + gap * 1241, "F"),
				new Beat(startTime + gap * 1245, "S"),
				new Beat(startTime + gap * 1249, "D"),
				new Beat(startTime + gap * 1253, "F"),
				new Beat(startTime + gap * 1257, "S"),
				new Beat(startTime + gap * 1261, "D"),
				new Beat(startTime + gap * 1265, "F"),
				new Beat(startTime + gap * 1269, "S"),
				new Beat(startTime + gap * 1273, "D"),
				new Beat(startTime + gap * 1277, "F"),
				new Beat(startTime + gap * 1281, "S"),
				new Beat(startTime + gap * 1285, "D"),
				new Beat(startTime + gap * 1289, "F"),
				new Beat(startTime + gap * 1293, "S"),
				new Beat(startTime + gap * 1297, "D"),
				new Beat(startTime + gap * 1301, "F"),
				new Beat(startTime + gap * 1305, "S"),
				new Beat(startTime + gap * 1309, "D"),
				new Beat(startTime + gap * 1313, "F"),
				new Beat(startTime + gap * 1317, "S"),
				new Beat(startTime + gap * 1321, "D"),
				new Beat(startTime + gap * 1325, "F"),
				new Beat(startTime + gap * 1329, "S"),
				new Beat(startTime + gap * 1333, "D"),
				new Beat(startTime + gap * 1337, "F"),
				new Beat(startTime + gap * 1341, "S"),
				new Beat(startTime + gap * 1345, "D"),
				new Beat(startTime + gap * 1349, "F"),
				new Beat(startTime + gap * 1353, "S"),
				new Beat(startTime + gap * 1357, "D"),
				new Beat(startTime + gap * 1361, "F"),
				new Beat(startTime + gap * 1365, "S"),
				new Beat(startTime + gap * 1369, "D"),
				new Beat(startTime + gap * 1373, "F"),
				new Beat(startTime + gap * 1377, "S"),
				new Beat(startTime + gap * 1381, "D"),
				new Beat(startTime + gap * 1385, "F"),
				new Beat(startTime + gap * 1389, "S"),
				new Beat(startTime + gap * 1393, "D"),
				new Beat(startTime + gap * 1397, "F"),
				
				
				//오른손
//				new Beat(startTime + gap * 587, "J"),//320
//				new Beat(startTime + gap * 329, "S"),
//				new Beat(startTime + gap * 331, "D"),
//				new Beat(startTime + gap * 335, "F"),
//				new Beat(startTime + gap * 339, "S"),
//				new Beat(startTime + gap * 344, "D"),
//				new Beat(startTime + gap * 348, "F"),
//				new Beat(startTime + gap * 354, "S"),
//				new Beat(startTime + gap * 358, "D"),
//				new Beat(startTime + gap * 362, "F"),
//				new Beat(startTime + gap * 366, "S"),
//				new Beat(startTime + gap * 370, "D"),
//				new Beat(startTime + gap * 374, "F"),
//				new Beat(startTime + gap * 378, "S"),
//				new Beat(startTime + gap * 382, "Space"),
//				new Beat(startTime + gap * 386, "S"),
//				new Beat(startTime + gap * 392, "D"),
//				new Beat(startTime + gap * 395, "F"),
//				new Beat(startTime + gap * 401, "S"),
//				new Beat(startTime + gap * 409, "D"),
//				new Beat(startTime + gap * 413, "F"),
//				new Beat(startTime + gap * 417, "S"),
//				new Beat(startTime + gap * 421, "D"),
//				new Beat(startTime + gap * 425, "F"),
//				new Beat(startTime + gap * 429, "S"),
//				new Beat(startTime + gap * 433, "D"),
//				new Beat(startTime + gap * 437, "F"),
//				new Beat(startTime + gap * 441, "Space"),
		};
		
		return beats;
	}
}