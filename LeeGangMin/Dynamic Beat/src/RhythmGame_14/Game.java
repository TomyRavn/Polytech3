package RhythmGame_14;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
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
				new Beat(startTime + gap * 19, "K"),
				new Beat(startTime + gap * 28, "J"),
				new Beat(startTime + gap * 31, "F"),
				new Beat(startTime + gap * 35, "K"),
				new Beat(startTime + gap * 39, "L"),
				new Beat(startTime + gap * 43, "K"),
				new Beat(startTime + gap * 47, "J"),
				new Beat(startTime + gap * 51, "K"),
				new Beat(startTime + gap * 55, "J"),
				new Beat(startTime + gap * 59, "Space"),
				new Beat(startTime + gap * 65, "S"),
				new Beat(startTime + gap * 74, "D"),
				new Beat(startTime + gap * 76, "F"),
				new Beat(startTime + gap * 80, "K"),
				new Beat(startTime + gap * 84, "J"),
				new Beat(startTime + gap * 89, "F"),
				new Beat(startTime + gap * 93, "K"),
				new Beat(startTime + gap * 99, "L"),
				new Beat(startTime + gap * 103, "K"),
				new Beat(startTime + gap * 107, "J"),
				new Beat(startTime + gap * 111, "K"),
				new Beat(startTime + gap * 115, "J"),
				new Beat(startTime + gap * 119, "D"),
				new Beat(startTime + gap * 123, "F"),
				new Beat(startTime + gap * 127, "Space"),
				new Beat(startTime + gap * 131, "S"),
				new Beat(startTime + gap * 138, "D"),
				new Beat(startTime + gap * 141, "F"),
				new Beat(startTime + gap * 148, "K"),
				new Beat(startTime + gap * 155, "J"),
				new Beat(startTime + gap * 159, "F"),
				new Beat(startTime + gap * 163, "K"),
				new Beat(startTime + gap * 167, "L"),
				new Beat(startTime + gap * 171, "K"),
				new Beat(startTime + gap * 175, "J"),
				new Beat(startTime + gap * 179, "K"),
				new Beat(startTime + gap * 183, "J"),
				new Beat(startTime + gap * 187, "Space"),
				new Beat(startTime + gap * 195, "S"),
				new Beat(startTime + gap * 200, "D"),
				new Beat(startTime + gap * 204, "F"),
				new Beat(startTime + gap * 207, "K"),
				new Beat(startTime + gap * 211, "J"),
				new Beat(startTime + gap * 218, "F"),
				new Beat(startTime + gap * 220, "K"),
				new Beat(startTime + gap * 225, "L"),
				new Beat(startTime + gap * 229, "K"),
				new Beat(startTime + gap * 233, "J"),
				new Beat(startTime + gap * 237, "K"),
				new Beat(startTime + gap * 241, "J"),
				new Beat(startTime + gap * 245, "F"),
				new Beat(startTime + gap * 250, "K"),
				new Beat(startTime + gap * 256, "Space"),
				new Beat(startTime + gap * 262, "D"),
				new Beat(startTime + gap * 265, "F"),
				new Beat(startTime + gap * 272, "D"),
				new Beat(startTime + gap * 277, "F"),
				new Beat(startTime + gap * 285, "J"),
				new Beat(startTime + gap * 289, "K"),
				new Beat(startTime + gap * 293, "Space"),
				new Beat(startTime + gap * 299, "Space"),
				new Beat(startTime + gap * 307, "Space"),
				new Beat(startTime + gap * 314, "Space"),
				new Beat(startTime + gap * 320, "S"),
				new Beat(startTime + gap * 329, "D"),
				new Beat(startTime + gap * 331, "F"),
				new Beat(startTime + gap * 335, "K"),
				new Beat(startTime + gap * 339, "J"),
				new Beat(startTime + gap * 344, "F"),
				new Beat(startTime + gap * 348, "K"),
				new Beat(startTime + gap * 354, "L"),
				new Beat(startTime + gap * 358, "K"),
				new Beat(startTime + gap * 362, "J"),
				new Beat(startTime + gap * 366, "F"),
				new Beat(startTime + gap * 370, "J"),
				new Beat(startTime + gap * 374, "K"),
				new Beat(startTime + gap * 378, "J"),
				new Beat(startTime + gap * 382, "Space"),
				new Beat(startTime + gap * 386, "S"),
				new Beat(startTime + gap * 392, "D"),
				new Beat(startTime + gap * 395, "F"),
				new Beat(startTime + gap * 401, "K"),
				new Beat(startTime + gap * 409, "J"),
				new Beat(startTime + gap * 413, "F"),
				new Beat(startTime + gap * 417, "K"),
				new Beat(startTime + gap * 421, "L"),
				new Beat(startTime + gap * 425, "K"),
				new Beat(startTime + gap * 429, "J"),
				new Beat(startTime + gap * 433, "K"),
				new Beat(startTime + gap * 437, "J"),
				new Beat(startTime + gap * 441, "Space"),
				new Beat(startTime + gap * 449, "F"),		//양손
				new Beat(startTime + gap * 454, "J"),
				new Beat(startTime + gap * 459, "F"),
				new Beat(startTime + gap * 464, "J"),
				new Beat(startTime + gap * 468, "F"),
				new Beat(startTime + gap * 472, "J"),
				new Beat(startTime + gap * 477, "F"),
				new Beat(startTime + gap * 482, "J"),
				new Beat(startTime + gap * 487, "F"),
				new Beat(startTime + gap * 492, "J"),
				new Beat(startTime + gap * 497, "D"),
				new Beat(startTime + gap * 501, "K"),
				new Beat(startTime + gap * 508, "D"),
				new Beat(startTime + gap * 513, "K"),
				new Beat(startTime + gap * 518, "D"),
				new Beat(startTime + gap * 523, "K"),
				new Beat(startTime + gap * 527, "D"),
				new Beat(startTime + gap * 531, "K"),
				new Beat(startTime + gap * 535, "D"),
				new Beat(startTime + gap * 539, "K"),
				new Beat(startTime + gap * 543, "S"),
				new Beat(startTime + gap * 547, "L"),
				new Beat(startTime + gap * 551, "S"),
				new Beat(startTime + gap * 555, "L"),
				new Beat(startTime + gap * 559, "S"),
				new Beat(startTime + gap * 563, "L"),
				new Beat(startTime + gap * 567, "S"),
				new Beat(startTime + gap * 571, "L"),
				new Beat(startTime + gap * 577, "Space"),
				new Beat(startTime + gap * 581, "J"),	//왼손 반주, 오른손 연주
				new Beat(startTime + gap * 587, "D"),
				new Beat(startTime + gap * 587, "J"),
				new Beat(startTime + gap * 595, "D"),
				new Beat(startTime + gap * 596, "K"),
				new Beat(startTime + gap * 598, "L"),
				new Beat(startTime + gap * 602, "K"),
				new Beat(startTime + gap * 603, "D"),
				new Beat(startTime + gap * 606, "J"),
				new Beat(startTime + gap * 611, "K"),
				new Beat(startTime + gap * 611, "D"),
				new Beat(startTime + gap * 615, "J"),
				new Beat(startTime + gap * 619, "D"),
				new Beat(startTime + gap * 621, "K"),
				new Beat(startTime + gap * 625, "L"),
				new Beat(startTime + gap * 627, "D"),
				new Beat(startTime + gap * 629, "K"),
				new Beat(startTime + gap * 633, "J"),
				new Beat(startTime + gap * 635, "D"),
				new Beat(startTime + gap * 637, "K"),
				new Beat(startTime + gap * 641, "J"),
				new Beat(startTime + gap * 643, "D"),
				new Beat(startTime + gap * 645, "K"),
				new Beat(startTime + gap * 649, "J"),
				new Beat(startTime + gap * 651, "D"),
				new Beat(startTime + gap * 653, "J"),	//4
				new Beat(startTime + gap * 659, "D"),
				new Beat(startTime + gap * 659, "K"),	//6
				new Beat(startTime + gap * 662, "L"),	//3
				new Beat(startTime + gap * 667, "D"),
				new Beat(startTime + gap * 668, "K"),	//6
				new Beat(startTime + gap * 675, "D"),
				new Beat(startTime + gap * 676, "J"),	//8
				new Beat(startTime + gap * 680, "K"),	//4
				new Beat(startTime + gap * 683, "D"),
				new Beat(startTime + gap * 684, "J"),	//4
				new Beat(startTime + gap * 688, "K"),	//4
				new Beat(startTime + gap * 691, "D"),
				new Beat(startTime + gap * 692, "L"),	//4
				new Beat(startTime + gap * 696, "K"),	//4
				new Beat(startTime + gap * 699, "D"),
				new Beat(startTime + gap * 700, "J"),	//4
				new Beat(startTime + gap * 704, "K"),	//4
				new Beat(startTime + gap * 707, "D"),
				new Beat(startTime + gap * 708, "Space"),
				new Beat(startTime + gap * 712, "J"),	//4
				new Beat(startTime + gap * 715, "D"),
				new Beat(startTime + gap * 718, "K"),	//6
				new Beat(startTime + gap * 721, "L"),	//3
				new Beat(startTime + gap * 723, "D"),
				new Beat(startTime + gap * 727, "K"),	//6
				new Beat(startTime + gap * 731, "D"),
				new Beat(startTime + gap * 735, "J"),	//8
				new Beat(startTime + gap * 739, "D"),
				new Beat(startTime + gap * 739, "K"),	//4
				new Beat(startTime + gap * 743, "J"),	//4
				new Beat(startTime + gap * 747, "K"),	//4
				new Beat(startTime + gap * 747, "D"),
				new Beat(startTime + gap * 751, "L"),	//4
				new Beat(startTime + gap * 755, "K"),	//4
				new Beat(startTime + gap * 755, "D"),
				new Beat(startTime + gap * 759, "J"),	//4
				new Beat(startTime + gap * 763, "K"),	//4
				new Beat(startTime + gap * 763, "D"),
				new Beat(startTime + gap * 767, "J"),
				new Beat(startTime + gap * 771, "J"),	//4
				new Beat(startTime + gap * 771, "D"),
				new Beat(startTime + gap * 777, "K"),	//6
				new Beat(startTime + gap * 779, "D"),
				new Beat(startTime + gap * 780, "L"),	//3
				new Beat(startTime + gap * 786, "K"),	//6
				new Beat(startTime + gap * 787, "D"),
				new Beat(startTime + gap * 794, "J"),	//8
				new Beat(startTime + gap * 795, "D"),
				new Beat(startTime + gap * 798, "K"),	//4
				new Beat(startTime + gap * 802, "J"),	//4
				new Beat(startTime + gap * 803, "D"),
				new Beat(startTime + gap * 806, "K"),	//4
				new Beat(startTime + gap * 810, "L"),	//4
				new Beat(startTime + gap * 811, "D"),
				new Beat(startTime + gap * 814, "K"),	//4
				new Beat(startTime + gap * 818, "J"),	//4
				new Beat(startTime + gap * 819, "D"),
				new Beat(startTime + gap * 822, "K"),	//4
				new Beat(startTime + gap * 826, "J"),
				new Beat(startTime + gap * 827, "D"),
				new Beat(startTime + gap * 830, "J"),	//4			
				new Beat(startTime + gap * 835, "D"),
				new Beat(startTime + gap * 836, "K"),	//6
				new Beat(startTime + gap * 839, "L"),	//3
				new Beat(startTime + gap * 843, "D"),
				new Beat(startTime + gap * 845, "K"),	//6
				new Beat(startTime + gap * 851, "D"),
				new Beat(startTime + gap * 853, "J"),	//8
				new Beat(startTime + gap * 857, "K"),	//4
				new Beat(startTime + gap * 859, "D"),
				new Beat(startTime + gap * 861, "J"),	//4
				new Beat(startTime + gap * 865, "K"),	//4
				new Beat(startTime + gap * 867, "D"),
				new Beat(startTime + gap * 869, "L"),	//4
				new Beat(startTime + gap * 873, "K"),	//4
				new Beat(startTime + gap * 875, "D"),
				new Beat(startTime + gap * 877, "J"),	//4
				new Beat(startTime + gap * 881, "K"),	//4
				new Beat(startTime + gap * 883, "D"),
				new Beat(startTime + gap * 885, "J"),
				new Beat(startTime + gap * 889, "J"),	//4
				new Beat(startTime + gap * 891, "D"),
				new Beat(startTime + gap * 895, "K"),	//6
				new Beat(startTime + gap * 898, "L"),	//3
				new Beat(startTime + gap * 899, "D"),
				new Beat(startTime + gap * 904, "K"),	//6
				new Beat(startTime + gap * 907, "D"),
				new Beat(startTime + gap * 912, "J"),	//8
				new Beat(startTime + gap * 915, "D"),
				new Beat(startTime + gap * 916, "K"),	//4
				new Beat(startTime + gap * 920, "J"),	//4
				new Beat(startTime + gap * 923, "D"),
				new Beat(startTime + gap * 924, "K"),	//4
				new Beat(startTime + gap * 928, "L"),	//4
				new Beat(startTime + gap * 931, "D"),
				new Beat(startTime + gap * 932, "K"),	//4
				new Beat(startTime + gap * 936, "J"),	//4
				new Beat(startTime + gap * 939, "D"),
				new Beat(startTime + gap * 940, "K"),	//4
				new Beat(startTime + gap * 944, "J"),
				new Beat(startTime + gap * 947, "D"),
				new Beat(startTime + gap * 948, "J"),	//4
				new Beat(startTime + gap * 954, "K"),	//6
				new Beat(startTime + gap * 955, "D"),
				new Beat(startTime + gap * 957, "L"),	//3
				new Beat(startTime + gap * 963, "K"),	//6
				new Beat(startTime + gap * 963, "D"),
				new Beat(startTime + gap * 971, "J"),	//8
				new Beat(startTime + gap * 971, "D"),
				new Beat(startTime + gap * 975, "K"),	//4
				new Beat(startTime + gap * 979, "J"),	//4
				new Beat(startTime + gap * 979, "D"),
				new Beat(startTime + gap * 983, "K"),	//4
				new Beat(startTime + gap * 987, "L"),	//4
				new Beat(startTime + gap * 987, "D"),
				new Beat(startTime + gap * 991, "K"),	//4
				new Beat(startTime + gap * 995, "J"),	//4
				new Beat(startTime + gap * 995, "D"),
				new Beat(startTime + gap * 999, "K"),	//4
				new Beat(startTime + gap * 1003, "J"),
				new Beat(startTime + gap * 1003, "D"),
				new Beat(startTime + gap * 1007, "J"),	//4
				new Beat(startTime + gap * 1011, "D"),
				new Beat(startTime + gap * 1013, "K"),	//6
				new Beat(startTime + gap * 1015, "L"),	//3
				new Beat(startTime + gap * 1019, "D"),
				new Beat(startTime + gap * 1021, "K"),	//6
				new Beat(startTime + gap * 1027, "D"),
				new Beat(startTime + gap * 1029, "J"),	//8
				new Beat(startTime + gap * 1033, "K"),	//4
				new Beat(startTime + gap * 1035, "D"),
				new Beat(startTime + gap * 1037, "J"),	//4
				new Beat(startTime + gap * 1041, "K"),	//4
				new Beat(startTime + gap * 1043, "D"),
				new Beat(startTime + gap * 1045, "L"),	//4
				new Beat(startTime + gap * 1049, "K"),	//4
				new Beat(startTime + gap * 1051, "D"),
				new Beat(startTime + gap * 1053, "J"),	//4
				new Beat(startTime + gap * 1057, "K"),	//4
				new Beat(startTime + gap * 1059, "D"),
				new Beat(startTime + gap * 1061, "J"),
				new Beat(startTime + gap * 1065, "J"),	//4
				new Beat(startTime + gap * 1067, "D"),
				new Beat(startTime + gap * 1071, "K"),	//6
				new Beat(startTime + gap * 1074, "L"),	//3
				new Beat(startTime + gap * 1075, "D"),
				new Beat(startTime + gap * 1080, "K"),	//6
				new Beat(startTime + gap * 1083, "D"),
				new Beat(startTime + gap * 1088, "J"),	//8
				new Beat(startTime + gap * 1091, "D"),
				new Beat(startTime + gap * 1092, "K"),	//4
				new Beat(startTime + gap * 1096, "J"),	//4
				new Beat(startTime + gap * 1099, "D"),
				new Beat(startTime + gap * 1100, "K"),	//4
				new Beat(startTime + gap * 1104, "L"),	//4
				new Beat(startTime + gap * 1107, "D"),
				new Beat(startTime + gap * 1108, "K"),	//4
				new Beat(startTime + gap * 1112, "J"),	//4
				new Beat(startTime + gap * 1115, "D"),
				new Beat(startTime + gap * 1116, "K"),	//4
				new Beat(startTime + gap * 1120, "J"),
				new Beat(startTime + gap * 1123, "D"),
				new Beat(startTime + gap * 1124, "J"),	//4
				new Beat(startTime + gap * 1130, "K"),	//6
				new Beat(startTime + gap * 1131, "D"),
				new Beat(startTime + gap * 1133, "L"),	//3
				new Beat(startTime + gap * 1139, "K"),	//6
				new Beat(startTime + gap * 1139, "D"),
				new Beat(startTime + gap * 1147, "J"),	//8
				new Beat(startTime + gap * 1147, "D"),
				new Beat(startTime + gap * 1151, "K"),	//4
				new Beat(startTime + gap * 1155, "J"),	//4
				new Beat(startTime + gap * 1155, "D"),
				new Beat(startTime + gap * 1159, "K"),	//4
				new Beat(startTime + gap * 1163, "L"),	//4
				new Beat(startTime + gap * 1163, "D"),
				new Beat(startTime + gap * 1167, "K"),	//4
				new Beat(startTime + gap * 1171, "J"),	//4
				new Beat(startTime + gap * 1171, "D"),
				new Beat(startTime + gap * 1175, "K"),	//4
				new Beat(startTime + gap * 1179, "J"),
				new Beat(startTime + gap * 1179, "D"),
				new Beat(startTime + gap * 1183, "J"),	//4
				new Beat(startTime + gap * 1187, "D"),
				new Beat(startTime + gap * 1189, "K"),	//6
				new Beat(startTime + gap * 1192, "L"),	//3
				new Beat(startTime + gap * 1195, "D"),
				new Beat(startTime + gap * 1198, "K"),	//6
				new Beat(startTime + gap * 1203, "D"),
				new Beat(startTime + gap * 1206, "J"),	//8
				new Beat(startTime + gap * 1210, "K"),	//4
				new Beat(startTime + gap * 1211, "D"),
				new Beat(startTime + gap * 1214, "J"),	//4
				new Beat(startTime + gap * 1218, "K"),	//4
				new Beat(startTime + gap * 1219, "D"),
				new Beat(startTime + gap * 1222, "L"),	//4
				new Beat(startTime + gap * 1226, "K"),	//4
				new Beat(startTime + gap * 1227, "D"),
				new Beat(startTime + gap * 1230, "J"),	//4
				new Beat(startTime + gap * 1234, "K"),	//4
				new Beat(startTime + gap * 1235, "D"),
				new Beat(startTime + gap * 1239, "J"),
				new Beat(startTime + gap * 1243, "J"),	//4
				new Beat(startTime + gap * 1243, "D"),
				new Beat(startTime + gap * 1249, "K"),	//6
				new Beat(startTime + gap * 1252, "L"),	//3
				new Beat(startTime + gap * 1251, "D"),
				new Beat(startTime + gap * 1258, "K"),	//6
				new Beat(startTime + gap * 1259, "D"),
				new Beat(startTime + gap * 1266, "J"),	//8
				new Beat(startTime + gap * 1267, "D"),
				new Beat(startTime + gap * 1270, "K"),	//4
				new Beat(startTime + gap * 1274, "J"),	//4
				new Beat(startTime + gap * 1275, "D"),
				new Beat(startTime + gap * 1278, "K"),	//4
				new Beat(startTime + gap * 1282, "L"),	//4
				new Beat(startTime + gap * 1283, "D"),
				new Beat(startTime + gap * 1286, "K"),	//4
				new Beat(startTime + gap * 1290, "J"),	//4
				new Beat(startTime + gap * 1294, "K"),	//4
				new Beat(startTime + gap * 1291, "D"),
				new Beat(startTime + gap * 1298, "J"),
				new Beat(startTime + gap * 1299, "D"),
				new Beat(startTime + gap * 1302, "J"),	//4
				new Beat(startTime + gap * 1307, "D"),
				new Beat(startTime + gap * 1308, "K"),	//6
				new Beat(startTime + gap * 1311, "L"),	//3
				new Beat(startTime + gap * 1315, "D"),
				new Beat(startTime + gap * 1317, "K"),	//6
				new Beat(startTime + gap * 1323, "D"),
				new Beat(startTime + gap * 1325, "J"),	//8
				new Beat(startTime + gap * 1329, "K"),	//4
				new Beat(startTime + gap * 1331, "D"),
				new Beat(startTime + gap * 1333, "J"),	//4
				new Beat(startTime + gap * 1337, "K"),	//4
				new Beat(startTime + gap * 1339, "D"),
				new Beat(startTime + gap * 1341, "L"),	//4
				new Beat(startTime + gap * 1345, "K"),	//4
				new Beat(startTime + gap * 1347, "D"),
				new Beat(startTime + gap * 1349, "J"),	//4
				new Beat(startTime + gap * 1353, "K"),	//4
				new Beat(startTime + gap * 1355, "D"),
				new Beat(startTime + gap * 1363, "D"),
				new Beat(startTime + gap * 1371, "D"),
				new Beat(startTime + gap * 1379, "D"),
				new Beat(startTime + gap * 1387, "D"),
				new Beat(startTime + gap * 1395, "D"),
				new Beat(startTime + gap * 1401, "Space"),
				
				
				//오른손
