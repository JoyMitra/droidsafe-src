package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface TextWatcher extends NoCopySpan {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSVerified
    public void beforeTextChanged(CharSequence s, int start,
                                  int count, int after);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSVerified
    public void onTextChanged(CharSequence s, int start, int before, int count);
    
    @DSVerified
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void afterTextChanged(Editable s);
}
