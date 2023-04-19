package com.example.unscrambleapk;


import android.content.Context;
import android.util.*;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MainViewModel extends ViewModel {
    private String[] allWordsList = new String[]{"animal", "auto", "anecdote", "alphabet", "all", "awesome", "arise", "balloon", "basket", "bench", "best", "birthday", "book", "briefcase", "camera", "camping", "candle", "cat", "cauliflower", "chat", "children", "class", "classic", "classroom", "coffee", "colorful", "cookie", "creative", "cruise", "dance", "daytime", "dinosaur", "doorknob", "dine", "dream", "dusk", "eating", "elephant", "emerald", "eerie", "electric", "finish", "flowers", "follow", "fox", "frame", "free", "frequent", "funnel", "green", "guitar", "grocery", "glass", "great", "giggle", "haircut", "half", "homemade", "happen", "honey", "hurry", "hundred", "ice", "igloo", "invest", "invite", "icon", "introduce", "joke", "jovial", "journal", "jump", "join", "kangaroo", "keyboard", "kitchen", "koala", "kind", "kaleidoscope", "landscape", "late", "laugh", "learning", "lemon", "letter", "lily", "magazine", "marine", "marshmallow", "maze", "meditate", "melody", "minute", "monument", "moon", "motorcycle", "mountain", "music", "north", "nose", "night", "name", "never", "negotiate", "number", "opposite", "octopus", "oak", "order", "open", "polar", "pack", "painting", "person", "picnic", "pillow", "pizza", "podcast", "presentation", "puppy", "puzzle", "recipe", "release", "restaurant", "revolve", "rewind", "room", "run", "secret", "seed", "ship", "shirt", "should", "small", "spaceship", "stargazing", "skill", "street", "style", "sunrise", "taxi", "tidy", "timer", "together", "tooth", "tourist", "travel", "truck", "under", "useful", "unicorn", "unique", "uplift", "uniform", "vase", "violin", "visitor", "vision", "volume", "view", "walrus", "wander", "world", "winter", "well", "whirlwind", "x-ray", "xylophone", "yoga", "yogurt", "yoyo", "you", "year", "yummy", "zebra", "zigzag", "zoology", "zone", "zeal"};
    String FinalDis = "";
    int Random = (int) (Math.random() * (178));
    String newStr = allWordsList[Random];

    public MutableLiveData<String> Str = new MutableLiveData<>();


    public void generateString() {

        ArrayList<Character> Shuffle = new ArrayList<Character>();

        for (int i = 0; i < newStr.length(); i++) {
            Shuffle.add(newStr.charAt(i));
        }

        Log.i("generateString", String.valueOf(Shuffle));

        Collections.shuffle(Shuffle);
        Iterator<Character> itr = Shuffle.iterator();
        Log.i("generateString", String.valueOf(Shuffle));

        while (itr.hasNext()) {
            FinalDis += itr.next();
        }
        Str.setValue(FinalDis);

    }

    public void check(Context context , String val) {
        Log.i(FinalDis, val);

        if (val.equalsIgnoreCase(newStr)) {
            Toast.makeText(context,"Correct!",Toast.LENGTH_SHORT).show();
            Log.i("generateString", "Correct!");
            FinalDis = "";
            Random = (int) (Math.random() * (178));
            newStr = allWordsList[Random];
            generateString();
        }
        else{
            Toast.makeText(context,"Try Again!",Toast.LENGTH_SHORT).show();
        }
    }
}