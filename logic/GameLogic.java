package tr.org.linux.kamp.Agario.logic;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

import tr.org.linux.kamp.Agario.model.Chip;
import tr.org.linux.kamp.Agario.model.Difficulty;
import tr.org.linux.kamp.Agario.model.Enemy;
import tr.org.linux.kamp.Agario.model.GameObject;
import tr.org.linux.kamp.Agario.model.Mine;
import tr.org.linux.kamp.Agario.model.Player;
import tr.org.linux.kamp.Agario.view.GameFrame;
import tr.org.linux.kamp.Agario.view.GamePanel;

//intersects
//contains
/**
 * @author MerveY
 * @version 1.0
 * 
 * all motion software of Agario
 * Code part
 */

public class GameLogic {

	private boolean isGameRunning;
	private int xTarget;
	private int yTarget;
	
	private Player player;
	private Enemy enemy;
	private ArrayList<GameObject> gameObjects;
	ArrayList<GameObject> chipsToRemove;
	private ArrayList<GameObject> minesToRemove;
	private ArrayList<GameObject> enemiesToRemove;

	private GameFrame gameFrame;
	private GamePanel gamePanel;
	private Random random;
	
	/**
	 * 
	 * @param playerName
	 * @param selectedColor
	 * @param difficulty
	 */

	public GameLogic(String playerName, Color selectedColor, Difficulty difficulty) {

		random = new Random();

		// TODO Auto-generated constructor stub
		player = new Player(10, 10, 20, selectedColor, 3, playerName);

		gameObjects = new ArrayList<GameObject>();
		chipsToRemove = new ArrayList<GameObject>();
		minesToRemove = new ArrayList<GameObject>();
		enemiesToRemove = new ArrayList<GameObject>();

		gameObjects.add(player);

		gameFrame = new GameFrame();
		gamePanel = new GamePanel(gameObjects);
		
		
		/**
		 * According to select difficulty level determine number of chips, mine and enemy.
		 */
		
		switch (difficulty) {
		case EASY:

			fillChips(15);
			fillMine(7);
			fillEnemies(5);

			break;
		case NORMAL:

			fillChips(50);
			fillMine(10);
			fillEnemies(15);

			break;
		case HARD:

			fillChips(70);
			fillMine(15);
			fillEnemies(25);
			break;
		default:
			break;
		}

		addMouseEvents();

	}
	
	/**
	 * Create enemy 
	 * @param number // determine #of
	 * 
	 */

	private void fillEnemies(int number) {
		// TODO Auto-generated method stub

		for (int i = 0; i < number; i++) {

			Enemy enemy = new Enemy(random.nextInt(1980), random.nextInt(1020), (random.nextInt(15) + 15), 1,
					Color.red);
			while (player.getRectangle().intersects(enemy.getRectangle())) {

				enemy.setX(random.nextInt(1980));
				enemy.setY(random.nextInt(1020));

			}
			gameObjects.add(enemy);

		}
	}
	
	/**
	 * Create mine 
	 * @param number // determine #of
	 */

	private void fillMine(int number) {
		for (int i = 0; i < number; i++) {

			Mine mine = new Mine(random.nextInt(1980) + player.getX(), random.nextInt(1020) + player.getY(), 20,
					Color.GREEN);

			while (player.getRectangle().intersects(mine.getRectangle())) {

				mine.setX(random.nextInt(1980));
				mine.setY(random.nextInt(1020));

			}
			gameObjects.add(mine);

		}
	}
	
	/**
	 * Create chips 
	 * @param number // determine #of
	 * With random values colorful chips
	 */

