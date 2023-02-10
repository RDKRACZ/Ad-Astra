package earth.terrarium.ad_astra.common.level;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class SoundUtil {

    private static boolean shouldPlay = false;

    public static boolean getSound() {
        return shouldPlay;
    }

    public static void setSound(boolean value) {
        shouldPlay = value;
    }
}