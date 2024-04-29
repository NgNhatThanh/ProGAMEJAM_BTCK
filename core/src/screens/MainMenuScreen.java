package screens;

import btck.com.MyGdxGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen  implements Screen {
    public static final int newGameWidth = 300;
    public static final int newGameHeight = 70;
    public static final int exitWidth = 120;
    public static final int exitHeight = 48;
    public static int WIDTH = Gdx.graphics.getWidth();
    public static int HEIGHT = Gdx.graphics.getHeight();
    MyGdxGame myGdxGame;

    Texture newGameActive;
    Texture newGameInactive;
    Texture exitInactive;
    Texture exitActive;
    public MainMenuScreen(MyGdxGame myGdxGame){
        this.myGdxGame = myGdxGame;
        newGameActive = new Texture("MainMenuScreen\\new game active.png");
        newGameInactive = new Texture("MainMenuScreen\\white new game.png");
        exitInactive = new Texture("MainMenuScreen\\exitInactive.png");
        exitActive = new Texture("MainMenuScreen\\exitActive.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1); // Màu xám trung bình
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        myGdxGame.batch.begin();

        int newGameX = (WIDTH - newGameWidth - 20);
        int newGameY = (HEIGHT - newGameHeight - 50);
        int exitX = newGameX + 10;
        int exitY = newGameY - 50;

        if(Gdx.input.getX() < newGameX + newGameWidth && Gdx.input.getX() > newGameX && MainMenuScreen.HEIGHT - Gdx.input.getY() < newGameY + newGameHeight && MainMenuScreen.HEIGHT - Gdx.input.getY() > newGameY){
            myGdxGame.batch.draw(newGameActive, newGameX, newGameY, newGameWidth, newGameHeight);
            if(Gdx.input.isTouched()){
                this.dispose();
                myGdxGame.setScreen(new IngameScreen(myGdxGame));
            }
        }else{
            myGdxGame.batch.draw(newGameInactive, newGameX, newGameY, newGameWidth, newGameHeight);
        }

        if(Gdx.input.getX() < exitX + exitWidth && Gdx.input.getX() > exitX && MainMenuScreen.HEIGHT - Gdx.input.getY() < exitY + newGameHeight && MainMenuScreen.HEIGHT - Gdx.input.getY() > exitY){
            myGdxGame.batch.draw(exitActive, exitX, exitY, exitWidth, exitHeight);
            if(Gdx.input.isTouched()){
                Gdx.app.exit();
            }
        }else{
            myGdxGame.batch.draw(exitInactive, exitX, exitY, exitWidth, exitHeight);
        }

        myGdxGame.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        this.newGameActive.dispose();
        this.newGameInactive.dispose();
        this.exitActive.dispose();
        this.exitInactive.dispose();
    }
}