	private void fillChips(int n) {

		for (int i = 0; i < n; i++) {
			int a = random.nextInt(9);
			
			if(a==0)
				gameObjects.add(new Chip(random.nextInt(1980), random.nextInt(1020), 10, Color.magenta));
			else if (a == 1)
				gameObjects.add(new Chip(random.nextInt(1980), random.nextInt(1020), 10, Color.cyan));
			else if (a == 2)
				gameObjects.add(new Chip(random.nextInt(1980), random.nextInt(1020), 10, Color.orange));
			else if (a == 3)
				gameObjects.add(new Chip(random.nextInt(1980), random.nextInt(1020), 10, Color.pink));
			else if (a == 4)
				gameObjects.add(new Chip(random.nextInt(1980), random.nextInt(1020), 10, Color.green));
			else if (a == 5)
				gameObjects.add(new Chip(random.nextInt(1980), random.nextInt(1020), 10, Color.yellow));
			else if (a == 6)
				gameObjects.add(new Chip(random.nextInt(1980), random.nextInt(1020), 10, Color.blue));
			else if (a == 7)
				gameObjects.add(new Chip(random.nextInt(1980), random.nextInt(1020), 10, Color.DARK_GRAY));
			else if (a == 8)
				gameObjects.add(new Chip(random.nextInt(1980), random.nextInt(1020), 10, Color.black));

		}

		/*
		 * for (int i = 0; i < n; i++) {
		 * 
		 * gameObject.add(new Chip(random.nextInt(1000), random.nextInt(1000), 10,
		 * Color.magenta)); }
		 */

	}
	
	/**
	 * Control to collisions between player-enemy-chip and mine
	 * 
	 * 
	 * 
	 */

	private synchronized void checkCollisions() {

		// objectsToRemove bu fonk işi bitirdiğinde yok olur. //
		// - baska metoda aktarılmadıgı surece

		for (GameObject gameObject2 : gameObjects) {

			if (player.getRectangle().intersects(gameObject2.getRectangle())) {
				// if (player.getRectangle().contains(gameObject2.getRectangle())) {

				/**
				 * if object chip;
				 */
				if (gameObject2 instanceof Chip) { // hangisi diye karısmasın dıye. ->chip ->mine ->player ->enemy

					player.setRadius(player.getRadius() + gameObject2.getRadius() / 3);
					// sıkıntı oluyor. o yüzden silinecekler listesi yap
					// gameObject.remove(gameObject2);
					chipsToRemove.add(gameObject2);

				} else if (gameObject2 instanceof Mine) {

					if (player.getRadius() > 15) {

						player.setRadius(player.getRadius() - gameObject2.getRadius());
						minesToRemove.add(gameObject2);

					}

				} 
				
				
				 else if (gameObject2 instanceof Enemy) {
				 
					if (player.getRadius() > gameObject2.getRadius()) {
						player.setRadius((int) player.getRadius() + gameObject2.getRadius());
						enemiesToRemove.add(gameObject2);

					} else if (player.getRadius() < gameObject2.getRadius()) {
						gameObject2.setRadius((gameObject2.getRadius()) + player.getRadius());
						// Game over
						isGameRunning = false;

					}

				}

			}
			
			

			if (gameObject2 instanceof Enemy) {

				Enemy enemy = (Enemy) gameObject2;

				for (GameObject gameObject3 : gameObjects) {

					if (enemy.getRectangle().intersects(gameObject3.getRectangle())) {

						if (gameObject3 instanceof Chip) {
							enemy.setRadius(enemy.getRadius() + gameObject3.getRadius());
							chipsToRemove.add(gameObject3);

						}
						if (gameObject3 instanceof Mine) {

							enemy.setRadius((int) enemy.getRadius() / 2);
							minesToRemove.add(gameObject3);

						}
					}

				}

			}

		}
		
		/**
		 * garbage list
		 */
		// loop is completed remove objects from the list
		gameObjects.removeAll(chipsToRemove);
		gameObjects.removeAll(minesToRemove);
		gameObjects.removeAll(enemiesToRemove);

	}
	
	/**
	 * between player and enemy direction commands
	 * enemy run or pursue
	 * 
	 */

