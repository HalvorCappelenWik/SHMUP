package inf112.shmup.view.actors;

import java.util.List;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

import inf112.shmup.app.ShmupGame;


public class EnemyFactory extends Actor {

    private List<Actor> enemyList;

    public EnemyFactory(List<Actor> enemyList, Stage stage){
        this.enemyList = enemyList;
        setStage(stage); //for some reason it thinks it has no stage

        getStage().addActor(new Enemy(ShmupGame.V_WIDTH/2, ShmupGame.V_HEIGHT - 100));
    }

    /**
     * @return Enemy list of the enemy factory
     */
    public List<Actor> getEnemyList(){
        return enemyList;
    }

    /**
     * Spawns an enemy instance
     * @param enemyInstance Enemy instance to spawn
     */
    public void spawnEnemy(Enemy enemyInstance){
        this.getStage().addActor(enemyInstance);
        enemyList.add(enemyInstance);
    }


    /**
     * Removes an enemy if it is found in the enemy list, and removes it from the list
     * @param enemyInstance The instance you want to remove
     * @exception IllegalArgumentExeption if the enemy was not in the enemy factories enemy list
     */
    public void killEnemy(Enemy enemyInstance){
        int i = 0;
        for(Actor e : enemyList){
            if(e == enemyInstance){
                enemyList.remove(i);
                enemyInstance.remove();
            }
            i++;
        }
        
        throw new IllegalArgumentException(String.format("Please remove an enemy that is within the enemy list. Attempted to remove %s", enemyInstance.getClass().getSimpleName()));
    }
}