//				new Beat(startTime + gap * 587, "J"),	//320
//				new Beat(startTime + gap * 596, "K"),
//				new Beat(startTime + gap * 598, "L"),
//				new Beat(startTime + gap * 602, "K"),
//				new Beat(startTime + gap * 606, "L"),
//				new Beat(startTime + gap * 611, "L"),
//				new Beat(startTime + gap * 615, "K"),
//				new Beat(startTime + gap * 621, "K"),
//				new Beat(startTime + gap * 625, "L"),
//				new Beat(startTime + gap * 629, "K"),
//				new Beat(startTime + gap * 633, "L"),
//				new Beat(startTime + gap * 637, "K"),
//				new Beat(startTime + gap * 641, "J"),
//				new Beat(startTime + gap * 645, "K"),
				
//				new Beat(startTime + gap * 649, "Space"),
//				new Beat(startTime + gap * 653, "J"),
//				new Beat(startTime + gap * 659, "K"),
//				new Beat(startTime + gap * 662, "L"),
//				new Beat(startTime + gap * 668, "K"),
//				new Beat(startTime + gap * 676, "L"),
//				new Beat(startTime + gap * 680, "L"),
//				new Beat(startTime + gap * 684, "K"),
//				new Beat(startTime + gap * 688, "K"),
//				new Beat(startTime + gap * 692, "L"),
//				new Beat(startTime + gap * 696, "K"),
//				new Beat(startTime + gap * 700, "L"),
//				new Beat(startTime + gap * 704, "K"),
//				new Beat(startTime + gap * 708, "Space"),
				
				
				
				
				//Hard
