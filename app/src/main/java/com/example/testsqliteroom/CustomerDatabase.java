package com.example.testsqliteroom;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Customer.class}, version = 2, exportSchema = false)
public abstract class CustomerDatabase extends RoomDatabase {
    public abstract CustomerDao customerDao();
    private static volatile CustomerDatabase INSTANCE;
    static CustomerDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CustomerDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(),
                                    CustomerDatabase.class, "customer_database")
                                    .build();
                }
            }
        }
        return INSTANCE;
    }
}
