package robobase;

import robocode.*;
import robocode.Robot;

import java.awt.*;

/**
 * Created by aleksandarbabunovic on 2017-04-09.
 */
public class FireHorse extends AdvancedRobot {

    @Override
    public void run(){ //Runs once
        setColors(new Color(255,255,255),
                    new Color(255,255,255),
                new Color(255,255,255));

        /*
        setAdjustRadarForGunTurn(true);
        setAdjustRadarForRobotTurn(true);
        setAdjustGunForRobotTurn(true);
         */

        //body
        //gun
        //radar

        while(true){
            setAhead(90);
            setTurnLeft(Rules.MAX_TURN_RATE);
            execute();
        }

        /*/
        Advanced robot:
        man gör
        setFire
        setAhead

        ...

        execute();

        Robot:
        Kan bara göra en sak åt gången
         */
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent e){ //Runs when robot is within radar
        int fire;
        if(e.getDistance() > 200){
            fire = 1;
        } else if (e.getDistance() > 100) {
            fire = 2;
        } else {
            fire = 3;
        }

        /*
        Bearing:
        rakt framför : 0
        rakt höger : 90
        rakt vänster : - 90
        rakt bakom : 180 = -180
         */

        setTurnRight(e.getBearing());

        setFire(fire);
        System.out.println("Fire power:" + fire);
        execute();
        //100 hp
        //Every shot costs 3 hp
        //If shot hit enemy, returns 9 hp
    }

    @Override
    public void onPaint(Graphics2D g){

    }

    @Override
    public void onHitWall(HitWallEvent e){ //Runs when hit wall

    }
}
