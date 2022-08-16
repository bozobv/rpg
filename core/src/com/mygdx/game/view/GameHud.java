package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.managers.ResourceManager;
import com.mygdx.game.Settings;
import com.mygdx.game.World;
import com.mygdx.game.view.camera.OrthoCamera;
import com.mygdx.game.view.viewElements.Joystick;
import com.mygdx.game.view.viewElements.drawables.buttons.PictureButton;
import com.mygdx.game.view.io.InputController;
import com.mygdx.game.view.screens.GameScreen;

public class GameHud {

    //private static final Drawable blankTile = ResourceManager.getInstance().getDrawable("blankTile");
    //private static final Texture heartTexture = ResourceManager.getInstance().getTexture("heart");

    private Joystick moveControl;
    private Stage stage;
    private SpriteBatch stageSb, sb;
    private OrthoCamera camera;
    private World world;
    private Texture bg;
    private PictureButton attackBtn, skill1Btn;

    //private PictureButton inventoryBtn = new PictureButton(ResourceManager.getInstance().getDrawable("inventoryBtn"), 20 + (InventoryBox.bg.getWidth() + 7) * 5, Settings.getHeight() - InventoryBox.bg.getHeight() - 10);

    private GameScreen gameScreen;

    public GameHud(GameScreen gameScreen, World world) {
        this.gameScreen = gameScreen;

        bg = ResourceManager.getInstance().getTexture("bg");

        this.world = world;
        stageSb = new SpriteBatch();
        sb = new SpriteBatch();
        stage = new Stage(new StretchViewport(Settings.getWidth(), Settings.getHeight()), stageSb);
        moveControl = new Joystick(ResourceManager.getInstance().getTexture("joystickBg"), ResourceManager.getInstance().getTexture("joystickKnob"), 9, 20, 20, 200, 200);
        attackBtn = new PictureButton(ResourceManager.getInstance().getDrawable("btnAttack"),  Settings.getWidth()- 128, 20, 1,1, 128, 128);
        skill1Btn = new PictureButton(ResourceManager.getInstance().getDrawable("btnSkill1"), Settings.getWidth() - 96, 150, 1,1, 96, 96);


        stage.addActor(moveControl.getTouchpad());
        stage.act(Gdx.graphics.getDeltaTime());

        camera = new OrthoCamera();
        InputController.getInstance().addInputProcessor(stage);


    }

    public void update(OrthoCamera gameCamera) {
        camera.update();
        stage.act(Gdx.graphics.getDeltaTime());


        if (moveControl.getTouchpad().isTouched()) {
           world.moveUpdate(moveControl.getTouchpad().getKnobPercentX(), moveControl.getTouchpad().getKnobPercentY());
        } else if (Gdx.input.isTouched(0)) {

            float touchX = camera.unprojectXCoordinate(Gdx.input.getX(), Gdx.input.getY());
            float touchY = camera.unprojectYCoordinate(Gdx.input.getX(), Gdx.input.getY());

            if (attackBtn.isPressed(touchX,touchY))
                world.attackPressed();
            else if (skill1Btn.isPressed(touchX,touchY))
                world.skill1Pressed();


        }
    }

    public void render(OrthoCamera gameCamera) {

        sb.setProjectionMatrix(camera.combined);
        sb.begin();

        ResourceManager.getInstance().getFont("font").draw(sb, "FPS: " + Gdx.graphics.getFramesPerSecond(), Settings.getWidth() - 60, Settings.getHeight() - 60);


        attackBtn.render(sb);
        skill1Btn.render(sb);

        sb.end();

        stage.draw();
    }

    public void renderBackground() {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.setColor(10, 10, 10, 0);
        sb.draw(bg, 0, 0);
        sb.setColor(Color.WHITE);
        sb.end();
    }

    private void moveTouchpad() {
        Touchpad tp = moveControl.getTouchpad();
        if (tp.isTouched())
        {
            camera.setPosition(camera.position.x + tp.getKnobPercentX() * 10, camera.position.y + tp.getKnobPercentY() * 10 );
        }
    }



    public void resume() {
        InputController.getInstance().addInputProcessor(stage);
    }

    public void dispose() {
        InputController.getInstance().removeInputProcessor(stage);
    }

    public void resize(int width, int height) {
        camera.resize(width, height);
    }

}
