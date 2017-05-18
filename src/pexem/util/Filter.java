package pexem.util;

import pexem.domain.StudentData;

public interface Filter {

	boolean acceptable ( StudentData data );
}
