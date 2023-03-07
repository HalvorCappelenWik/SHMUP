package inf112.shmup.view.actors;

import java.util.List;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class EnemyFactory extends Actor {

    private List<Actor> enemyList;
    private Stage stage;

    public EnemyFactory(List<Actor> enemyList, Stage stage){
        this.enemyList = enemyList; 
        this.stage = stage;
    }

    public void spawnEnemy(Enemy enemyInstance){
        stage.addActor(enemyInstance);
        enemyList.add(enemyInstance);
    }
    
    public List<Actor> getEnemyList(){
        return enemyList;
    }
}