	private synchronized void moveEnemies() {

		for (GameObject gameObject : gameObjects) {

			if (gameObject instanceof Enemy) {

				Enemy enemy = (Enemy) gameObject;//

				if (enemy.getRadius() < player.getRadius()) { // run

					int distance = (int) Point.distance(player.getX(), player.getY(), enemy.getX(), enemy.getY());

					int newX = enemy.getX() + enemy.getSpeed();
					int newY = enemy.getY() + enemy.getSpeed();

					if (calculateNewDistancetoEnemy(enemy, distance, newX, newY)) {
						continue;

					}

					newX = enemy.getX() + enemy.getSpeed();
					newY = enemy.getY() - enemy.getSpeed();

					if (calculateNewDistancetoEnemy(enemy, distance, newX, newY)) {
						continue;

					}

					newX = enemy.getX() - enemy.getSpeed();
					newY = enemy.getY() + enemy.getSpeed();

					if (calculateNewDistancetoEnemy(enemy, distance, newX, newY)) {
						continue;

					}
					newX = enemy.getX() - enemy.getSpeed();
					newY = enemy.getY() - enemy.getSpeed();

					if (calculateNewDistancetoEnemy(enemy, distance, newX, newY)) {
						continue;

					}

					newX = enemy.getX() + enemy.getSpeed();
					newY = enemy.getY() - 0;

					if (calculateNewDistancetoEnemy(enemy, distance, newX, newY)) {
						continue;

					}

				} else {// eat

					if (player.getX() > enemy.getX()) {
						enemy.setX(enemy.getX() + enemy.getSpeed());

					} else if (player.getX() < enemy.getX()) {
						enemy.setX(enemy.getX() - enemy.getSpeed());

					}

					if (player.getY() > enemy.getY()) {
						enemy.setY(enemy.getY() + enemy.getSpeed());
					} else if (player.getY() < enemy.getY()) {
						enemy.setY(enemy.getY() - enemy.getSpeed());

					}

				}
			}

		}

	}

	private boolean calculateNewDistancetoEnemy(Enemy enemy, int distance, int x, int y) {
		int newDistance = (int) Point.distance(player.getX(), player.getY(), x, y);

		if (newDistance > distance) {
			enemy.setX(x);
			enemy.setY(y);
			return true;

		}
		return false;

	}
	
	/**
	 * add new objects on game board
	 */

	private synchronized void addNewObjects() {

		fillMine(minesToRemove.size());
		minesToRemove.clear();

		fillChips(chipsToRemove.size());
		chipsToRemove.clear();

		fillEnemies(enemiesToRemove.size());
		enemiesToRemove.clear();

	}

	private synchronized void movePLayer() { // hiçbir thread aynı anda bunu yapmaya calısmayacak

		if (player.getX() < xTarget) {
			player.setX(player.getX() + player.getSpeed());
		} else if (player.getX() > xTarget) {
			player.setX(player.getX() - player.getSpeed());

		}

		if (player.getY() < yTarget) {
			player.setY(player.getY() + player.getSpeed());
		} else if (player.getY() > yTarget) {
			player.setY(player.getY() - player.getSpeed());

		}
	}

	public void startApplication() {
		gameFrame.setContentPane(gamePanel);
		isGameRunning = true;
		gameFrame.setVisible(true);
		startGame();

	}

	private void addMouseEvents() {

		gameFrame.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// pencerenin dısına cıktıgında

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				//

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		gameFrame.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub

				xTarget = e.getX();
				yTarget = e.getY();

			}

			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

	public void startGame() {
		// TODO Auto-generated method stub

		new Thread(new Runnable() { //

			@Override
			public void run() {
				// TODO Auto-generated method stub

				while (isGameRunning) {
					movePLayer(); // hareketettir
					moveEnemies();
					checkCollisions(); // hareketleri eşle
					addNewObjects();

					gamePanel.repaint();

					try {
						Thread.sleep(10);

					} catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}

			}
		}).start();

	}

}
