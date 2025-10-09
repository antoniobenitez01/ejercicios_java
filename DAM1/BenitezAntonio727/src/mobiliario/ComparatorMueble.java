package mobiliario;

import java.util.Comparator;

public class ComparatorMueble implements Comparator<Mueble>
{
	@Override
    public int compare(Mueble m1, Mueble m2)
    {
        return m1.compareTo(m2);
    }
}
