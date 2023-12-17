package deltazero.amarok.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.Objects;

import deltazero.amarok.Hider;
import deltazero.amarok.R;

public class ActionReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("ActionReceiver", "New action received.");

        if (Hider.state.getValue() == Hider.State.PROCESSING) {
            Log.w("ActionReceiver", "Already processing. Ignore the new action.");
            return;
        }

        if (Objects.equals(intent.getAction(), "deltazero.amarok.HIDE")) {
            Hider.hide(context);
        } else if (Objects.equals(intent.getAction(), "deltazero.amarok.UNHIDE")) {
            Hider.unhide(context);
        } else {
            Log.w("ActionReceiver", "Invalid action: " + intent.getAction());
            Toast.makeText(context, context.getString(R.string.invalid_action, intent.getAction()),
                    Toast.LENGTH_LONG).show();
        }
    }
}