package fr.supinfo.java.entity;

import fr.supinfo.java.main.Main;
import fr.supinfo.java.physical.Collides;
import fr.supinfo.java.physical.Motor;

import javax.swing.*;
import java.util.Random;

public class Pacman extends JLabel {

    Random rand;

    int speed;
    int size = 3;

    boolean collided = false;

    //0 = left, 1 = top, 2 = right, 3 = down
    int dir = 0;
    int oldDir = 2;
    int tempDir = 0;
    int count = 0;
    int maxCount = 100;

    int eatTime = 2000;

    public Pacman(int x, int y, int speed) {
        rand = new Random();

        this.speed = speed;

        setLocation(x, y);
        setDirLeft();
    }

    public void onMove() {
        if (!collided) {
            if (dir == 0) {
                setLocation((int) getX() - speed, (int) getY());
                setDirLeft();
            } else if (dir == 1) {
                setLocation((int) getX(), (int) getY() - speed);
                setDirTop();
            } else if (dir == 2) {
                setLocation((int) getX() + speed, (int) getY());
                setDirRight();
            } else if (dir == 3) {
                setLocation((int) getX(), (int) getY() + speed);
                setDirBottom();
            }
            if (count == maxCount) {
                oldDir = dir;
                tempDir = rand.nextInt(4);

                if (tempDir == 0 && oldDir == 2) {
                    dir = oldDir;
                } else if (tempDir == 1 && oldDir == 3) {
                    dir = oldDir;
                } else if (tempDir == 2 && oldDir == 0) {
                    dir = oldDir;
                } else if (tempDir == 3 && oldDir == 1) {
                    dir = oldDir;
                } else {
                    dir = tempDir;
                }

                count = 0;
                maxCount = rand.nextInt(150 - 50 + 1) + 50;
            }
            count++;
        } else {
            count -= 10;
            if (dir == 0) {
                dir = 2;
                setLocation(getX() + speed, getY());
            } else if (dir == 1) {
                dir = 3;
                setLocation(getX(), getY() + speed);
            } else if (dir == 2) {
                dir = 0;
                setLocation(getX() - speed, getY());
            } else if (dir == 3) {
                dir = 1;
                setLocation(getX(), getY() - speed);
            }
        }
        eatTime--;
        if (eatTime < 1) {
            setGlobalSize(size-1);
            hasEat();
        }
    }

    public boolean getCollided() {
        return collided;
    }

    public void setCollided(boolean newCollided) {
        collided = newCollided;
    }

    public int getGlobalSize() {
        return size;
    }

    public void setGlobalSize(int newSize) {
        if (newSize < 6) {
            size = newSize;
            if (newSize == 5) {
                System.out.println("(!) Sifflement");
            }
            if (newSize == 0) {
                System.out.println("[!] Pacman dead !");
                Main.pbg.remove(this);
                Motor.pacmans.remove(this);
                System.out.println("PACMANS : " + Motor.pacmans.size());
            }
        }
    }

    public void hasEat() {
        eatTime = 2000;
    }

    public void setDirTop() {
        if (size == 1) {
            setSize(27, 27);
            setIcon(new ImageIcon(getClass().getResource("/imgs/pacman01/pacmanTop01.png")));
        } else if (size == 2) {
            setSize(41, 41);
            setIcon(new ImageIcon(getClass().getResource("/imgs/pacman02/pacmanTop02.png")));
        } else if (size == 3) {
            setSize(50, 50);
            setIcon(new ImageIcon(getClass().getResource("/imgs/pacman03/pacmanTop03.png")));
        } else if (size == 4) {
            setSize(58, 58);
            setIcon(new ImageIcon(getClass().getResource("/imgs/pacman04/pacmanTop04.png")));
        } else if (size == 5) {
            setSize(64, 64);
            setIcon(new ImageIcon(getClass().getResource("/imgs/pacman05/pacmanTop05.png")));
        }
    }

    public void setDirRight() {
        if (size == 1) {
            setSize(27, 27);
            setIcon(new ImageIcon(getClass().getResource("/imgs/pacman01/pacmanRight01.png")));
        } else if (size == 2) {
            setSize(41, 41);
            setIcon(new ImageIcon(getClass().getResource("/imgs/pacman02/pacmanRight02.png")));
        } else if (size == 3) {
            setSize(50, 50);
            setIcon(new ImageIcon(getClass().getResource("/imgs/pacman03/pacmanRight03.png")));
        } else if (size == 4) {
            setSize(58, 58);
            setIcon(new ImageIcon(getClass().getResource("/imgs/pacman04/pacmanRight04.png")));
        } else if (size == 5) {
            setSize(64, 64);
            setIcon(new ImageIcon(getClass().getResource("/imgs/pacman05/pacmanRight05.png")));
        }
    }

    public void setDirBottom() {
        if (size == 1) {
            setSize(27, 27);
            setIcon(new ImageIcon(getClass().getResource("/imgs/pacman01/pacmanBottom01.png")));
        } else if (size == 2) {
            setSize(41, 41);
            setIcon(new ImageIcon(getClass().getResource("/imgs/pacman02/pacmanBottom02.png")));
        } else if (size == 3) {
            setSize(50, 50);
            setIcon(new ImageIcon(getClass().getResource("/imgs/pacman03/pacmanBottom03.png")));
        } else if (size == 4) {
            setSize(58, 58);
            setIcon(new ImageIcon(getClass().getResource("/imgs/pacman04/pacmanBottom04.png")));
        } else if (size == 5) {
            setSize(64, 64);
            setIcon(new ImageIcon(getClass().getResource("/imgs/pacman05/pacmanBottom05.png")));
        }
    }

    public void setDirLeft() {
        if (size == 1) {
            setSize(27, 27);
            setIcon(new ImageIcon(getClass().getResource("/imgs/pacman01/pacmanLeft01.png")));
        } else if (size == 2) {
            setSize(41, 41);
            setIcon(new ImageIcon(getClass().getResource("/imgs/pacman02/pacmanLeft02.png")));
        } else if (size == 3) {
            setSize(50, 50);
            setIcon(new ImageIcon(getClass().getResource("/imgs/pacman03/pacmanLeft03.png")));
        } else if (size == 4) {
            setSize(58, 58);
            setIcon(new ImageIcon(getClass().getResource("/imgs/pacman04/pacmanLeft04.png")));
        } else if (size == 5) {
            setSize(64, 64);
            setIcon(new ImageIcon(getClass().getResource("/imgs/pacman05/pacmanLeft05.png")));
        }
    }

}