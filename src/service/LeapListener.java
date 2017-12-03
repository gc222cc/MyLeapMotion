package service;

import com.leapmotion.leap.*;
import entity.Letter;
import gui.FrameStartCommunication;
import gui.FrameSaveData;
import util.Knn;

import java.io.*;
import java.util.*;

public class LeapListener extends Listener {

	public static String[] guessLetters = new String[1000];
	public static int[] valueLetters = new int[100];
	public static boolean isPause = false;
	public static int userFrameCount;
	public static boolean isSaveLetter = true; // TODO asl?nda false olacak !!!1
	public static String userLetterName; // BUNU GUI DEN ALIYORUZ
	public static ArrayList<Letter> letterList = new ArrayList<>();
	TreeMap<String, Integer> sortedVoteList = new TreeMap<>();
	public int frameRate;
	private int unTouchFrameDataCount = 0;

	private Callback callback = new Callback() {

		@Override
		public void getLetterInfo(Letter letter) {

			synchronized (this) {
				
				letterList.add(letter);

				System.out.println("letterList size ==> " + letterList.size() );
				

				if (isSaveLetter==true) {
					if (letterList.size() == userFrameCount  ) {
						
						
						ArrayList<Letter> oldList = readFromFile(userLetterName);

						oldList.addAll(letterList);

						writeToFile(oldList);
					}

				}

				else

				{// TODO GUESS ?\u015eLEM?N? YAP

				
					FrameStartCommunication.labelInfo.setText("CAPTURING IN "+String.valueOf(userFrameCount-letterList.size()));
					
					
					if (letterList.size() % userFrameCount == 0) {
						// ArrayList<entity.Letter> allLetterList = readFromFile("A");

						ArrayList<Letter> allLetterList = new ArrayList<>();
					//	System.err.println("letterList size ==> " + letterList.size() );
						allLetterList.addAll(readFromFile("A"));
						allLetterList.addAll(readFromFile("B"));
						allLetterList.addAll(readFromFile("C"));
						allLetterList.addAll(readFromFile("Ç"));
						allLetterList.addAll(readFromFile("D"));
						allLetterList.addAll(readFromFile("E"));
						allLetterList.addAll(readFromFile("F"));
						allLetterList.addAll(readFromFile("G"));
						allLetterList.addAll(readFromFile("\u011e"));
						allLetterList.addAll(readFromFile("H"));
						allLetterList.addAll(readFromFile("I"));
						allLetterList.addAll(readFromFile("?"));
						allLetterList.addAll(readFromFile("J"));
						allLetterList.addAll(readFromFile("K"));
						allLetterList.addAll(readFromFile("L"));
						allLetterList.addAll(readFromFile("M"));
						allLetterList.addAll(readFromFile("N"));
						allLetterList.addAll(readFromFile("O"));
						allLetterList.addAll(readFromFile("Ö"));
						allLetterList.addAll(readFromFile("P"));
						allLetterList.addAll(readFromFile("R"));
						allLetterList.addAll(readFromFile("S"));
						allLetterList.addAll(readFromFile("\u015e"));
						allLetterList.addAll(readFromFile("T"));
						allLetterList.addAll(readFromFile("U"));
						allLetterList.addAll(readFromFile("Ü"));
						allLetterList.addAll(readFromFile("V"));
						allLetterList.addAll(readFromFile("Y"));
						allLetterList.addAll(readFromFile("Z"));
						allLetterList.addAll(readFromFile("SPACE"));
						allLetterList.addAll(readFromFile("x"));

				
						ArrayList<Double> averageCurrentFeatureList = new ArrayList<>();

						double[] toplam = new double[76];

						for (int i = 0; i < letterList.size(); i++) {

							for (int j = 0; j < 76; j++) {
								toplam[j] += ((double) letterList.get(i).getFeatureList().get(j));
								
							}

						}
						for (int j = 0; j < 76; j++) 
						{
							toplam[j] /= userFrameCount;
							// System.out.println(toplam[j]);
						}

						for (int i = 0; i < toplam.length; i++) {
							averageCurrentFeatureList.add(toplam[i]);

						}

						// KNN BURADA ÇALI\u015eIYOR

						sortedVoteList = Knn.nearestNeighbour(allLetterList, averageCurrentFeatureList);
						
						int i = 0;
						
						for (Map.Entry<String, Integer> entry : sortedVoteList.entrySet()) {
							String key = entry.getKey();
							Integer value = entry.getValue();
							guessLetters[i] = key;
							valueLetters[i]= value;
							System.out.println(key + " => " + value);
							i++;
						}
				
						FrameStartCommunication.lblResult1.setText(LeapListener.guessLetters[0]+" ---> "+ LeapListener.valueLetters[0]);
						if(guessLetters[1]!=null || valueLetters[1]!=0){
						FrameStartCommunication.lblResult2.setText(LeapListener.guessLetters[1]+" ---> "+ LeapListener.valueLetters[1]);
						}
						if(guessLetters[2]!=null || valueLetters[2]!=0 ){
						FrameStartCommunication.lblResult3.setText(LeapListener.guessLetters[2]+" ---> "+ LeapListener.valueLetters[2]);
						}
	    				
						if(LeapListener.guessLetters[0].equals("SPACE"))
	    					{
	    						FrameStartCommunication.res+=" ";
	    						
	    					}
	    				else{
						FrameStartCommunication.res  += LeapListener.guessLetters[0];
	    					
	    				}
						
	    				FrameStartCommunication.lblWord.setText(FrameStartCommunication.res);
						
						for (int j = 0; j < 30; j++) {
							guessLetters[j] = "";
							valueLetters[j]= 0;
						}
							letterList.clear();
							isPause=true;
						
							try {
							Thread.sleep(userFrameCount*1000);//TODO GUI DEN al?nacak
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							
							isPause=false;
							
					
					}
				}

			}
		
		}
	};

	public void writeToFile(ArrayList<Letter> list) {
		ObjectOutputStream outStream = null;

		try {
			outStream = new ObjectOutputStream(new FileOutputStream(userLetterName));
			for (Letter l : list) {

				outStream.writeObject(l);
			}

		} catch (IOException ioException) {
			System.err.println("Error opening file.");
		} catch (NoSuchElementException noSuchElementException) {
			System.err.println("Invalid input.");
		} finally {
			try {
				if (outStream != null)
					outStream.close();
			} catch (IOException ioException) {
				System.err.println("Error closing file.");
			}
		}
	}

	public static ArrayList<Letter> readFromFile(String fileName) {
		ArrayList<Letter> list = new ArrayList<>();

		ObjectInputStream inputStream = null;
		try {
			inputStream = new ObjectInputStream(new FileInputStream(fileName));
			while (true) {
				Letter l = (Letter) inputStream.readObject();
				list.add(l);

				// TODO GER? GELECEK System.out.println(l.getPersonName() + " "
				// + l.getLetterName() +" " + l.getLetterId());
			}
		} catch (EOFException eofException) {
			return list;
		} catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Object creation failed.");
		} catch (IOException ioException) {
			System.out.println(ioException.getMessage());
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException ioException) {
				System.err.println("Error closing file.");
			}
		}
		return list;
	}

	public void onInit(Controller controller) {
		System.out.println("Initialized");
	}

	public void onConnect(Controller controller) {
		System.out.println("Connected to Motion Sensor");

		controller.enableGesture(Gesture.Type.TYPE_SWIPE);
		controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
		controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
		controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);

		Runnable run = new Runnable() {
			public void run() {

				Scanner sc = new Scanner(System.in);
				while (sc.hasNext()) {
					sc.next();
					if (isPause) {
						System.err.println("false");
						isPause = false;

					} else {
						System.err.println("true");
						isPause = true;

					}
				}
			}
		};
		new Thread(run).start();

	}

	public void onDisconnect(Controller controller) {
		System.out.println("Motion Sensor Disconnected");
	}

	public void onExit(Controller controller) {
		System.out.println("Exited");
	}

	public void writeFrameToFile(final Frame frame) {
		synchronized (this) {
			if (unTouchFrameDataCount < userFrameCount) {
				unTouchFrameDataCount++;
				Runnable run = new Runnable() {
					public void run() {
						byte[] serializedFrame = frame.serialize();

						ObjectOutputStream outStream = null;

						try {
							File directory= new File("DATA");
							
							directory.mkdirs();
							File file = new File(directory,userLetterName + "_"
									+ FrameSaveData.userName + "_" + unTouchFrameDataCount + ".data");
							
							outStream = new ObjectOutputStream(new FileOutputStream(file));
						
							outStream.write(serializedFrame);

						} catch (IOException ioException) {
							System.err.println("Error opening file.");
						} catch (NoSuchElementException noSuchElementException) {
							System.err.println("Invalid input.");
						} finally {

							try {
								if (outStream != null)
									outStream.close();
							} catch (IOException ioException) {
								System.err.println("Error closing file.");
							}
						}

					}
				};
				new Thread(run).start();

			}

		}
	}

	public void onFrame(Controller controller) {

		final Frame frame = controller.frame();
		
		writeFrameToFile(frame);
		
		if (!isPause) {
			Runnable r = new MyThread(frame, callback);
			new Thread(r).start();
		}

		try {
			Thread.sleep(frameRate);
		} catch (InterruptedException e) { // TODO 3 SAN?YE BEKLETME  geri al bunu
			e.printStackTrace();
		}
	

	}

	public void pause() {
		isPause = true;
	}

	/**
	 * Resume the data tracking
	 */
	public void resume() {
		isPause = false;
	}

	long lastFrameID = 0;

	void processFrame(Frame frame) {
		if (frame.id() == lastFrameID)
			return;
		// ...
		lastFrameID = frame.id();
	}

	int lastProcessedFrameID = 0;

	void nextFrame(Controller controller) {
		long currentID = controller.frame().id();
		for (int history = 0; history < currentID - lastFrameID; history++) {
			processNextFrame(controller.frame(history));
		}
		lastFrameID = currentID;
	}

	void processNextFrame(Frame frame) {
		if (frame.isValid()) {

			for (Finger finger : frame.fingers()) {
				System.err.println("Finger Type : " + finger.type() + "   ID " + finger.id() + "   Finger Length(mm) "
						+ finger.length() + " Tip positon" + finger.tipPosition());

				for (Bone.Type boneType : Bone.Type.values()) {

					Bone bone = finger.bone(boneType);

					System.err.println("BoneType : " + bone.type() + "Start Bone :" + bone.prevJoint() + "End Bone : "
							+ bone.nextJoint() + "Direction : " + bone.direction());
				}

			}
		}
		// return The frame ID
	}
}