//				new Beat(startTime + gap * 583, "S"),
//				new Beat(startTime + gap * 587, "D"),
//				new Beat(startTime + gap * 587, "J"),
//				new Beat(startTime + gap * 591, "F"),
//				new Beat(startTime + gap * 595, "S"),
//				new Beat(startTime + gap * 596, "K"),
//				new Beat(startTime + gap * 598, "L"),
//				new Beat(startTime + gap * 599, "D"),
//				new Beat(startTime + gap * 602, "K"),
//				new Beat(startTime + gap * 603, "F"),
//				new Beat(startTime + gap * 606, "L"),
//				new Beat(startTime + gap * 607, "S"),
//				new Beat(startTime + gap * 611, "D"),
//				new Beat(startTime + gap * 611, "L"),
//				new Beat(startTime + gap * 615, "F"),
//				new Beat(startTime + gap * 615, "K"),
//				new Beat(startTime + gap * 619, "S"),
//				new Beat(startTime + gap * 621, "K"),
//				new Beat(startTime + gap * 623, "D"),
//				new Beat(startTime + gap * 625, "L"),
//				new Beat(startTime + gap * 627, "F"),
//				new Beat(startTime + gap * 629, "K"),
//				new Beat(startTime + gap * 631, "S"),
//				new Beat(startTime + gap * 633, "L"),
//				new Beat(startTime + gap * 635, "D"),
//				new Beat(startTime + gap * 637, "K"),
//				new Beat(startTime + gap * 639, "F"),
//				new Beat(startTime + gap * 641, "J"),
//				new Beat(startTime + gap * 643, "S"),
//				new Beat(startTime + gap * 645, "K"),
//				new Beat(startTime + gap * 647, "D"),
//				new Beat(startTime + gap * 649, "Space"),
//				new Beat(startTime + gap * 651, "F"),
//				new Beat(startTime + gap * 653, "J"),
//				new Beat(startTime + gap * 655, "S"),
//				new Beat(startTime + gap * 659, "D"),
//				new Beat(startTime + gap * 659, "K"),
//				new Beat(startTime + gap * 662, "L"),
//				new Beat(startTime + gap * 663, "F"),
//				new Beat(startTime + gap * 667, "S"),
//				new Beat(startTime + gap * 668, "K"),
//				new Beat(startTime + gap * 671, "D"),
//				new Beat(startTime + gap * 675, "F"),
//				new Beat(startTime + gap * 676, "L"),
//				new Beat(startTime + gap * 679, "S"),
//				new Beat(startTime + gap * 680, "L"),
//				new Beat(startTime + gap * 683, "D"),
//				new Beat(startTime + gap * 684, "K"),
//				new Beat(startTime + gap * 687, "F"),
//				new Beat(startTime + gap * 688, "K"),
//				new Beat(startTime + gap * 691, "S"),
//				new Beat(startTime + gap * 692, "L"),
//				new Beat(startTime + gap * 695, "D"),
//				new Beat(startTime + gap * 696, "K"),
//				new Beat(startTime + gap * 699, "F"),
//				new Beat(startTime + gap * 700, "L"),
//				new Beat(startTime + gap * 703, "S"),
//				new Beat(startTime + gap * 704, "K"),
//				new Beat(startTime + gap * 707, "D"),
//				new Beat(startTime + gap * 708, "Space"),
//				new Beat(startTime + gap * 711, "F"),
//				new Beat(startTime + gap * 715, "S"),
//				new Beat(startTime + gap * 719, "D"),
//				new Beat(startTime + gap * 723, "F"),
//				new Beat(startTime + gap * 727, "S"),
//				new Beat(startTime + gap * 731, "D"),
//				new Beat(startTime + gap * 735, "F"),
//				new Beat(startTime + gap * 739, "S"),
//				new Beat(startTime + gap * 743, "D"),
//				new Beat(startTime + gap * 747, "F"),
//				new Beat(startTime + gap * 751, "S"),
//				new Beat(startTime + gap * 755, "D"),
//				new Beat(startTime + gap * 759, "F"),
//				new Beat(startTime + gap * 763, "S"),
//				new Beat(startTime + gap * 767, "D"),
//				new Beat(startTime + gap * 771, "F"),
//				new Beat(startTime + gap * 775, "S"),
//				new Beat(startTime + gap * 779, "D"),
//				new Beat(startTime + gap * 783, "F"),
//				new Beat(startTime + gap * 787, "S"),
//				new Beat(startTime + gap * 793, "D"),
//				new Beat(startTime + gap * 797, "F"),
//				new Beat(startTime + gap * 801, "S"),
//				new Beat(startTime + gap * 805, "D"),
//				new Beat(startTime + gap * 809, "F"),
//				new Beat(startTime + gap * 813, "S"),
//				new Beat(startTime + gap * 817, "D"),
//				new Beat(startTime + gap * 821, "F"),
//				new Beat(startTime + gap * 825, "S"),
//				new Beat(startTime + gap * 829, "D"),
//				new Beat(startTime + gap * 833, "F"),
//				new Beat(startTime + gap * 837, "S"),
//				new Beat(startTime + gap * 841, "D"),
//				new Beat(startTime + gap * 845, "F"),
//				new Beat(startTime + gap * 849, "S"),
//				new Beat(startTime + gap * 853, "D"),
//				new Beat(startTime + gap * 857, "F"),
//				new Beat(startTime + gap * 861, "S"),
//				new Beat(startTime + gap * 865, "D"),
//				new Beat(startTime + gap * 869, "F"),
//				new Beat(startTime + gap * 873, "S"),
//				new Beat(startTime + gap * 877, "D"),
//				new Beat(startTime + gap * 881, "F"),
//				new Beat(startTime + gap * 885, "S"),
//				new Beat(startTime + gap * 889, "D"),
//				new Beat(startTime + gap * 893, "F"),
//				new Beat(startTime + gap * 897, "S"),
//				new Beat(startTime + gap * 901, "D"),
//				new Beat(startTime + gap * 905, "F"),
//				new Beat(startTime + gap * 909, "S"),
//				new Beat(startTime + gap * 913, "D"),
//				new Beat(startTime + gap * 917, "F"),
//				new Beat(startTime + gap * 921, "S"),
//				new Beat(startTime + gap * 925, "D"),
//				new Beat(startTime + gap * 929, "F"),
//				new Beat(startTime + gap * 933, "S"),
//				new Beat(startTime + gap * 937, "D"),
//				new Beat(startTime + gap * 941, "F"),
//				new Beat(startTime + gap * 945, "S"),
//				new Beat(startTime + gap * 949, "D"),
//				new Beat(startTime + gap * 953, "F"),
//				new Beat(startTime + gap * 957, "S"),
//				new Beat(startTime + gap * 961, "D"),
//				new Beat(startTime + gap * 965, "F"),
//				new Beat(startTime + gap * 969, "S"),
//				new Beat(startTime + gap * 973, "D"),
//				new Beat(startTime + gap * 977, "F"),
//				new Beat(startTime + gap * 981, "S"),
//				new Beat(startTime + gap * 985, "D"),
//				new Beat(startTime + gap * 989, "F"),
//				new Beat(startTime + gap * 993, "S"),
//				new Beat(startTime + gap * 997, "D"),
//				new Beat(startTime + gap * 1001, "F"),
//				new Beat(startTime + gap * 1005, "S"),
//				new Beat(startTime + gap * 1009, "D"),
//				new Beat(startTime + gap * 1013, "F"),
//				new Beat(startTime + gap * 1017, "S"),
//				new Beat(startTime + gap * 1021, "D"),
//				new Beat(startTime + gap * 1025, "F"),
//				new Beat(startTime + gap * 1029, "S"),
//				new Beat(startTime + gap * 1033, "D"),
//				new Beat(startTime + gap * 1037, "F"),
//				new Beat(startTime + gap * 1041, "S"),
//				new Beat(startTime + gap * 1045, "D"),
//				new Beat(startTime + gap * 1049, "F"),
//				new Beat(startTime + gap * 1053, "S"),
//				new Beat(startTime + gap * 1057, "D"),
//				new Beat(startTime + gap * 1061, "F"),
//				new Beat(startTime + gap * 1065, "S"),
//				new Beat(startTime + gap * 1069, "D"),
//				new Beat(startTime + gap * 1073, "F"),
//				new Beat(startTime + gap * 1077, "S"),
//				new Beat(startTime + gap * 1081, "D"),
//				new Beat(startTime + gap * 1085, "F"),
//				new Beat(startTime + gap * 1089, "S"),
//				new Beat(startTime + gap * 1093, "D"),
//				new Beat(startTime + gap * 1097, "F"),
//				new Beat(startTime + gap * 1101, "S"),
//				new Beat(startTime + gap * 1105, "D"),
//				new Beat(startTime + gap * 1109, "F"),
//				new Beat(startTime + gap * 1113, "S"),
//				new Beat(startTime + gap * 1117, "D"),
//				new Beat(startTime + gap * 1121, "F"),
//				new Beat(startTime + gap * 1125, "S"),
//				new Beat(startTime + gap * 1129, "D"),
//				new Beat(startTime + gap * 1133, "F"),
//				new Beat(startTime + gap * 1137, "S"),
//				new Beat(startTime + gap * 1141, "D"),
//				new Beat(startTime + gap * 1145, "F"),
//				new Beat(startTime + gap * 1149, "S"),
//				new Beat(startTime + gap * 1153, "D"),
//				new Beat(startTime + gap * 1157, "F"),
//				new Beat(startTime + gap * 1161, "S"),
//				new Beat(startTime + gap * 1165, "D"),
//				new Beat(startTime + gap * 1169, "F"),
//				new Beat(startTime + gap * 1173, "S"),
//				new Beat(startTime + gap * 1177, "D"),
//				new Beat(startTime + gap * 1181, "F"),
//				new Beat(startTime + gap * 1185, "S"),
//				new Beat(startTime + gap * 1189, "D"),
//				new Beat(startTime + gap * 1193, "F"),
//				new Beat(startTime + gap * 1197, "S"),
//				new Beat(startTime + gap * 1201, "D"),
//				new Beat(startTime + gap * 1205, "F"),
//				new Beat(startTime + gap * 1209, "S"),
//				new Beat(startTime + gap * 1213, "D"),
//				new Beat(startTime + gap * 1217, "F"),
//				new Beat(startTime + gap * 1221, "S"),
//				new Beat(startTime + gap * 1225, "D"),
//				new Beat(startTime + gap * 1229, "F"),
//				new Beat(startTime + gap * 1233, "S"),
//				new Beat(startTime + gap * 1237, "D"),
//				new Beat(startTime + gap * 1241, "F"),
//				new Beat(startTime + gap * 1245, "S"),
//				new Beat(startTime + gap * 1249, "D"),
//				new Beat(startTime + gap * 1253, "F"),
//				new Beat(startTime + gap * 1257, "S"),
//				new Beat(startTime + gap * 1261, "D"),
//				new Beat(startTime + gap * 1265, "F"),
//				new Beat(startTime + gap * 1269, "S"),
//				new Beat(startTime + gap * 1273, "D"),
//				new Beat(startTime + gap * 1277, "F"),
//				new Beat(startTime + gap * 1281, "S"),
//				new Beat(startTime + gap * 1285, "D"),
//				new Beat(startTime + gap * 1289, "F"),
//				new Beat(startTime + gap * 1293, "S"),
//				new Beat(startTime + gap * 1297, "D"),
//				new Beat(startTime + gap * 1301, "F"),
//				new Beat(startTime + gap * 1305, "S"),
//				new Beat(startTime + gap * 1309, "D"),
//				new Beat(startTime + gap * 1313, "F"),
//				new Beat(startTime + gap * 1317, "S"),
//				new Beat(startTime + gap * 1321, "D"),
//				new Beat(startTime + gap * 1325, "F"),
//				new Beat(startTime + gap * 1329, "S"),
//				new Beat(startTime + gap * 1333, "D"),
//				new Beat(startTime + gap * 1337, "F"),
//				new Beat(startTime + gap * 1341, "S"),
//				new Beat(startTime + gap * 1345, "D"),
//				new Beat(startTime + gap * 1349, "F"),
//				new Beat(startTime + gap * 1353, "S"),
//				new Beat(startTime + gap * 1357, "D"),
//				new Beat(startTime + gap * 1361, "F"),
//				new Beat(startTime + gap * 1365, "S"),
//				new Beat(startTime + gap * 1369, "D"),
//				new Beat(startTime + gap * 1373, "F"),
//				new Beat(startTime + gap * 1377, "S"),
//				new Beat(startTime + gap * 1381, "D"),
//				new Beat(startTime + gap * 1385, "F"),
//				new Beat(startTime + gap * 1389, "S"),
//				new Beat(startTime + gap * 1393, "D"),
//				new Beat(startTime + gap * 1397, "F"),
//				new Beat(startTime + gap * 1401, "Space"),
		};
		
		return beats;
	}
}