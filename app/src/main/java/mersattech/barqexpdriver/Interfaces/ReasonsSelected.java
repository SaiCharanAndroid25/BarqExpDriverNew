package mersattech.barqexpdriver.Interfaces;

import android.app.Dialog;

/**
 * Created by Mersat-tech on 17/11/2017.
 */

public interface ReasonsSelected {

    void onReasonSelected(Dialog dialog, int position, String s);

    void onDismiss(Dialog dialog);
}
