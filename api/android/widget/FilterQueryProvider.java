package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.database.Cursor;

public interface FilterQueryProvider {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Cursor runQuery(CharSequence constraint);
}
