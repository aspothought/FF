package DBUtil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tdunham on 3/18/2015.
 */
public class FFDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="FF_DATA";

    public FFDatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        database.execSQL("CREATE TABLE expenses ( expense_id INTEGER PRIMARY KEY AUTOINCREMENT, amount INTEGER, expense_description TEXT, transaction_date DATETIME );");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS expenses");

        onCreate(db);

    }


}
