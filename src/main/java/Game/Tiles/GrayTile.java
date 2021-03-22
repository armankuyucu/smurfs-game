package Game.Tiles;

import Game.Assets;

import java.awt.image.BufferedImage;

public class GrayTile extends Tile{
    public GrayTile(int id) {
        super(Assets.GrayTile, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
